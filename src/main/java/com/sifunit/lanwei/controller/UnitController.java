package com.sifunit.lanwei.controller;

import com.github.pagehelper.PageInfo;
import com.sifunit.lanwei.common.Page;
import com.sifunit.lanwei.common.SysResult;
import com.sifunit.lanwei.domain.ProductCate;
import com.sifunit.lanwei.domain.Unit;
import com.sifunit.lanwei.service.IProductCateService;
import com.sifunit.lanwei.service.IUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("unit")
public class UnitController {
    @Autowired
    IUnitService unitService;

    @GetMapping("page")
    public String page(Page page, Model model) {
        PageInfo<Unit> pageInfo = unitService.getPage(page, model);
        model.addAttribute("pageInfo", pageInfo);
        return "unit/unit_list";
    }

    @RequestMapping("add")
    @ResponseBody
    public SysResult add(Unit unit) {
        SysResult sysResult = new SysResult(false);
        System.out.println(unit.getUnitName());
        int count = unitService.insertSelective(unit);
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
        return "unit/unit_add";
    }

    @GetMapping("toUpdate")
    public String toUpdate(Long unitId, Model model) {
        Unit unit = unitService.selectByPrimaryKey(unitId);
        model.addAttribute("unit", unit);
        return "unit/unit_update";
    }

    @RequestMapping("update")
    @ResponseBody
    public SysResult update(Unit unit) {
        SysResult sysResult = new SysResult(false);
        int count = unitService.updateByPrimaryKeySelective(unit);
        if (count > 0) {
            sysResult.setResult(true);
            sysResult.setData("修改成功!");
        } else {
            sysResult.setData("修改失败!");
        }
        return sysResult;
    }

    @GetMapping("delById")
    @ResponseBody
    public SysResult delById(Long unitId) {
        SysResult sysResult = unitService.delById(unitId);
        return sysResult;
    }
}
