package com.lhb.weiboke.service;

import com.lhb.weiboke.result.ServerResult;
import com.lhb.weiboke.mapper.UserMapper;
import com.lhb.weiboke.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public ServerResult loginUser(User user,HttpServletRequest request) {
        User user1 = userMapper.findByEmail(user.getEmail());
        if (user1 == null) {
            return ServerResult.Error(500, "邮箱未注册", null);
        }

        if (user1 != null) {
            if (user.getUsername() == null || !user1.getUsername().equals(user.getUsername())) {
                return ServerResult.Error(500, "用户名错误", null);
            }
            if (user.getPassword() == null || !user1.getPassword().equals(user.getPassword())) {
                return ServerResult.Error(500, "密码错误", null);
            }
        }
        user1.setPassword(null);
        request.getSession().setAttribute("user",user1);
        return ServerResult.Success(200, "登录成功", user1);
    }

    @Transactional
    public ServerResult registerUser(User user) {
        User user1 = userMapper.findByEmail(user.getEmail());
        if (user1 != null) {
            return ServerResult.Error(500, "邮箱已被注册", null);
        }else {
            userMapper.addUser(user);
            return ServerResult.Error(200, "注册成功", null);
        }
    }
}
