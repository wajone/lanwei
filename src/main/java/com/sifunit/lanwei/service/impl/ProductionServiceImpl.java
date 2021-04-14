package com.sifunit.lanwei.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sifunit.lanwei.common.Page;
import com.sifunit.lanwei.domain.Production;
import com.sifunit.lanwei.mapper.IBaseMapper;
import com.sifunit.lanwei.mapper.ProductionMapper;
import com.sifunit.lanwei.service.IProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class ProductionServiceImpl extends BaseServiceImpl<Production> implements IProductionService {

    @Autowired
    ProductionMapper productionMapper;

    @Override
    public IBaseMapper<Production> getMapper() {
        return productionMapper;
    }

    @Override
    public PageInfo<Production> getPageInfo(Page page, Model model) {
        PageHelper.startPage(page.getCurrentPage(), page.getPageSize());
        List<Production> list = productionMapper.list();
        PageInfo<Production> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<Production> listproductions() {
        List<Production> list = productionMapper.list();
        PageInfo<Production> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
