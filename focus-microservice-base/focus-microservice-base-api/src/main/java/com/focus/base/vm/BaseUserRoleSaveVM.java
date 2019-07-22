package com.focus.base.vm;

import javax.validation.constraints.NotNull;
import java.util.List;

public class BaseUserRoleSaveVM {

    private List<String> userIds;

    private List<String> roleIds;

    public List<String> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<String> userIds) {
        this.userIds = userIds;
    }

    public List<String> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<String> roleIds) {
        this.roleIds = roleIds;
    }
}
