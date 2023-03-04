package org.dog.server.controller;

import org.dog.server.service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.altitude.cms.common.entity.AjaxResult;

import javax.annotation.Resource;

@RestController
@RequestMapping("/server/user")
public class UserController {

    @Resource
    private IUserService userService;

    @GetMapping("/edit1/{userId}")
    public AjaxResult edit1(@PathVariable("userId") Long userId) {
        return AjaxResult.success(userService.updateUserAge1(userId));
    }

    @GetMapping("/edit2/{userId}")
    public AjaxResult edit2(@PathVariable("userId") Long userId) {
        return AjaxResult.success(userService.updateUserAge2(userId));
    }


}
