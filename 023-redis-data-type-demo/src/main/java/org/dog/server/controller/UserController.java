package org.dog.server.controller;

import org.dog.server.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.altitude.cms.common.entity.AjaxResult;

import javax.annotation.Resource;

@RestController
@RequestMapping("/server/user")
public class UserController {

    @Resource
    private IUserService userService;

    @GetMapping("/list1")
    public AjaxResult list1() {
        return AjaxResult.success(userService.selectUser1(2L));
    }

    @GetMapping("/list2")
    public AjaxResult list2() {
        return AjaxResult.success(userService.selectUser2(2L));
    }

    @GetMapping("/list3")
    public AjaxResult list3() {
        return AjaxResult.success(userService.selectUser3(3L));
    }

    @GetMapping("/list4")
    public AjaxResult list4() {
        return AjaxResult.success(userService.selectUser4(3L));
    }

    @GetMapping("/list5")
    public AjaxResult list5() {
        return AjaxResult.success(userService.selectUser5(4L));
    }
}
