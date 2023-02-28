package org.dog.server.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.dog.server.domain.Region;
import org.dog.server.service.IRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xin.altitude.cms.common.entity.AjaxResult;
import xin.altitude.cms.common.entity.PageEntity;

import java.util.Arrays;

@RestController
@RequestMapping("/server/region")
public class RegionController {
    @Autowired
    private IRegionService regionService;

    @GetMapping("/page")
    public AjaxResult page(PageEntity pageEntity, Region region) {
        return AjaxResult.success(regionService.page(pageEntity.toPage(), Wrappers.lambdaQuery(region)));
    }

    @GetMapping("/list")
    public AjaxResult list(Region region) {
        return AjaxResult.success(regionService.list(Wrappers.lambdaQuery(region)));
    }

    @PostMapping("/push")
    public AjaxResult add(@RequestBody Region region) {
        return AjaxResult.success(regionService.save(region));
    }

    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody Region region) {
        return AjaxResult.success(regionService.updateById(region));
    }

    @DeleteMapping("/delete/{regionIds}")
    public AjaxResult delete(@PathVariable Integer[] regionIds) {
        return AjaxResult.success(regionService.removeByIds(Arrays.asList(regionIds)));
    }

    @GetMapping(value = "/detail/{regionId}")
    public AjaxResult detail(@PathVariable("regionId") Integer regionId) {
        return AjaxResult.success(regionService.getById(regionId));
    }
}
