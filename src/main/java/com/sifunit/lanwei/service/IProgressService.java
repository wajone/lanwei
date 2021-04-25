package com.sifunit.lanwei.service;

import com.sifunit.lanwei.domain.Progress;

import java.util.List;

public interface IProgressService extends IBaseService<Progress> {
    int insertProress(List<Progress> progress);
}
