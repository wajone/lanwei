package com.sifunit.lanwei.service;

import com.github.pagehelper.PageInfo;
import com.sifunit.lanwei.common.Page;
import com.sifunit.lanwei.domain.ProductionPlan;
import org.springframework.ui.Model;

import java.util.List;

public interface IProductionService extends IBaseService<ProductionPlan> {
    List<ProductionPlan> list();

    PageInfo<ProductionPlan> getPageInfo(Page page, Model model);
}
