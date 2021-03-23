package com.sifunit.lanwei.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sifunit.lanwei.common.Page;
import com.sifunit.lanwei.domain.ProductionPlan;
import com.sifunit.lanwei.mapper.IBaseMapper;
import com.sifunit.lanwei.mapper.ProductionPlanMapper;
import com.sifunit.lanwei.service.IProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class ProductionServiceImpl extends BaseServiceImpl<ProductionPlan> implements IProductionService {

    @Autowired
    ProductionPlanMapper productonPlanMapper;
    @Override
    public IBaseMapper<ProductionPlan> getMapper() {
        return productonPlanMapper;
    }

    @Override
    public List<ProductionPlan> list() {
        return productonPlanMapper.list();
    }

    @Override
    public PageInfo<ProductionPlan> getPageInfo(Page page, Model model) {
        PageHelper.startPage(page.getCurrentPage(), page.getPageSize());
        List<ProductionPlan> list = productonPlanMapper.list();
        PageInfo<ProductionPlan> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
