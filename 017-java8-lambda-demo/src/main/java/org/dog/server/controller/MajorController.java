package org.dog.server.controller;

import org.dog.server.service.IMajorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.altitude.cms.common.entity.AjaxResult;

import javax.annotation.Resource;

@RestController
@RequestMapping("/server/major")
public class MajorController {

    @Resource
    private IMajorService majorService;

    @GetMapping("/list1")
    public AjaxResult list1() {
        return AjaxResult.success(majorService.selectMajor());
    }
}
