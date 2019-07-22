package com.focus.base.controller;

import com.focus.base.FocusMicroBaseConstants;
import com.focus.base.api.v1.BaseLoginRestService;
import com.focus.base.util.ShiroUtils;
import com.focus.base.vm.LoginUserVM;
import com.focus.framework.utils.Asserts;
import com.focus.framework.utils.Message;
import io.swagger.annotations.Api;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description
 * @Author Melo
 * @Date 2019/6/7 0007 上午 10:02
 */
@Controller
@Api()
public class LoginController implements BaseLoginRestService {

    @Override
    public String loginPage() {
        return "login";
    }

    public String he(){
        return "he";
    }

    @Override
    @ResponseBody
    public Message<String> login(LoginUserVM loginUser) throws IncorrectCredentialsException {
        Asserts.notEmpty(loginUser,"登录用户不能为空");
        String account=loginUser.getLoginName();
        String password=loginUser.getPassword();
        UsernamePasswordToken token = new UsernamePasswordToken(account,password,false);
        token.setRememberMe(true);

        Subject currentUser = SecurityUtils.getSubject();
        try {
            currentUser.login(token);
        } catch(IncorrectCredentialsException e){
            return Message.ok("密码错误",500);
        } catch (AuthenticationException e) {
//            return Message.ok("登录失败");
            return Message.ok(e.getMessage(),500);
        }

        return Message.ok(FocusMicroBaseConstants.SUCCESS);
    }

    @Override
    @ResponseBody
    public Message<String> loginOut() {
        ShiroUtils.getSubjct().logout();
        return Message.ok(FocusMicroBaseConstants.SUCCESS);
    }
}
