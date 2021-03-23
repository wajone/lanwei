package com.sifunit.lanwei.service;

import com.sifunit.lanwei.domain.Role;

import java.util.List;

public interface IRoleService extends IBaseService<Role> {

    List<Role> getRoleList(Integer userId);
}
