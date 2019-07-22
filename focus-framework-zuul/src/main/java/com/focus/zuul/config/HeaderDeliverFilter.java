package com.focus.zuul.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * 自定义过滤器，向下游服务请求加header认证信息.
 * 与敏感头(设置向内部服务不传递哪些header正好相反)，
 *
 * 这种方式好像不能传递名称为 Authorization,Cookie,Set-Cookie 的请求头，这三个传递不到下游服务，这三个由敏感头管理，只能传递token这种自定义的头
 */
public class HeaderDeliverFilter extends ZuulFilter{
    @Override
    public String filterType() {
        //pre型过滤器，路由到下级服务前执行
        //FilterConstants常量类有各种类型 和顺序
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        //执行顺序
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        //是否执行，开关，还需要配置到spring容器才能起作用
        return true;
    }

    /**
     * 过滤逻辑，还需要配置到spring容器才能起作用
     *
     * pre过滤器在route过滤前执行，RequestContext负责通信包含了请求等信息，debug发现，context.addZuulRequestHeader增加了请求头，
     * 但在RibbonRoutingFilter 这个向下游服务发起请求的路由过滤器，自定义的header没有添加上。
     * RibbonRoutingFilter是默认的过滤器，run方法可以看到,逻辑是从原来的RequestContext生产新的RibbonCommandContext发起请求
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        //Zull的Filter链间通过RequestContext传递通信，内部采用ThreadLocal 保存每个请求的信息，
        //包括请求路由、错误信息、HttpServletRequest\response等
        RequestContext context = RequestContext.getCurrentContext();
        String cookie = getHttpServletRequest().getHeader("Cookie");
        context.addZuulRequestHeader("Cookie",cookie);
        String cookie1 = context.getRequest().getHeader("Cookie");

        return null;
    }

    private HttpServletRequest getHttpServletRequest() {
        try {
            return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        } catch (Exception var2) {
            return null;
        }
    }
}
