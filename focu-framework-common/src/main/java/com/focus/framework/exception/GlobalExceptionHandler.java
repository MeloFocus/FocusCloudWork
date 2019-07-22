package com.focus.framework.exception;

import com.focus.framework.utils.Message;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice//@ControllerAdvice拦截异常
@ResponseBody
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 数据校验异常（说明是我自己跑出的，业务上的异常）shiro异常（未授权等等）这些异常让用户看到
     * @param request
     * @param exception
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value= {DataValidateFiledException.class})
    public Message<String> DataValidateExceptionHandler(HttpServletRequest request,Exception exception) throws Exception {

        String string = exception.getMessage();
        logger.error(string,exception);
        return Message.ok(string,500);

    }

    @ExceptionHandler(value= {UnauthenticatedException.class})
    public Message<String> AuthExceptionHandler(HttpServletRequest request,Exception exception) throws Exception {
        String string = exception.getMessage();
        logger.error(string,exception);
        return Message.ok("未认证",502);
    }


    @ExceptionHandler(value= {AuthorizationException.class})
    public Message<String> AuthorExceptionHandler(HttpServletRequest request,Exception exception) throws Exception {
        String string = exception.getMessage();
        logger.error(string,exception);
        return Message.ok("未授权",500);
    }


    /**
     * 不属于上个拦截异常的，大概率是代码问题，就抛出服务器异常
     * @param request
     * @param exception
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value=Exception.class)
    public Message<String> allExceptionHandler(HttpServletRequest request,
                                               Exception exception) throws Exception {

        String string = exception.toString();
        logger.error(string,exception);
        return Message.ok("服务器异常",500);

    }
}