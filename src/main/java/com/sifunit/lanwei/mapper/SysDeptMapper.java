package com.sifunit.lanwei.mapper;

import com.sifunit.lanwei.domain.LayuiTree;
import com.sifunit.lanwei.domain.SysDept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysDeptMapper extends IBaseMapper<SysDept> {
    List<SysDept> list();

    long selectCountById(Long deptId);
    long selectCountByIds(List<Long> ids);
    List<LayuiTree> findAllRecursion();
    int updateByIds(List<Long> ids);
}