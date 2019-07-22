package com.focus.notice.service.rest.v1;

import com.focus.base.FocusMicroBaseConstants;
import com.focus.base.api.v1.BaseUserRestService;
import org.springframework.cloud.openfeign.FeignClient;

//@FeignClient(name = FocusMicroBaseConstants.SERVICE_APP_ID,fallback = BaseUserRemoteRestServiceHystrix.class)
public interface BaseUserRemoteRestService extends BaseUserRestService {
}
