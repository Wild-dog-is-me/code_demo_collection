package org.dog.server.controller;

import org.dog.server.domain.User;
import org.dog.server.service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.altitude.cms.bitmap.annotation.BitMap;
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

    /**
     * 初始化BitMap
     */
    @GetMapping("/list1")
    public AjaxResult list1() {
        List<Long> userIds = EntityUtils.toList(userService.list(), User::getUserId);
        RedisBitMapUtils.init(USER_BITMAP_KEY, userIds);
        return AjaxResult.success();
    }

    /**
     * 删除BitMap 主键ID
     */
    @GetMapping("/list2")
    public AjaxResult list2() {
        RedisBitMapUtils.removeBit(USER_BITMAP_KEY, 5);
        return AjaxResult.success();
    }

    /**
     * 增加BitMap 主键ID
     */
    @GetMapping("/list3")
    public AjaxResult list3() {
        RedisBitMapUtils.setBit(USER_BITMAP_KEY, 5);
        return AjaxResult.success();
    }

    /**
     * 使用方式一：编程式开发
     */
    @GetMapping("/list4/{id}")
    public AjaxResult list4(@PathVariable Long id) {
        if (RedisBitMapUtils.getBit(USER_BITMAP_KEY,id)) {
            return AjaxResult.success(userService.getById(id));
        }
        return AjaxResult.success();
    }

    /**
     * 使用方式二：注解式开发
     */
    @GetMapping("/list5/{id}")
    @BitMap(key = USER_BITMAP_KEY, id = "#id")
    public AjaxResult list5(@PathVariable Long id) {
        return AjaxResult.success(userService.getById(id));
    }

    /**
     * 清空key
     */
    @GetMapping("/list6")
    public AjaxResult list6() {
        RedisBitMapUtils.remove(USER_BITMAP_KEY);
        return AjaxResult.success();
    }
}
