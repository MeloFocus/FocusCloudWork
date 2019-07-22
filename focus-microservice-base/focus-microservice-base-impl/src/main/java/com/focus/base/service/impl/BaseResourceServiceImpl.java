package com.focus.base.service.impl;

import com.focus.base.FocusMicroBaseConstants;
import com.focus.base.config.FocusBaseThreadPool;
import com.focus.base.domain.basic.BaseResource;
import com.focus.base.mapper.basic.BaseResourceMapper;
import com.focus.base.mapper.extend.BaseResourceExtendMapper;
import com.focus.base.service.BaseResourceService;
import com.focus.base.util.ShiroUtils;
import com.focus.base.vm.BaseResourceTreeVM;
import com.focus.base.vm.BaseResourceVM;
import com.focus.base.vm.BaseUserVM;
import com.focus.framework.utils.EntityUtils;
import org.redisson.api.RMapCache;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Transactional
public class BaseResourceServiceImpl implements BaseResourceService {

    @Autowired
    BaseResourceExtendMapper resourceExtendMapper;

    @Autowired
    BaseResourceMapper baseResourceMapper;

    @Autowired
    RedissonClient redissonClient;

    /**
     * 查询当前用户具有权限的一级模块菜单
     * @return
     */
    @Override
    public List<BaseResourceVM> indexResource() {
        BaseUserVM baseUserVM = ShiroUtils.currentUser();

        //先到缓存拿数据
        RMapCache<String, Map<String,List<BaseResourceVM>>> resourceMapCache = redissonClient.getMapCache(FocusMicroBaseConstants.REDIS_RESOURCE_TREE);
        //lambada 引用的变量必须是用final修饰，不能直接改，通过final数组方式间接改动
        final Map<String, List<BaseResourceVM>>[] userMap = new Map[]{resourceMapCache.get(baseUserVM.getId())};
        if (userMap[0]!=null&&userMap[0].get("index")!=null)
            return userMap[0].get("index");

        //查询数据,这用了CompletableFuture增加了无用的上下文切换，应该直接用主线程查询，子线程放缓存。CompletableFuture 会用指定的线程池执行，不指定也有默认的线程池
        CompletableFuture<List<BaseResourceVM>> future = CompletableFuture.supplyAsync(() -> {
            List<BaseResourceVM> list = null;
            if (baseUserVM.getSuperman().equals(true)) {
                list = EntityUtils.entity2VMList(resourceExtendMapper.selectAllIndxResource(), BaseResourceVM.class);
            } else {
                list = EntityUtils.entity2VMList(resourceExtendMapper.selectIndexResourceByUserId(baseUserVM.getId()), BaseResourceVM.class);
            }
            return list;
        }, FocusBaseThreadPool.getTreadPool());

        //异步放入缓存,这不加线程池，就继续用上边future的线程执行，加了就用线程池中的线程执行。
        future.thenAcceptAsync((list)->{
            if (userMap[0] ==null)
                userMap[0] = new HashMap<String,List<BaseResourceVM>>();
            userMap[0].put("index",list);
            resourceMapCache.put(baseUserVM.getId(),userMap[0]);
        },FocusBaseThreadPool.getTreadPool());


        List<BaseResourceVM> baseResourceVMS =null;
        try {
             baseResourceVMS = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return baseResourceVMS;
    }

    @Override
    public List<BaseResourceVM> resourcesInModule(String moduleCode) {
        BaseUserVM baseUserVM = ShiroUtils.currentUser();

        List<BaseResource> list = null;
        if(baseUserVM.getSuperman()){
            list = resourceExtendMapper.getResourcesByModule(moduleCode);
        }else{
            list = resourceExtendMapper.getResourcesByModuleAndUserId(moduleCode,baseUserVM.getId());
        }
        List<BaseResourceVM> resourceVMS = EntityUtils.entity2VMList(list, BaseResourceVM.class);
        return resourceVMS;
    }



    @Override
    public List<BaseResourceTreeVM> resourceTree() {
        List<BaseResource> resourceList = baseResourceMapper.selectAll();
        List<BaseResourceTreeVM> treeVMS = resourceList.stream()
                .map(r -> EntityUtils.entity2VM(r, BaseResourceTreeVM.class))
                .collect(Collectors.toList());

        Map<String, BaseResourceTreeVM> reourceMap = treeVMS.stream()
                .collect(Collectors.toMap(BaseResourceTreeVM::getId, Function.identity()));

        List<BaseResourceTreeVM> root = new ArrayList<>();

        treeVMS.forEach(resource->{
            if (resource.getPid().equals("-1"))
                root.add(resource);
            else{
                BaseResourceTreeVM parentResouce = reourceMap.get(resource.getPid());
                List<BaseResourceTreeVM> childrenList = parentResouce.getChildrenList();
                if (childrenList==null)
                    childrenList = new ArrayList<>();
                childrenList.add(resource);
                parentResouce.setChildrenList(childrenList);
            }
        });
        return root;
    }
}
