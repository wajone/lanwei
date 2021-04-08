package com.sifunit.lanwei.service.impl;

import com.github.pagehelper.PageInfo;
import com.sifunit.lanwei.common.Page;
import com.sifunit.lanwei.domain.Unit;
import com.sifunit.lanwei.mapper.IBaseMapper;
import com.sifunit.lanwei.mapper.UnitMapper;
import com.sifunit.lanwei.service.IUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class UnitServiceImpl extends BaseServiceImpl<Unit> implements IUnitService {

    @Autowired
    UnitMapper unitMapper;

    @Override
    public IBaseMapper<Unit> getMapper() {
        return unitMapper;
    }


    @Override
    public PageInfo<Unit> getPage(Page page, Model model) {
        return null;
    }
}
