package com.focus.zuul.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.ribbon.RibbonHttpResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StreamUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.ERROR_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.POST_TYPE;

/**
 * 本想用来做下游服务统一的异常处理，后发现springboot 如果出异常默认进入error接口，到不了zuul，需继承ErrorController或单独异常拦截。
 * SendErrorFilter zuul的异常过滤器 处理的是过滤器周期中的异常，下游服务出现异常似乎不会进入zuul的error过滤器。
 * 而且zuul过滤环节抛出的异常最后都被处理成了ZuulException，比如获取不到服务、响应超时等等最后都会抛出ZuulException
 */
//@Configuration
public class FocusErrorFilter extends ZuulFilter {

    @Value("${zuul.errorControllerUrl}")
    private String errorController;

    @Override
    public String filterType() {
        //
        return ERROR_TYPE;
//        return  POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return 1001;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context  = RequestContext.getCurrentContext();
        Throwable throwable = context.getThrowable();

        HttpServletRequest request = context.getRequest();

        String responseBody = context.getResponseBody();
        HttpServletResponse response = context.getResponse();
        context.getResponseStatusCode();
        InputStream responseDataStream = context.getResponseDataStream();
//        try {
//            String s = StreamUtils.copyToString(responseDataStream, Charset.forName("UTF-8"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //读取响应中的内容
        try {
            Object zuulResponse = RequestContext.getCurrentContext().get("zuulResponse");
            if (zuulResponse != null) {
                RibbonHttpResponse resp = (RibbonHttpResponse) zuulResponse;
                String body = StreamUtils.copyToString(resp.getBody(), Charset.forName("UTF-8"));
                System.err.println(body);
                resp.close();
                RequestContext.getCurrentContext().setResponseBody(body);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("error");
//        try {
//            requestDispatcher.forward(request,context.getResponse());
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return null;
    }
}
