package com.focus.base.domain.basic;

public class BaseUserRoleR {
    private String id;

    private String userId;

    private String roleId;

    private String ywId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getYwId() {
        return ywId;
    }

    public void setYwId(String ywId) {
        this.ywId = ywId;
    }

    public BaseUserRoleR() {
    }

    public BaseUserRoleR(String id, String userId, String roleId, String ywId) {
        this.id = id;
        this.userId = userId;
        this.roleId = roleId;
        this.ywId = ywId;
    }
}