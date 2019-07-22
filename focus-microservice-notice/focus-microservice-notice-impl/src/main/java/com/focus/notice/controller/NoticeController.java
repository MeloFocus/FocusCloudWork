package com.focus.notice.controller;

import com.focus.base.api.v1.BaseAuthorityRestService;
import com.focus.base.api.v1.BaseUserRestService;
import com.focus.framework.utils.SpringUtil;
import com.focus.notice.api.v1.NoticeRestService;
import com.focus.notice.service.rest.v1.BaseUserRemoteRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticeController implements NoticeRestService {

    @Autowired
    private BaseUserRestService base;

    @Override
    public String getNotice() {
        String user = base.getUser();
        BaseAuthorityRestService bean = SpringUtil.getBean(BaseAuthorityRestService.class);
        System.out.println(bean);
        return user + "notice";
    }

}
