package com.focus.uaa.config;

import com.focus.base.api.v1.BaseAuthorityRestService;
import com.focus.base.vm.BaseAuthorityVM;
import com.focus.base.vm.BaseUserVM;
import com.focus.framework.utils.Message;
import com.focus.framework.utils.SpringUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.List;

public class ShiroClientRealm extends AuthorizingRealm {

    //这里没有直接注入实例，ShiroClientRealm被用在配置类中，直接注入报servercontext not set 的错。只能使用时从spring容器中拿
    private BaseAuthorityRestService baseAuthorityRestService;

    Boolean cachingEnabled=true;

    /**
     * 1.授权方法，在请求需要操作码的接口时会执行此方法。不需要操作码的接口不会执行
     * 2.实际上是 先执行 AuthorizingRealm，自定义realm的父类中的 getAuthorizationInfo方法，
     * 逻辑是先判断缓存中是否有用户的授权信息（用户拥有的操作码），如果有 就直返回不调用自定义 realm的授权方法了，
     * 如果没缓存，再调用自定义realm，去数据库查询。
     * 用库查询一次过后，如果 在安全管理器中注入了 缓存，授权信息就会自动保存在缓存中，下一次调用需要操作码的接口时，
     * 就肯定不会再调用自定义realm授权方法了。   网上有分析AuthorizingRealm，shiro使用缓存的过程
     * 3.AuthorizingRealm 有多个实现类realm，推测可能是把 自定义realm注入了安全管理器，所以才调用自定义的
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();
        BaseUserVM user = (BaseUserVM)principals.getPrimaryPrincipal();

        if(user.getSuperman()){//超管
            simpleAuthorInfo.addStringPermission("administrator");
//            //List list=new ArrayList<>();
//            //list.add("ACTUATOR");
//            //simpleAuthorInfo.addRoles(list);//actuator监控 后提示需要加这个角色才能访问/beans等端点
        }else{

            //这里没有直接注入实例，ShiroClientRealm被用在配置类中new出的，直接注入报servercontext not set 的错。只能使用时从spring容器中拿
            baseAuthorityRestService = SpringUtil.getBean(BaseAuthorityRestService.class);

            Message<List<BaseAuthorityVM>> message = baseAuthorityRestService.getAuthorityByUser(user.getId());
            if(message!=null&&message.getData()!=null){
                List<BaseAuthorityVM> authorityVMList = message.getData();
                for (BaseAuthorityVM authority:authorityVMList) {
                    simpleAuthorInfo.addStringPermission(authority.getAuthorityCode());
                }
            }
        }
        return simpleAuthorInfo;
    }

    /**
     * 这个方法不会被调用，会到base服务校验是否登录
     * @Author:Melo
     * @Date: 2019/6/10 0010
    **/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authcToken) throws AuthenticationException {
        return null;
    }
}
