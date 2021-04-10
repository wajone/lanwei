package com.sifunit.lanwei.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sifunit.lanwei.common.Page;
import com.sifunit.lanwei.common.SysResult;
import com.sifunit.lanwei.domain.Labor;
import com.sifunit.lanwei.domain.Unit;
import com.sifunit.lanwei.mapper.IBaseMapper;
import com.sifunit.lanwei.mapper.LaborMapper;
import com.sifunit.lanwei.service.ILaborService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class LaborServiceImpl extends BaseServiceImpl<Labor> implements ILaborService {
    @Autowired
    LaborMapper laborMapper;

    @Override
    public IBaseMapper<Labor> getMapper() {
        return laborMapper;
    }

    @Override
    public PageInfo<Labor> getPage(Page page, Model model) {
        PageHelper.startPage(page.getCurrentPage(), page.getPageSize());
        List<Labor> list = laborMapper.list();
        PageInfo<Labor> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public SysResult delById(Long laborId) {
        SysResult sysResult = new SysResult();
        int count = laborMapper.deleteByPrimaryKey(laborId);
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
