package org.dog.server.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.dog.server.domain.User;
import org.dog.server.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xin.altitude.cms.common.entity.AjaxResult;
import xin.altitude.cms.common.entity.PageEntity;

import javax.annotation.Resource;
import java.util.Arrays;

@RestController
@RequestMapping("/server/user")
public class UserController {

    @Resource
    private IUserService userService;

    @GetMapping("/list1")
    public AjaxResult list1() {
        return AjaxResult.success(userService.selectUserList1(), true, User::getUserId, User::getUserName);
    }

    @GetMapping("/list2")
    public AjaxResult list2() {
        return AjaxResult.success(userService.selectUserList2(), true, User::getUserId, User::getUserName);
    }

    @GetMapping("/list3")
    public AjaxResult list3() {
        return AjaxResult.success(userService.selectUserList3(), true, User::getUserId, User::getUserName);
    }

    @GetMapping("/list4")
    public AjaxResult list4() {
        return AjaxResult.success(userService.selectUserList4(), true, User::getUserId, User::getUserName);
    }
}
