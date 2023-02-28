package org.dog.server.controller;

import org.dog.server.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.altitude.cms.common.entity.AjaxResult;

import javax.annotation.Resource;

/**
 * @Author: Odin
 * @Date: 2023/2/27 23:52
 * @Description:
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/list1")
    public AjaxResult list1() {
        return AjaxResult.success(userService.selectUserList1());
    }

    @GetMapping("/list2")
    public AjaxResult list2() {
        return AjaxResult.success(userService.selectUserList2());
    }

    @GetMapping("/list3")
    public AjaxResult list3() {
        return AjaxResult.success(userService.selectUserList3());
    }

    @GetMapping("/list4")
    public AjaxResult list4() {
        return AjaxResult.success(userService.selectUserList4());
    }

    @GetMapping("/list5")
    public AjaxResult list5() {
        return AjaxResult.success(userService.selectUserList5());
    }

    @GetMapping("/list6")
    public AjaxResult list6() {
        return AjaxResult.success(userService.selectUserList6());
    }

}
