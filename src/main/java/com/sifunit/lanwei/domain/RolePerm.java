package com.sifunit.lanwei.domain;

public class RolePerm {
    private Integer roleId;

    private Integer permId;

    public RolePerm(Integer roleId, Integer permId) {
        this.roleId = roleId;
        this.permId = permId;
    }

    public RolePerm() {
        super();
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermId() {
        return permId;
    }

    public void setPermId(Integer permId) {
        this.permId = permId;
    }
}