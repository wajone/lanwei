package com.sifunit.lanwei.controller;

import com.github.pagehelper.PageInfo;
import com.sifunit.lanwei.common.Page;
import com.sifunit.lanwei.common.SysResult;
import com.sifunit.lanwei.domain.MaterialCate;
import com.sifunit.lanwei.domain.Stock;
import com.sifunit.lanwei.service.IMaterialCateService;
import com.sifunit.lanwei.service.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("stock")
public class StockController {

    @Autowired
    IStockService stockService;

    @GetMapping("page")
    public String page(Page page, Model model) {
        PageInfo<Stock> pageInfo = stockService.getPage(page, model);
        model.addAttribute("pageInfo", pageInfo);
        return "stock/stock_list";
    }

    @RequestMapping("add")
    @ResponseBody
    public SysResult add(Stock stock) {
        SysResult sysResult = new SysResult(false);
        int count = stockService.insertSelective(stock);
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
        return "stock/stock_add";
    }

    @GetMapping("toUpdate")
    public String toUpdate(Long stockId, Model model) {
        Stock stock = stockService.selectByPrimaryKey(stockId);
        model.addAttribute("stock", stock);
        return "stock/stock_update";
    }

    @RequestMapping("update")
    @ResponseBody
    public SysResult update(Stock stock) {
        SysResult sysResult = new SysResult(false);
        int count = stockService.updateByPrimaryKeySelective(stock);
        if (count > 0) {
            sysResult.setResult(true);
            sysResult.setData("修改成功!");
        } else {
            sysResult.setData("修改失败!");
        }
        return sysResult;
    }
}
