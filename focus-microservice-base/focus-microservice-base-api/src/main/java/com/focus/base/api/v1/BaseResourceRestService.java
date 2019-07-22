package com.focus.base.api.v1;

import com.focus.base.FocusMicroBaseConstants;
import com.focus.base.vm.BaseResourceTreeVM;
import com.focus.base.vm.BaseResourceVM;
import com.focus.framework.utils.Message;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Description
 * @Author Melo
 * @Date 2019/6/7 0007 下午 2:46
 */
@FeignClient(name = FocusMicroBaseConstants.SERVICE_APP_ID)
@RequestMapping("/baseResource")
public interface BaseResourceRestService {

    @GetMapping("/indexResource")
    Message<List<BaseResourceVM>> indexResource();

    @GetMapping("/resourcesInModule")
    Message<List<BaseResourceVM>> resourcesInModule(String moduleCode);

    //查询资源树
    @GetMapping("/resourceTree")
    Message<List<BaseResourceTreeVM>> resourceTrre();

}
