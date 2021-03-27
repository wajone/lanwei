package com.sifunit.lanwei.controller;

import com.github.pagehelper.PageInfo;
import com.sifunit.lanwei.common.Page;
import com.sifunit.lanwei.common.SysResult;
import com.sifunit.lanwei.domain.ProceCate;
import com.sifunit.lanwei.domain.SysDept;
import com.sifunit.lanwei.service.IProceCateService;
import com.sun.webkit.PageCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("proceCate")
public class ProceCateController {

    @Autowired
    IProceCateService proceCateService;

    @GetMapping("page")
    public String page(Page page, Model model) {

        PageInfo<ProceCate> pageInfo = proceCateService.getPage(page, model);
        model.addAttribute("pageInfo", pageInfo);
        return "proceCate/proceCate_list";
    }

    @RequestMapping("add")
    @ResponseBody
    public SysResult add(ProceCate proceCate) {

        SysResult sysResult = new SysResult(false);
        int count = proceCateService.insertSelective(proceCate);
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
        return "proceCate/proceCate_add";
    }

    @GetMapping("toUpdate")
    public String toUpdate(Long proceCateId, Model model) {
        ProceCate proceCate = proceCateService.selectByPrimaryKey(proceCateId);
        System.out.println(proceCate);
        model.addAttribute("proceCate", proceCate);
        return "proceCate/proceCate_update";
    }

    @RequestMapping("update")
    @ResponseBody
    public SysResult update(ProceCate proceCate) {
        System.out.println(proceCate);
        SysResult sysResult = new SysResult(false);
        int count = proceCateService.updateByPrimaryKeySelective(proceCate);
        if (count > 0) {
            sysResult.setResult(true);
            sysResult.setData("修改成功!");
        } else {
            sysResult.setData("修改失败!");
        }
        return sysResult;
    }
}
