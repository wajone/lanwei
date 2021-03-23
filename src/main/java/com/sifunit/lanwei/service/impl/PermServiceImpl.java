package com.sifunit.lanwei.service.impl;

import com.sifunit.lanwei.domain.Perm;
import com.sifunit.lanwei.domain.Role;
import com.sifunit.lanwei.mapper.IBaseMapper;
import com.sifunit.lanwei.mapper.PermMapper;
import com.sifunit.lanwei.service.IPermService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PermServiceImpl extends BaseServiceImpl<Perm> implements IPermService {

    @Autowired
    PermMapper permMapper;

    @Override
    public IBaseMapper<Perm> getMapper() {
        return permMapper;
    }

    @Override
    public List<Perm> getPermList(Integer userId) {
        return permMapper.getPermList(userId);
    }
}
