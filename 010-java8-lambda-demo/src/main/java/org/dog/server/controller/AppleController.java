package org.dog.server.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Arrays;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.dog.server.service.IAppleService;
import xin.altitude.cms.common.entity.AjaxResult;
import java.util.List;
import org.dog.server.mapper.AppleMapper;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import xin.altitude.cms.common.entity.PageEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.dog.server.domain.Apple;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
@RestController
@RequestMapping("/server/apple")
public class AppleController{
    @Autowired
    private IAppleService appleService;
    @GetMapping("/page")
    public AjaxResult page(PageEntity pageEntity,Apple apple){
        return AjaxResult.success(appleService.page(pageEntity.toPage(), Wrappers.lambdaQuery(apple)));
    }
    @GetMapping("/list")
    public AjaxResult list(Apple apple){
        return AjaxResult.success(appleService.list(Wrappers.lambdaQuery(apple)));
    }
    @PostMapping("/push")
    public AjaxResult add(@RequestBody Apple apple) {
        return AjaxResult.success(appleService.save(apple));
    }
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody Apple apple) {
        return AjaxResult.success(appleService.updateById(apple));
    }
    @DeleteMapping("/delete/{ids}")
    public AjaxResult delete(@PathVariable Integer[] ids) {
        return AjaxResult.success(appleService.removeByIds(Arrays.asList(ids)));
    }
    @GetMapping(value = "/detail/{id}")
    public AjaxResult detail(@PathVariable("id") Integer id) {
        return AjaxResult.success(appleService.getById(id));
    }
}
