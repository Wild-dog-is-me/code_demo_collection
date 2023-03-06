package org.dog.server.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Arrays;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import xin.altitude.cms.common.entity.AjaxResult;
import java.util.List;
import org.dog.server.domain.User;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.dog.server.mapper.UserMapper;
import org.springframework.web.bind.annotation.RequestBody;
import xin.altitude.cms.common.entity.PageEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.dog.server.service.IUserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

@RestController
@RequestMapping("/server/user")
public class UserController {

    @Resource
    private IUserService userService;

    @GetMapping("/query/{userId}")
    public AjaxResult queryOne(@PathVariable("userId") Integer userId) {
        return AjaxResult.success(userService.getOneUser(userId));
    }

    @GetMapping("/get1")
    public AjaxResult get1() {
        return AjaxResult.success(userService.findUserByAge());
    }

    @GetMapping("/get2")
    public AjaxResult get2() {
        return AjaxResult.success(userService.findUserByDeptName());
    }

    @GetMapping("/page1")
    public AjaxResult page1() {
        return AjaxResult.success(userService.selectUserPage1());
    }

    @GetMapping("/page2")
    public AjaxResult page2() {
        return AjaxResult.success(userService.selectUserPage2());
    }

    @GetMapping("/page3")
    public AjaxResult page3() {
        return AjaxResult.success(userService.selectUserPage3());
    }


}
