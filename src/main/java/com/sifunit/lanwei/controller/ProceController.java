package com.sifunit.lanwei.controller;

import com.github.pagehelper.PageInfo;
import com.sifunit.lanwei.common.Page;
import com.sifunit.lanwei.service.IProcedureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("proce")
public class ProceController {
    @Autowired
    IProcedureService procedureService;
    @GetMapping("page")
    public String page(Page page, Model model) {
        System.out.println("page");
        PageInfo pageInfo = procedureService.getPageInfo(page, model);
        model.addAttribute("pageInfo", pageInfo);
        return "procedure/proce_list";
    }

    @GetMapping("toAdd")
    public String toAdd() {
        return "procedure/proce_add";
    }
}
