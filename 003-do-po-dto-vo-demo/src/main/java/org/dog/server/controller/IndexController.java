package org.dog.server.controller;

import org.dog.server.service.UserService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.altitude.cms.common.entity.AjaxResult;

import javax.annotation.Resource;

/**
 * @Author: Odin
 * @Date: 2023/2/27 00:23
 * @Description:
 */

@RestController
@RequestMapping("/front")
public class IndexController {

    @Resource
    private UserService userService;

    @PutMapping("/select1")
    public AjaxResult getUserPo() {
        return AjaxResult.success(userService.selectUser1());
    }

    @PutMapping("/select2")
    public AjaxResult getUserVoWithNonDeptName() {
        return AjaxResult.success(userService.selectUser2());
    }

    @PutMapping("/select3")
    public AjaxResult getUserVoWithDeptName() {
        return AjaxResult.success(userService.selectUser3());
    }

    @PutMapping("/select4")
    public AjaxResult getUserVoWithInfo() {
        return AjaxResult.success(userService.selectUserList4());
    }
}
