package com.sifunit.lanwei.controller;

import com.github.pagehelper.PageInfo;
import com.sifunit.lanwei.common.Page;
import com.sifunit.lanwei.common.SysResult;
import com.sifunit.lanwei.domain.MaterialCate;
import com.sifunit.lanwei.service.IMaterialCateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SupplierCateController {
    @Autowired
    IMaterialCateService materialCateService;

    @GetMapping("page")
    public String page(Page page, Model model) {
        PageInfo<MaterialCate> pageInfo = materialCateService.getPage(page, model);
        model.addAttribute("pageInfo", pageInfo);
        return "materialCate/materialCate_list";
    }

    @RequestMapping("add")
    @ResponseBody
    public SysResult add(MaterialCate materialCate) {
        SysResult sysResult = new SysResult(false);
        int count = materialCateService.insertSelective(materialCate);
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
        return "materialCate/materialCate_add";
    }

    @GetMapping("toUpdate")
    public String toUpdate(Long materialCateId, Model model) {
        MaterialCate materialCate = materialCateService.selectByPrimaryKey(materialCateId);
        model.addAttribute("proceCate", materialCate);
        return "proceCate/proceCate_update";
    }

    @RequestMapping("update")
    @ResponseBody
    public SysResult update(MaterialCate materialCate) {
        SysResult sysResult = new SysResult(false);
        int count = materialCateService.updateByPrimaryKeySelective(materialCate);
        if (count > 0) {
            sysResult.setResult(true);
            sysResult.setData("修改成功!");
        } else {
            sysResult.setData("修改失败!");
        }
        return sysResult;
    }
}
