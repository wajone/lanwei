package com.sifunit.lanwei.service;

import com.sifunit.lanwei.domain.Perm;

import java.util.List;

public interface IPermService extends IBaseService<Perm> {
    List<Perm> getPermList(Integer userId);
}
