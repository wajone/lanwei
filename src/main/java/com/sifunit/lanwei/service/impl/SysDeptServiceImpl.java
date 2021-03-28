package com.sifunit.lanwei.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sifunit.lanwei.common.Page;
import com.sifunit.lanwei.common.SysResult;
import com.sifunit.lanwei.domain.LayuiTree;
import com.sifunit.lanwei.domain.SysDept;
import com.sifunit.lanwei.mapper.IBaseMapper;
import com.sifunit.lanwei.mapper.SysDeptMapper;
import com.sifunit.lanwei.service.ISysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class SysDeptServiceImpl extends BaseServiceImpl<SysDept> implements ISysDeptService {

    @Autowired
    private SysDeptMapper sysDeptMapper;
    @Override
    public IBaseMapper<SysDept> getMapper() {
        return sysDeptMapper;
    }

    @Override
    public PageInfo<SysDept> getPage(Page page, Model model) {
        PageHelper.startPage(page.getCurrentPage(), page.getPageSize());
        List<SysDept> list = sysDeptMapper.list();
        PageInfo<SysDept> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public SysResult delById(Long deptId) {
        long count = sysDeptMapper.selectCountById(deptId);
        SysResult sysResult = new SysResult(false);

        if (count > 0) {
            sysResult.setData("删除失败！");
        } else {
            SysDept sysDept = new SysDept();
            sysDept.setDeptId(deptId);
            sysDept.setFlag(false);
            sysDeptMapper.updateByPrimaryKeySelective(sysDept);
            sysResult.setResult(true);
        }
        return sysResult;
    }

    @Override
    public List<LayuiTree> list() {
        return sysDeptMapper.findAllRecursion();
    }

    @Override
    public List<SysDept> listDept() {
        return sysDeptMapper.list();
    }

    @Override
    public SysResult batchDel(List<Long> ids) {
        SysResult sysResult = new SysResult(false);
        long count = sysDeptMapper.selectCountByIds(ids);
        if (count > 0) {
            System.out.println();
            sysResult.setResult(false);
        } else {
            sysResult.setResult(true);
            sysDeptMapper.updateByIds(ids);
        }
        return sysResult;
    }
}
