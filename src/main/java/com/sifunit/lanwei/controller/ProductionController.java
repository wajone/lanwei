package com.sifunit.lanwei.controller;

import com.github.pagehelper.PageInfo;
import com.sifunit.lanwei.common.Page;
import com.sifunit.lanwei.domain.Production;
import com.sifunit.lanwei.service.IProductionService;
import com.sifunit.lanwei.service.impl.ProductionDetailService;
import com.sifunit.lanwei.vo.ProductionDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("pro")
public class ProductionController {

    @Autowired
    ProductionDetailService productionDetailService;

    @GetMapping("page")
    public String list(Page page, Model model) {
        PageInfo<ProductionDetail> pageInfo = productionDetailService.getPageInfo(page, model);
        model.addAttribute("pageInfo", pageInfo);
        return "production/production_list";
    }

    @GetMapping("toAdd")
    public String toAdd() {
        return "production/production_add";
    }
}
