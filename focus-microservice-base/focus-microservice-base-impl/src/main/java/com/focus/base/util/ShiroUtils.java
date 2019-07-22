package com.focus.base.util;

import com.focus.base.vm.BaseUserVM;
import com.focus.framework.utils.EntityUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;

public class ShiroUtils {

    public static Subject getSubjct(){
        return SecurityUtils.getSubject();
    }


    public static BaseUserVM currentUser(){
//        return (BaseUserVM) SecurityUtils.getSubject().getPrincipal();
        Object principal = SecurityUtils.getSubject().getPrincipal();
        return EntityUtils.entity2VM(principal,BaseUserVM.class);
    }

    /**
     * 切换身份，登录后，实时动态更改subject的用户属性
     * @param userInfo
     */
    public static void setUser(BaseUserVM userInfo) {
        Subject subject = SecurityUtils.getSubject();
        PrincipalCollection principalCollection = subject.getPrincipals();
        String realmName = principalCollection.getRealmNames().iterator().next();
        PrincipalCollection newPrincipalCollection =
                new SimplePrincipalCollection(userInfo, realmName);
        subject.runAs(newPrincipalCollection);
    }

}
