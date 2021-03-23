package com.sifunit.lanwei.service;

import com.sifunit.lanwei.domain.Role;
import com.sifunit.lanwei.domain.User;

import java.util.List;

public interface IUserService extends IBaseService<User>{
    User selectByUsername(String username);

}
