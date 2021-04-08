package com.sifunit.lanwei.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sifunit.lanwei.common.Page;
import com.sifunit.lanwei.common.SysResult;
import com.sifunit.lanwei.domain.Unit;
import com.sifunit.lanwei.mapper.IBaseMapper;
import com.sifunit.lanwei.mapper.UnitMapper;
import com.sifunit.lanwei.service.IUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class UnitServiceImpl extends BaseServiceImpl<Unit> implements IUnitService {

    @Autowired
    UnitMapper unitMapper;

    @Override
    public IBaseMapper<Unit> getMapper() {
        return unitMapper;
    }

    @Override
    public PageInfo<Unit> getPage(Page page, Model model) {
        PageHelper.startPage(page.getCurrentPage(), page.getPageSize());
        List<Unit> list = unitMapper.list();
        PageInfo<Unit> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public SysResult delById(Long unitId) {
        SysResult sysResult = new SysResult();
        int count = unitMapper.deleteByPrimaryKey(unitId);
        if (count == 0) {
            sysResult.setResult(false);
            sysResult.setData("删除客户失败！");
        } else {
            sysResult.setResult(true);
            sysResult.setData("删除客户成功！");
        }
        return sysResult;
    }
}
