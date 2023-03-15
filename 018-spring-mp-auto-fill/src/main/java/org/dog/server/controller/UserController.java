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

    @GetMapping("/test1")
    public AjaxResult test1() {
        return AjaxResult.success(userService.test1());
    }

    @GetMapping("/test2/{id}")
    public AjaxResult test2(@PathVariable Integer id) {
        return AjaxResult.success(userService.test2(id));
    }
}
