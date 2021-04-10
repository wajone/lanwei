package com.sifunit.lanwei.controller;

import com.github.pagehelper.PageInfo;
import com.sifunit.lanwei.common.Page;
import com.sifunit.lanwei.common.SysResult;
import com.sifunit.lanwei.domain.Labor;
import com.sifunit.lanwei.service.ILaborService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("labor")
public class LaborController {
    @Autowired
    ILaborService laborService;

    @GetMapping("page")
    public String page(Page page, Model model) {
        PageInfo<Labor> pageInfo = laborService.getPage(page, model);
        model.addAttribute("pageInfo", pageInfo);
        return "labor/labor_list";
    }

    @RequestMapping("add")
    @ResponseBody
    public SysResult add(Labor labor) {
        SysResult sysResult = new SysResult();
        int count = laborService.insertSelective(labor);
        if (count > 0) {
            sysResult.setResult(true);
            sysResult.setData("添加成功!");
        } else {
            sysResult.setResult(false);
            sysResult.setData("添加失败!");
        }
        return sysResult;
    }

    @GetMapping("toAdd")
    public String toAdd() {
        return "labor/labor_add";
    }

    @GetMapping("toUpdate")
    public String toUpdate(Long laborId, Model model) {
        Labor labor = laborService.selectByPrimaryKey(laborId);
        model.addAttribute("labor", labor);
        return "labor/labor_update";
    }

    @RequestMapping("update")
    @ResponseBody
    public SysResult update(Labor labor) {
        SysResult sysResult = new SysResult();
        int count = laborService.updateByPrimaryKeySelective(labor);
        if (count > 0) {
            sysResult.setResult(true);
            sysResult.setData("修改成功!");
        } else {
            sysResult.setResult(false);
            sysResult.setData("修改失败!");
        }
        return sysResult;
    }

    @GetMapping("delById")
    @ResponseBody
    public SysResult delById(Long laborId) {
        SysResult sysResult = laborService.delById(laborId);
        return sysResult;
    }
}
