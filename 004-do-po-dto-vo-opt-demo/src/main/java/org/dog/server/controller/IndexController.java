package org.dog.server.controller;

import org.dog.server.domain.User;
import org.dog.server.entity.UserVo;
import org.dog.server.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/list1")
    public AjaxResult list1() {
        return AjaxResult.success(userService.selectUserList1());
    }

    /**
     * 在DO模型的基础上 过滤字段:deptId
     */
    @GetMapping("/list2")
    public AjaxResult list2() {
        return AjaxResult.success(userService.selectUserList1(), false, User::getDeptId);
    }

    /**
     * 在DO模型的基础上 过滤字段:userId,age
     */
    @GetMapping("/list3")
    public AjaxResult list3() {
        return AjaxResult.success(userService.selectUserList1(), false, User::getUserId, User::getAge);
    }

    /**
     * 在DO模型的基础上 提取字段:userName
     */
    @GetMapping("/list4")
    public AjaxResult list4() {
        return AjaxResult.success(userService.selectUserList1(), true, User::getUserName);
    }

    /**
     * 在DO模型的基础上 提取字段:userName,age
     */
    @GetMapping("/list5")
    public AjaxResult list5() {
        return AjaxResult.success(userService.selectUserList1(), true, User::getUserName, User::getAge);
    }

    @GetMapping("/list6")
    public AjaxResult list6() {
        return AjaxResult.success(userService.selectUserList2());
    }

    /**
     * 在VO模型的基础上 过滤字段
     */
    @GetMapping("/list7")
    public AjaxResult list7() {
        return AjaxResult.success(userService.selectUserList2(), false, User::getDeptId);
    }

    /**
     * 在VO模型的基础上 保留字段
     */
    @GetMapping("/list8")
    public AjaxResult list8() {
        return AjaxResult.success(userService.selectUserList2(), true, User::getUserId, User::getUserName, UserVo::getDeptName);
    }

}
