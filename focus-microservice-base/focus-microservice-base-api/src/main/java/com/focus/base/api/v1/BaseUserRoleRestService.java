package com.focus.base.api.v1;

import com.focus.base.FocusMicroBaseConstants;
import com.focus.base.vm.BaseRoleAuthorizeListVM;
import com.focus.base.vm.BaseRoleVM;
import com.focus.base.vm.BaseUserRoleSaveVM;
import com.focus.framework.utils.Message;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = FocusMicroBaseConstants.SERVICE_APP_ID)
@RequestMapping("/baseUserRole")
public interface BaseUserRoleRestService {

    @PostMapping("/authoiize")
    Message<String> authorize(BaseUserRoleSaveVM baseUserRoleSaveVM);

    @GetMapping("/roleOfUser")
    Message<List<BaseRoleVM>> roleOfUser(String userId);

    @GetMapping("/roleList")
    Message<List<BaseRoleAuthorizeListVM>> roleAuthorizeList(String userId);
}
