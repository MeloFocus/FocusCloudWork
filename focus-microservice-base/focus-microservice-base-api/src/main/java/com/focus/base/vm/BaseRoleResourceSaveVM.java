package com.focus.base.vm;

import javax.validation.constraints.NotNull;
import java.util.List;

public class BaseRoleResourceSaveVM {

    @NotNull
    private List<String> roleIds;

    @NotNull
    private List<String> resourceIds;

    public List<String> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<String> roleIds) {
        this.roleIds = roleIds;
    }

    public List<String> getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(List<String> resourceIds) {
        this.resourceIds = resourceIds;
    }
}
