package com.focus.notice.api.v1;

import com.focus.notice.FocusMicroNoticeConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = FocusMicroNoticeConstants.SERVICE_APP_ID)
public interface NoticeRestService {

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String getNotice();
}
