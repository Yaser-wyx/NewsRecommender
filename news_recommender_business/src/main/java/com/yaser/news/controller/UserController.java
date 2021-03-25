package com.yaser.news.controller;

import com.yaser.news.service.LabelService;
import com.yaser.news.service.UserService;
import com.yaser.news.service.dataWrap.UserInfoWrap;
import com.yaser.news.service.dataWrap.UserLoginWrap;
import com.yaser.news.utils.UseToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@CrossOrigin(allowCredentials = "true", origins = "http://localhost:3000")

@RequestMapping(value = "/v1/user")
public class UserController {
    private final UserService userService;
    private final LabelService labelService;

    public UserController(UserService userService, LabelService labelService) {
        this.userService = userService;
        this.labelService = labelService;
    }

    @PostMapping("/login")
    public UserLoginWrap login(@RequestParam String email, @RequestParam String password) {
        return userService.login(email, password);
    }

    @PostMapping("/register")
    public UserLoginWrap register(@RequestParam String email, @RequestParam String password, @RequestParam String nickname, @RequestParam int gender) {
        return userService.register(email, password, nickname, gender);
    }

    @GetMapping("/selfInfo")
    @UseToken
    public UserInfoWrap getSelfInfo() {
        return userService.getSelfInfo();
    }

    @GetMapping("/userInfo")
    public UserInfoWrap getUserInfo(@RequestParam long uid) {
        return userService.getUserInfoById(uid);
    }


}
