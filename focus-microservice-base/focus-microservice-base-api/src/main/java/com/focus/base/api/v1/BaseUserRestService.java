package com.focus.base.api.v1;

import com.focus.base.FocusMicroBaseConstants;
import com.focus.base.api.v1.hystrix.BaseUserRestServiceHystrix;
import com.focus.base.vm.*;
import com.focus.framework.utils.Message;
import com.github.pagehelper.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = FocusMicroBaseConstants.SERVICE_APP_ID,fallback = BaseUserRestServiceHystrix.class)
@RequestMapping("/baseUser")
public interface BaseUserRestService {

    //?
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String getUser();

    @RequestMapping(value="/user",method = RequestMethod.POST)
    public Message<String>createUser(BaseUserCreateVM userCreateVM);

    @PutMapping("/user")
    public Message<String>updateUser(BaseUserUpdateVM userCreateVM);

    @DeleteMapping("/user/{userIds}")
    public Message<String> deleteUser(@PathVariable("userIds") String userIds);

    @GetMapping("/user/list")
    public Message<PageInfo<BaseUserListVM>> userList(BaseUserSearchVM serarch);

    @GetMapping("/detail")
    public Message<BaseUserVM> detail(String userId);
}
