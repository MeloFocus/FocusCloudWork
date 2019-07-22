package com.focus.notice;

import com.focus.notice.vm.Testt;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("hello")
    public String hello(){
        Testt t= new Testt();
        return "hello";
    }

    @GetMapping("/notice")
    public String test(){
        return "noticetest";
    }

    @GetMapping("/notice1")
    @RequiresPermissions("dd")
    public String test1(){
        return "noticetest";
    }

}
