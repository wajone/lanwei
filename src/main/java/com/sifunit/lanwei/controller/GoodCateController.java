package com.sifunit.lanwei.controller;

import com.github.pagehelper.PageInfo;
import com.sifunit.lanwei.common.Page;
import com.sifunit.lanwei.common.SysResult;
import com.sifunit.lanwei.domain.GoodCate;
import com.sifunit.lanwei.domain.MaterialCate;
import com.sifunit.lanwei.service.IGoodCateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("goodCate")
public class GoodCateController {
    @Autowired
    IGoodCateService goodCateService;

    @GetMapping("page")
    public String page(Page page, Model model) {
        PageInfo<GoodCate> pageInfo = goodCateService.getPage(page, model);
        model.addAttribute("pageInfo", pageInfo);
        return "goodCate/goodCate_list";
    }

    @RequestMapping("add")
    @ResponseBody
    public SysResult add(GoodCate goodCate) {
        SysResult sysResult = new SysResult(false);
        int count = goodCateService.insertSelective(goodCate);
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
        return "goodCate/goodCate_add";
    }

    @GetMapping("toUpdate")
    public String toUpdate(Long goodCatId, Model model) {
        GoodCate goodCate = goodCateService.selectByPrimaryKey(goodCatId);
        model.addAttribute("goodCate", goodCate);
        return "goodCate/goodCate_update";
    }

    @RequestMapping("update")
    @ResponseBody
    public SysResult update(GoodCate goodCate) {
        SysResult sysResult = new SysResult(false);
        int count = goodCateService.updateByPrimaryKeySelective(goodCate);
        if (count > 0) {
            sysResult.setResult(true);
            sysResult.setData("修改成功!");
        } else {
            sysResult.setData("修改失败!");
        }
        return sysResult;
    }
}
