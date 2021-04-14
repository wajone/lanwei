package com.sifunit.lanwei.service;

import com.github.pagehelper.PageInfo;
import com.sifunit.lanwei.common.Page;
import com.sifunit.lanwei.common.SysResult;
import com.sifunit.lanwei.domain.Procedure;
import org.springframework.ui.Model;

public interface IProcedureService extends IBaseService<Procedure> {
    PageInfo getPage(Page page, Model model);

    SysResult delById(Long id);

    PageInfo<Procedure> listproces();
}
