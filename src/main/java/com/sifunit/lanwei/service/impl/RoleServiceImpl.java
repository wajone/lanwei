package com.sifunit.lanwei.service.impl;

import com.sifunit.lanwei.domain.Role;
import com.sifunit.lanwei.mapper.IBaseMapper;
import com.sifunit.lanwei.mapper.RoleMapper;
import com.sifunit.lanwei.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RoleServiceImpl extends BaseServiceImpl<Role> implements IRoleService {
    @Autowired
    RoleMapper roleMapper;

    @Override
    public IBaseMapper<Role> getMapper() {
        return roleMapper;
    }

    @Override
    public List<Role> getRoleList(Integer userId) {
        return roleMapper.getRoleList(userId);
    }

}
