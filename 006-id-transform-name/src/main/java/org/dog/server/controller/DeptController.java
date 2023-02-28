package org.dog.server.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.dog.server.domain.Dept;
import org.dog.server.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xin.altitude.cms.common.entity.AjaxResult;
import xin.altitude.cms.common.entity.PageEntity;

import java.util.Arrays;

@RestController
@RequestMapping("/server/dept")
public class DeptController {
    @Autowired
    private IDeptService deptService;

    @GetMapping("/page")
    public AjaxResult page(PageEntity pageEntity, Dept dept) {
        return AjaxResult.success(deptService.page(pageEntity.toPage(), Wrappers.lambdaQuery(dept)));
    }

    @GetMapping("/list")
    public AjaxResult list(Dept dept) {
        return AjaxResult.success(deptService.list(Wrappers.lambdaQuery(dept)));
    }

    @PostMapping("/push")
    public AjaxResult add(@RequestBody Dept dept) {
        return AjaxResult.success(deptService.save(dept));
    }

    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody Dept dept) {
        return AjaxResult.success(deptService.updateById(dept));
    }

    @DeleteMapping("/delete/{deptIds}")
    public AjaxResult delete(@PathVariable Long[] deptIds) {
        return AjaxResult.success(deptService.removeByIds(Arrays.asList(deptIds)));
    }

    @GetMapping(value = "/detail/{deptId}")
    public AjaxResult detail(@PathVariable("deptId") Long deptId) {
        return AjaxResult.success(deptService.getById(deptId));
    }
}
