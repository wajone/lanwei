package com.sifunit.lanwei.controller;

import com.github.pagehelper.PageInfo;
import com.sifunit.lanwei.common.Page;
import com.sifunit.lanwei.service.IProceCateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("proceCate")
public class ProceCateController {
    @Autowired
    IProceCateService proceCateService;

    @GetMapping("page")
    public String page(Page page, Model model) {
        PageInfo pageInfo = proceCateService.getPageInfo(page, model);
        model.addAttribute("pageInfo", pageInfo);
        return "proceCate/proceCate_list";
    }

    @GetMapping("toAdd")
    public String toAdd() {
        return "proceCate/proceCate_add";
    }
}
