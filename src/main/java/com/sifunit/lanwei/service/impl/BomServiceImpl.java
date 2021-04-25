package com.sifunit.lanwei.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sifunit.lanwei.common.Page;
import com.sifunit.lanwei.common.SysResult;
import com.sifunit.lanwei.domain.Bom;
import com.sifunit.lanwei.domain.Customer;
import com.sifunit.lanwei.mapper.BomMapper;
import com.sifunit.lanwei.mapper.IBaseMapper;
import com.sifunit.lanwei.service.IBomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;


@Service
public class BomServiceImpl extends BaseServiceImpl<Bom> implements IBomService {

    @Autowired
    BomMapper bomMapper;

    @Override
    public IBaseMapper<Bom> getMapper() {
        return bomMapper;
    }

    @Override
    public int insertBoms(List<Bom> boms) {
        for (Bom bom : boms) {
            if (bomMapper.insertSelective(bom) < 0) {
                return -1;
            }
        }
        return 1;
    }

    @Override
    public PageInfo<Bom> getPageInfo(Page page, Model model) {
        PageHelper.startPage(page.getCurrentPage(), page.getPageSize());
        List<Bom> list = bomMapper.list();
        PageInfo<Bom> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
