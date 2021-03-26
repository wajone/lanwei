package com.sifunit.lanwei.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sifunit.lanwei.common.Page;
import com.sifunit.lanwei.domain.ProceCate;
import com.sifunit.lanwei.mapper.IBaseMapper;
import com.sifunit.lanwei.mapper.ProceCateMapper;
import com.sifunit.lanwei.service.IProceCateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class ProceCateServiceImpl extends BaseServiceImpl<ProceCate> implements IProceCateService {
    @Autowired
    ProceCateMapper proceCateMapper;
    @Override
    public IBaseMapper<ProceCate> getMapper() {
        return proceCateMapper;
    }

    @Override
    public PageInfo<ProceCate> getPage(Page page, Model model) {
        PageHelper.startPage(page.getCurrentPage(), page.getPageSize());
        List<ProceCate> list = proceCateMapper.list();
        PageInfo<ProceCate> pageInfo = new PageInfo<>(list);
        System.out.println(page.getPageSize());
        return pageInfo;
    }
}
