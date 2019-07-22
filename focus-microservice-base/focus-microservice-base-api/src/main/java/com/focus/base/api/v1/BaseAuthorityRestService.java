package com.focus.base.api.v1;

import com.focus.base.FocusMicroBaseConstants;
import com.focus.base.vm.BaseAuthorityVM;
import com.focus.framework.utils.Message;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @Description
 * @Author Melo
 * @Date 2019/6/7 0007 下午 2:47
 */
@FeignClient(name = FocusMicroBaseConstants.SERVICE_APP_ID)
public interface BaseAuthorityRestService {

    //这个没有权限
    @GetMapping("/getAuthorityByUser")
    public Message<List<BaseAuthorityVM>> getAuthorityByUser(String userId);

}
