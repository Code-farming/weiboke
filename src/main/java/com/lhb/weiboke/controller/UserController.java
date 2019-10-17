package com.lhb.weiboke.controller;

import com.lhb.weiboke.model.User;
import com.lhb.weiboke.result.ServerResult;
import com.lhb.weiboke.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @Autowired
    private UserService userservice;

    @GetMapping("user")
    public String user() {
        return "user";
    }

    @PostMapping("/login")
    @ResponseBody
    public ServerResult Login(User user, HttpServletRequest request) {
        return userservice.loginUser(user,request);
    }

    @GetMapping("reg")
    public String index() {
        return "reg";
    }

    @PostMapping("/reg")
    @ResponseBody
    public ServerResult register(User user) {
       return userservice.registerUser(user);
    }

}
