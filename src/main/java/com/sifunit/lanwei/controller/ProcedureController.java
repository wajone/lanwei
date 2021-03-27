package com.sifunit.lanwei.controller;

import com.github.pagehelper.PageInfo;
import com.sifunit.lanwei.common.Page;
import com.sifunit.lanwei.common.SysResult;
import com.sifunit.lanwei.domain.ProceCate;
import com.sifunit.lanwei.domain.Procedure;
import com.sifunit.lanwei.service.IProcedureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("proce")
public class ProcedureController {
    @Autowired
    IProcedureService procedureService;

    @GetMapping("page")
    public String page(Page page, Model model) {
        PageInfo<Procedure> pageInfo = procedureService.getPage(page, model);
        model.addAttribute("pageInfo", pageInfo);
        return "procedure/proce_list";
    }

    @RequestMapping("add")
    @ResponseBody
    public SysResult add(Procedure procedure) {
        SysResult sysResult = new SysResult(false);
        int count = procedureService.insertSelective(procedure);
        if (count > 0) {
            sysResult.setResult(true);
            sysResult.setData("添加成功!");
        } else {
            sysResult.setData("添加失败!");
        }
        return sysResult;
    }

    @GetMapping("toAdd")
    public String toAdd() {
        return "procedure/proce_add";
    }
}
