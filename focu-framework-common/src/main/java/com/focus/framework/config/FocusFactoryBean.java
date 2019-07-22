package com.focus.framework.config;

import com.focus.framework.exception.GlobalExceptionHandler;
import org.springframework.beans.factory.FactoryBean;

/**
 * 用spring提供的工厂注册实例，然后将此类注入spring，GlobalExceptionHandler就也会被注入容器
 */
public class FocusFactoryBean implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        //返回实例
        return new GlobalExceptionHandler();
    }

    @Override
    public Class<?> getObjectType() {
        //实例类型
        return GlobalExceptionHandler.class;
    }

    //是不是单例
    @Override
    public boolean isSingleton() {
        return true;
    }
}
