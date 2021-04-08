package com.sifunit.lanwei.service;

import com.github.pagehelper.PageInfo;
import com.sifunit.lanwei.common.Page;
import com.sifunit.lanwei.common.SysResult;
import com.sifunit.lanwei.domain.Emp;
import org.springframework.ui.Model;

import java.util.List;

public interface IEmpService extends IBaseService<Emp> {
    PageInfo<Emp> getPage(Page page, Model model);

    SysResult delById(Long empId);

    SysResult batchDel(List<Long> ids);
}
