package com.focus.base.vm;

import javax.validation.constraints.Min;

public class BaseRoleSearchVM {
    @Min(value=1)
    private Integer page;

    private Integer limit;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}

