package com.focus.zuul.controller;

import com.focus.framework.utils.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class FocusErrorController {

/*    @GetMapping("/error")
    public Message<String> error(HttpServletRequest request, HttpServletResponse response){
        String errorMessage = (String)request.getAttribute("errorMessage");
        return Message.ok(errorMessage,500);
    }*/

    @GetMapping("/error")
    public Message<String> error(){
        return Message.ok("sss",500);
    }
}
