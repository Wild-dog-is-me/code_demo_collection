package org.dog.server.controller;

import org.dog.server.service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.altitude.cms.common.entity.AjaxResult;
import xin.altitude.cms.take.time.annotation.TakeTime;

import javax.annotation.Resource;

@RestController
@RequestMapping("/server/user")
public class UserController {

    @Resource
    private IUserService userService;

    @TakeTime
    @GetMapping("/list1")
    public AjaxResult list1() {
        return AjaxResult.success(userService.selectUserList1());
    }

    @TakeTime
    @GetMapping("/list2")
    public AjaxResult list2() {
        return AjaxResult.success(userService.selectUserList2());
    }

    @TakeTime
    @GetMapping("/list3")
    public AjaxResult list3() {
        return AjaxResult.success(userService.selectUserList3());
    }
}
