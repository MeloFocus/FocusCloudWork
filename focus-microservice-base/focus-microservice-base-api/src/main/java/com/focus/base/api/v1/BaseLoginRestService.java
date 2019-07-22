package com.focus.base.api.v1;

import com.focus.base.FocusMicroBaseConstants;
import com.focus.base.vm.LoginUserVM;
import com.focus.framework.utils.Message;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author Melo
 * @Date 2019/6/7 0007 上午 10:03
 */
@FeignClient(name = FocusMicroBaseConstants.SERVICE_APP_ID)
public interface BaseLoginRestService {

    //返回登录页面
    @GetMapping("/loginpage")
    public String loginPage();

    //登录接口
    @PostMapping("/login")
    public Message<String> login(LoginUserVM loginUser);

    //退出登录
    @PostMapping("/loginout")
    public Message<String> loginOut();
}
