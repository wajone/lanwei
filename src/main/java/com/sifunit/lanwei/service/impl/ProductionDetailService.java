package com.sifunit.lanwei.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sifunit.lanwei.common.Page;
import com.sifunit.lanwei.mapper.ProductionDetailMapper;
import com.sifunit.lanwei.vo.ProductionDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class ProductionDetailService {
    @Autowired
    ProductionDetailMapper productionDetailMapper;

    public PageInfo<ProductionDetail> getPageInfo(Page page, Model model) {
        PageHelper.startPage(page.getCurrentPage(), page.getPageSize());
        List<ProductionDetail> list = productionDetailMapper.list();
        PageInfo<ProductionDetail> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
