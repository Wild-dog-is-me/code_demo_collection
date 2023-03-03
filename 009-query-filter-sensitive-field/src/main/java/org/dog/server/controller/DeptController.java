package org.dog.server.controller;

import org.dog.server.domain.Dept;
import org.dog.server.entity.UserVo;
import org.dog.server.service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.altitude.cms.common.entity.AjaxResult;

import javax.annotation.Resource;

@RestController
@RequestMapping("/server/dept")
public class DeptController {

    @Resource
    private IUserService userService;

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
        return AjaxResult.success(userService.selectUserList3(), false, UserVo::getTel);
    }
}
