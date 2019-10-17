package com.lhb.weiboke.mapper;

import com.lhb.weiboke.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    void addUser(User user);

    User findByEmail(String email);
}
