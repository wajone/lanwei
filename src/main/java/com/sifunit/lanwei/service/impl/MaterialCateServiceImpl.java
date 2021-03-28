package com.sifunit.lanwei.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sifunit.lanwei.common.Page;
import com.sifunit.lanwei.domain.MaterialCate;
import com.sifunit.lanwei.mapper.IBaseMapper;
import com.sifunit.lanwei.mapper.MaterialCateMapper;
import com.sifunit.lanwei.service.IMaterialCateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class MaterialCateServiceImpl extends BaseServiceImpl<MaterialCate> implements IMaterialCateService {
    @Autowired
    MaterialCateMapper materialCateMapper;
    @Override
    public IBaseMapper<MaterialCate> getMapper() {
        return materialCateMapper;
    }

    @Override
    public PageInfo<MaterialCate> getPage(Page page, Model model) {
        PageHelper.startPage(page.getCurrentPage(), page.getPageSize());
        List<MaterialCate> list = materialCateMapper.list();
        PageInfo<MaterialCate> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
