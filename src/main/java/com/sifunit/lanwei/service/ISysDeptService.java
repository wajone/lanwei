package com.sifunit.lanwei.service;

import com.github.pagehelper.PageInfo;
import com.sifunit.lanwei.common.Page;
import com.sifunit.lanwei.common.SysResult;
import com.sifunit.lanwei.domain.LayuiTree;
import com.sifunit.lanwei.domain.SysDept;
import org.springframework.ui.Model;

import java.util.List;

public interface ISysDeptService extends IBaseService<SysDept> {

    PageInfo<SysDept> getPage(Page page, Model model);

    SysResult delById(Long deptId);

    List<LayuiTree> list();

    List<SysDept> listDept();

    SysResult batchDel(List<Long> ids);
}
