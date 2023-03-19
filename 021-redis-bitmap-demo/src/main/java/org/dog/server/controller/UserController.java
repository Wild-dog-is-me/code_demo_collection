package org.dog.server.controller;

import org.dog.server.domain.User;
import org.dog.server.service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.altitude.cms.common.entity.AjaxResult;
import xin.altitude.cms.common.util.EntityUtils;
import xin.altitude.cms.common.util.RedisBitMapUtils;

import javax.annotation.Resource;
import java.util.List;

import static org.dog.server.service.impl.UserServiceImpl.USER_BITMAP_KEY;

@RestController
@RequestMapping("/server/user")
public class UserController {

    @Resource
    private IUserService userService;

    @GetMapping("/init")
    public AjaxResult init() {
        List<Long> userIds = EntityUtils.toList(userService.list(), User::getUserId);
        RedisBitMapUtils.init(USER_BITMAP_KEY, userIds);
        return AjaxResult.success();
    }

    @GetMapping(value = "/detail1/{userId}")
    public AjaxResult detail1(@PathVariable("userId") Long userId) {
        return AjaxResult.success(userService.selectUser1(userId));
    }

    @GetMapping(value = "/detail2/{userId}")
    public AjaxResult detail2(@PathVariable("userId") Long userId) {
        return AjaxResult.success(userService.selectUser2(userId));
    }

    @GetMapping(value = "/detail3/{userId}")
    public AjaxResult detail3(@PathVariable("userId") Long userId) {
        return AjaxResult.success(userService.selectUser3(userId));
    }

    // 在数据发生变动时，注意布隆过滤器内缓存的数据需要同步变动
    public AjaxResult modify() {
        Long id = 1L;
        // 添加
        RedisBitMapUtils.setBit(USER_BITMAP_KEY, id);
        // 移除
        RedisBitMapUtils.removeBit(USER_BITMAP_KEY, id);
        return AjaxResult.success();
    }
}
