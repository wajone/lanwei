package com.sifunit.lanwei.service.impl;

import com.sifunit.lanwei.mapper.IBaseMapper;
import com.sifunit.lanwei.service.IBaseService;

public abstract class BaseServiceImpl<T> implements IBaseService<T> {

    public abstract IBaseMapper<T> getMapper();
    @Override
    public int deleteByPrimaryKey(Long orgId) {
        return getMapper().deleteByPrimaryKey(orgId);
    }

    @Override
    public int insert(T t) {
        return getMapper().insert(t);
    }

    @Override
    public int insertSelective(T t) {
        return getMapper().insertSelective(t);
    }

    @Override
    public T selectByPrimaryKey(Long orgId) {
        return getMapper().selectByPrimaryKey(orgId);
    }

    @Override
    public int updateByPrimaryKeySelective(T t) {
        return getMapper().updateByPrimaryKeySelective(t);
    }

    @Override
    public int updateByPrimaryKey(T t) {
        return getMapper().updateByPrimaryKey(t);
    }
}
