package com.sifunit.lanwei.controller;

import com.github.pagehelper.PageInfo;
import com.sifunit.lanwei.common.Layui;
import com.sifunit.lanwei.common.Page;
import com.sifunit.lanwei.common.SysResult;
import com.sifunit.lanwei.domain.LayuiTree;
import com.sifunit.lanwei.domain.SysDept;
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
@RequestMapping("sysDept")
public class SysDeptController {

    @Autowired
    private ISysDeptService sysDeptService;

    @RequestMapping("page")
    public String page(Page page, Model model) {
        //获取分页数据，保存数据，跳转到租住的列表展示页面
        PageInfo<SysDept> pageInfo = sysDeptService.getPage(page, model);
        model.addAttribute("pageInfo", pageInfo);
        return "dept/dept_list";
    }

    @RequestMapping("toAdd")
    public String toAdd() {
        return "dept/dept_add";
    }

    @RequestMapping("add")
    @ResponseBody
    public SysResult add(SysDept sysDept) {

        SysResult sysResult = new SysResult(false);
        int count = sysDeptService.insertSelective(sysDept);
        if (count > 0) {
            sysResult.setResult(true);
            sysResult.setData("添加成功!");
        } else {
            sysResult.setData("添加失败!");
        }
        return sysResult;
    }

    @GetMapping("toUpdate")
    public String toUpdate(Long deptId, Model model) {
        SysDept sysDept = sysDeptService.selectByPrimaryKey(deptId);
        model.addAttribute("sysDept", sysDept);
        return "dept/dept_update";
    }

    @RequestMapping("update")
    @ResponseBody
    public SysResult update(SysDept sysDept) {
        System.out.println(sysDept);
        SysResult sysResult = new SysResult(false);
        int count = sysDeptService.updateByPrimaryKeySelective(sysDept);
        System.out.println(sysDept.getDeptId());
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
    public SysResult delById(Long deptId) {
        SysResult sysResult = sysDeptService.delById(deptId);
        return sysResult;
    }

    @GetMapping("list")
    @ResponseBody
    public List<LayuiTree> list() {
        List<LayuiTree> list = sysDeptService.list();
        return list;
    }

    @RequestMapping("listDept")
    @ResponseBody
    public Layui listDept() {
        List<SysDept> list = sysDeptService.listDept();
        return Layui.data(list.size(), list);
    }

    @GetMapping("batchDel")
    @ResponseBody
    public SysResult batchDel(@RequestParam List<Long> ids) {
        SysResult sysResult = sysDeptService.batchDel(ids);
        return sysResult;
    }

}
