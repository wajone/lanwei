package com.sifunit.lanwei.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sifunit.lanwei.common.Page;
import com.sifunit.lanwei.common.SysResult;
import com.sifunit.lanwei.domain.Procedure;
import com.sifunit.lanwei.mapper.IBaseMapper;
import com.sifunit.lanwei.mapper.ProcedureMapper;
import com.sifunit.lanwei.service.IProcedureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class ProcedureServiceImpl extends BaseServiceImpl<Procedure> implements IProcedureService {
    @Autowired
    ProcedureMapper procedureMapper;

    @Override
    public IBaseMapper<Procedure> getMapper() {
        return procedureMapper;
    }

    @Override
    public PageInfo getPage(Page page, Model model) {
        PageHelper.startPage(page.getCurrentPage(), page.getPageSize());
        List<Procedure> list = procedureMapper.list();
        PageInfo<Procedure> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public SysResult delById(Long id) {
        return null;
    }

    @Override
    public PageInfo<Procedure> listproces() {
        List<Procedure> list = procedureMapper.list();
        PageInfo<Procedure> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
