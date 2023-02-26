package org.dog.server.controller;

import org.dog.server.domain.User;
import org.dog.server.entity.UserDTO;
import org.dog.server.service.UserService;
import org.springframework.web.bind.annotation.*;
import xin.altitude.cms.common.entity.AjaxResult;
import xin.altitude.cms.common.util.EntityUtils;

import javax.annotation.Resource;

/**
 * @Author: Odin
 * @Date: 2023/2/26 23:13
 * @Description:
 */

@RestController
@RequestMapping("/front/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/edit")
    public AjaxResult list() {
        return AjaxResult.success(userService.getById(2, User.class));
    }

    @PutMapping("/edit1")
    public AjaxResult edit1(@RequestBody UserDTO userDTO) {
        User user = EntityUtils.toObj(userDTO, User::new);
        return AjaxResult.success(userService.updateUser1(user));
    }

    @PutMapping("/edit2")
    public AjaxResult edit2(@RequestBody UserDTO userDTO) {
        User user = EntityUtils.toObj(userDTO, User::new);
        return AjaxResult.success(userService.updateUser2(user));
    }

    @PutMapping("/edit3")
    public AjaxResult edit3(@RequestBody UserDTO userDTO) {
        User user = EntityUtils.toObj(userDTO, User::new);
        return AjaxResult.success(userService.updateUser3(user));
    }
}
