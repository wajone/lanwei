package com.sifunit.lanwei.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sifunit.lanwei.common.Page;
import com.sifunit.lanwei.domain.GoodCate;
import com.sifunit.lanwei.domain.MaterialCate;
import com.sifunit.lanwei.mapper.GoodCateMapper;
import com.sifunit.lanwei.mapper.IBaseMapper;
import com.sifunit.lanwei.service.IGoodCateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class GoodCateServiceImpl extends BaseServiceImpl<GoodCate> implements IGoodCateService {

    @Autowired
    GoodCateMapper goodCateMapper;

    @Override
    public IBaseMapper<GoodCate> getMapper() {
        return goodCateMapper;
    }

    @Override
    public PageInfo<GoodCate> getPage(Page page, Model model) {
        PageHelper.startPage(page.getCurrentPage(), page.getPageSize());
        List<GoodCate> list = goodCateMapper.list();
        PageInfo<GoodCate> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
