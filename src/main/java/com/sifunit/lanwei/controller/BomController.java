package com.sifunit.lanwei.controller;

import com.github.pagehelper.PageInfo;
import com.sifunit.lanwei.common.Page;
import com.sifunit.lanwei.common.SysResult;
import com.sifunit.lanwei.domain.Bom;
import com.sifunit.lanwei.domain.Product;
import com.sifunit.lanwei.domain.Unit;
import com.sifunit.lanwei.service.IBomService;
import com.sifunit.lanwei.service.IProductService;
import com.sifunit.lanwei.service.IUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("bom")
public class BomController {
    @Autowired
    IBomService bomService;
    @Autowired
    IProductService productService;
    @Autowired
    IUnitService unitService;

    @GetMapping("page")
    public String page(Page page, Model model) {
        PageInfo<Bom> pageInfo = bomService.getPage(page, model);
        model.addAttribute("pageInfo", pageInfo);
        return "bom/bom_list";
    }

    @RequestMapping("add")
    @ResponseBody
    public SysResult add(Bom bom) {
        SysResult sysResult = new SysResult();
        int count = bomService.insertSelective(bom);
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
    public String toAdd(Model model) {
        PageInfo<Unit> units = unitService.listUnits();
        //获取所有产品信息，下一步可以实行分页返回数据，全端用流加载，目前还没找到解决办法，先全部返回
        PageInfo<Product> products = productService.list();
        model.addAttribute("units", units);
        model.addAttribute("products", products);
        return "bom/bom_add";
    }

    @GetMapping("toUpdate")
    public String toUpdate(Long laborId, Model model) {
        Bom bom = bomService.selectByPrimaryKey(laborId);
        model.addAttribute("bom", bom);
        return "labor/labor_update";
    }

    @RequestMapping("update")
    @ResponseBody
    public SysResult update(Bom bom) {
        SysResult sysResult = new SysResult();
        int count = bomService.updateByPrimaryKeySelective(bom);
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
        SysResult sysResult = bomService.delById(laborId);
        return sysResult;
    }

}
