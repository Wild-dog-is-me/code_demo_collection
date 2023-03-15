package org.dog.server.controller;

import org.dog.server.domain.User;
import org.dog.server.mapper.UserMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.altitude.cms.common.entity.AjaxResult;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Odin
 * @Date: 2023/3/15 13:17
 * @Description:
 */

@RestController
public class TestController {

    @Resource
    private UserMapper userMapper;

    @GetMapping("/test1")
    public List<User> test1() {
        return userMapper.selectList(null);
    }

    @GetMapping("/test2")
    public ResponseEntity test() {
        List<User> user = userMapper.selectList(null);
        System.out.println(user);
        return ResponseEntity.ok().body(user);
    }
}
