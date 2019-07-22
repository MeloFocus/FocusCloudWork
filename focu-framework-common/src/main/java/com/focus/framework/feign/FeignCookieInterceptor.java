package com.focus.framework.feign;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 用Feign发新请求，原请求的header cookie都默认没有，需要自己设置
 */
@Component
public class FeignCookieInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        if (null == getHttpServletRequest()){
            return;
        }
        //requestTemplate 好像没有直接设置cookie对象的地方，但cookie其实是header中的
        //Cookie[] cookies = getHttpServletRequest().getCookies();

        requestTemplate.header("Cookie",getHttpServletRequest().getHeader("Cookie"));
    }

    /**
     * RequestContextHolder从当前线程中获取请求，又用了线程副本
     * @return
     */
    private HttpServletRequest getHttpServletRequest(){
        try{
            return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        }catch (Exception e){
            return null;
        }
    }
}
