package com.sifunit.lanwei.mapper;

import com.sifunit.lanwei.domain.Role;
import com.sifunit.lanwei.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends IBaseMapper<User> {

    User selectByUsername(String username);

    List<Role> getRoleList(Integer userId);
}