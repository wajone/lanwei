package com.sifunit.lanwei.mapper;

import com.sifunit.lanwei.domain.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper extends IBaseMapper<Role> {

    List<Role> getRoleList(Integer userId);
}