package com.sifunit.lanwei.controller;

import com.github.pagehelper.PageInfo;
import com.sifunit.lanwei.common.Page;
import com.sifunit.lanwei.common.SysResult;
import com.sifunit.lanwei.domain.Emp;
import com.sifunit.lanwei.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("emp")
public class EmpControler {
    @Autowired
    IEmpService empService;

    @RequestMapping("page")
    public String page(Page page, Model model) {
        //获取分页数据，保存数据，跳转到租住的列表展示页面
        PageInfo<Emp> pageInfo = empService.getPage(page, model);
        model.addAttribute("pageInfo", pageInfo);
        return "emp/emp_list";
    }

    @RequestMapping("toAdd")
    public String toAdd() {
        return "emp/emp_add";
    }

    @RequestMapping("add")
    @ResponseBody
    public SysResult add(Emp emp) {

        SysResult sysResult = new SysResult();
        int count = empService.insertSelective(emp);
        if (count > 0) {
            sysResult.setResult(true);
            sysResult.setData("添加成功!");
        } else {
            sysResult.setResult(false);
            sysResult.setData("添加失败!");
        }
        return sysResult;
    }

    @GetMapping("toUpdate")
    public String toUpdate(Long empId, Model model) {
        Emp emp = empService.selectByPrimaryKey(empId);
        model.addAttribute("emp", emp);
        return "emp/emp_update";
    }

    @RequestMapping("update")
    @ResponseBody
    public SysResult update(Emp emp) {
        SysResult sysResult = new SysResult();
        int count = empService.updateByPrimaryKeySelective(emp);
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
    public SysResult delById(Long empId) {
        SysResult sysResult = empService.delById(empId);
        return sysResult;
    }

    @GetMapping("batchDel")
    @ResponseBody
    public SysResult batchDel(@RequestParam List<Long> ids) {
        SysResult sysResult = empService.batchDel(ids);
        return sysResult;
    }
}
