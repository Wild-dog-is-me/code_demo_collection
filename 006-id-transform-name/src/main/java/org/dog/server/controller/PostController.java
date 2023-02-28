package org.dog.server.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.dog.server.domain.Post;
import org.dog.server.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xin.altitude.cms.common.entity.AjaxResult;
import xin.altitude.cms.common.entity.PageEntity;

import java.util.Arrays;

@RestController
@RequestMapping("/server/post")
public class PostController {
    @Autowired
    private IPostService postService;

    @GetMapping("/page")
    public AjaxResult page(PageEntity pageEntity, Post post) {
        return AjaxResult.success(postService.page(pageEntity.toPage(), Wrappers.lambdaQuery(post)));
    }

    @GetMapping("/list")
    public AjaxResult list(Post post) {
        return AjaxResult.success(postService.list(Wrappers.lambdaQuery(post)));
    }

    @PostMapping("/push")
    public AjaxResult add(@RequestBody Post post) {
        return AjaxResult.success(postService.save(post));
    }

    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody Post post) {
        return AjaxResult.success(postService.updateById(post));
    }

    @DeleteMapping("/delete/{postIds}")
    public AjaxResult delete(@PathVariable Integer[] postIds) {
        return AjaxResult.success(postService.removeByIds(Arrays.asList(postIds)));
    }

    @GetMapping(value = "/detail/{postId}")
    public AjaxResult detail(@PathVariable("postId") Integer postId) {
        return AjaxResult.success(postService.getById(postId));
    }
}
