package com.sifunit.lanwei.service;

import com.github.pagehelper.PageInfo;
import com.sifunit.lanwei.common.Page;
import com.sifunit.lanwei.common.SysResult;
import com.sifunit.lanwei.domain.Bom;
import org.springframework.ui.Model;

import java.util.List;

public interface IBomService extends IBaseService<Bom> {

    int insertBoms(List<Bom> boms);

    PageInfo<Bom> getPageInfo(Page page, Model model);
}
