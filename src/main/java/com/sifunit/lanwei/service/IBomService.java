package com.sifunit.lanwei.service;

import com.github.pagehelper.PageInfo;
import com.sifunit.lanwei.common.Page;
import com.sifunit.lanwei.common.SysResult;
import com.sifunit.lanwei.domain.Bom;
import org.springframework.ui.Model;

public interface IBomService extends IBaseService<Bom> {
    PageInfo<Bom> getPage(Page page, Model model);

    SysResult delById(Long laborId);
}
