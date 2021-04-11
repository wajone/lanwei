package com.sifunit.lanwei.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sifunit.lanwei.common.Page;
import com.sifunit.lanwei.common.SysResult;
import com.sifunit.lanwei.domain.Bom;
import com.sifunit.lanwei.domain.Labor;
import com.sifunit.lanwei.mapper.BomMapper;
import com.sifunit.lanwei.mapper.IBaseMapper;
import com.sifunit.lanwei.service.IBomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;


@Service
public class BomServiceImpl extends BaseServiceImpl<Bom> implements IBomService {

    @Autowired
    BomMapper bomMapper;

    @Override
    public IBaseMapper<Bom> getMapper() {
        return bomMapper;
    }

    @Override
    public PageInfo<Bom> getPage(Page page, Model model) {
        PageHelper.startPage(page.getCurrentPage(), page.getPageSize());
        List<Bom> list = bomMapper.list();
        PageInfo<Bom> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public SysResult delById(Long laborId) {
        return null;
    }
}
