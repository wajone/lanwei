package com.sifunit.lanwei.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sifunit.lanwei.common.Page;
import com.sifunit.lanwei.common.SysResult;
import com.sifunit.lanwei.domain.Emp;
import com.sifunit.lanwei.mapper.EmpMapper;
import com.sifunit.lanwei.mapper.IBaseMapper;
import com.sifunit.lanwei.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class EmpServiceImpl extends BaseServiceImpl<Emp> implements IEmpService {
    @Autowired
    EmpMapper empMapper;

    @Override
    public IBaseMapper<Emp> getMapper() {
        return empMapper;
    }

    @Override
    public PageInfo<Emp> getPage(Page page, Model model) {
        PageHelper.startPage(page.getCurrentPage(), page.getPageSize());
        List<Emp> list = empMapper.list();
        PageInfo<Emp> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public SysResult delById(Long empId) {
        return null;
    }

    @Override
    public SysResult batchDel(List<Long> ids) {
        return null;
    }
}
