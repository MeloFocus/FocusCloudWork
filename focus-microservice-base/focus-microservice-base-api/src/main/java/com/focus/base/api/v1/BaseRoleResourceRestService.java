package com.focus.base.api.v1;

import com.focus.base.FocusMicroBaseConstants;
import com.focus.base.vm.BaseRoleResourceSaveVM;
import com.focus.framework.utils.Message;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = FocusMicroBaseConstants.SERVICE_APP_ID)
@RequestMapping("/baseRoleResource")
public interface BaseRoleResourceRestService {

    @PostMapping("/authorize")
    Message<String> authorize(BaseRoleResourceSaveVM roleResourceSaveVM);
}
