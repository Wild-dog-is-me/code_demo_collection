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

    @PutMapping("/select3")
    public AjaxResult getUserVo() {
        return AjaxResult.success(userService.selectUser3());
    }

    @PutMapping("/select6")
    public AjaxResult getUserVoList() {
        return AjaxResult.success(userService.selectUser6());
    }

    @PutMapping("/select7")
    public AjaxResult getUserMap() {
        return AjaxResult.success(userService.selectUser7());
    }

    @PutMapping("/select8")
    public AjaxResult getUserSet() {
        return AjaxResult.success(userService.selectUser8());
    }

    @PutMapping("/select9")
    public AjaxResult getUserGroupByFK() {
        return AjaxResult.success(userService.selectUser9());
    }

}
