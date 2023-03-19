package org.dog.server.controller;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
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

    RedissonClient redisson = Redisson.create();

    @Resource
    private IUserService userService;

    /**
     * 无缓存
     */
    @GetMapping("/detail/{userId}")
    public AjaxResult detail(@PathVariable("userId") Long userId) {
        return AjaxResult.success(userService.getById(userId));
    }

    /**
     * 无锁缓存
     */
    @GetMapping("/detail2/{userId}")
    public AjaxResult detail2(@PathVariable("userId") Long userId) {
        return AjaxResult.success(userService.getById(userId, 10000L));
    }

    /**
     * 有锁缓存
     */
    @GetMapping("/detail3/{userId}")
    public AjaxResult detail3(@PathVariable("userId") Long userId) {
        return AjaxResult.success(userService.getById(userId, 10000L, redisson));
    }

}
