package com.sifunit.lanwei.controller;

import com.github.pagehelper.PageInfo;
import com.sifunit.lanwei.common.Layui;
import com.sifunit.lanwei.common.Page;
import com.sifunit.lanwei.common.SysResult;
import com.sifunit.lanwei.domain.Customer;
import com.sifunit.lanwei.domain.LayuiTree;
import com.sifunit.lanwei.domain.SysDept;
import com.sifunit.lanwei.service.ICustomerService;
import com.sifunit.lanwei.service.ISysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    ICustomerService customerService;

    @RequestMapping("page")
    public String page(Page page, Model model) {
        //获取分页数据，保存数据，跳转到租住的列表展示页面
        PageInfo<Customer> pageInfo = customerService.getPage(page, model);
        model.addAttribute("pageInfo", pageInfo);
        return "customer/customer_list";
    }

    @RequestMapping("toAdd")
    public String toAdd() {
        return "customer/customer_add";
    }

    @RequestMapping("add")
    @ResponseBody
    public SysResult add(Customer customer) {

        SysResult sysResult = new SysResult(false);
        int count = customerService.insertSelective(customer);
        if (count > 0) {
            sysResult.setResult(true);
            sysResult.setData("添加成功!");
        } else {
            sysResult.setData("添加失败!");
        }
        return sysResult;
    }

    @GetMapping("toUpdate")
    public String toUpdate(Long customerId, Model model) {
        Customer customer = customerService.selectByPrimaryKey(customerId);
        model.addAttribute("sysDept", customer);
        return "customer/customer_update";
    }

    @RequestMapping("update")
    @ResponseBody
    public SysResult update(Customer Customer) {
        SysResult sysResult = new SysResult(false);
        int count = customerService.updateByPrimaryKeySelective(Customer);
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
    public SysResult delById(Long customerId) {
        System.out.println(customerId);
        SysResult sysResult = customerService.delById(customerId);
        return sysResult;
    }

    @GetMapping("batchDel")
    @ResponseBody
    public SysResult batchDel(@RequestParam List<Long> ids) {
        SysResult sysResult = customerService.batchDel(ids);
        return sysResult;
    }
}
