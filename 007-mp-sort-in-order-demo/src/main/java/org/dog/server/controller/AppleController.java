package org.dog.server.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.dog.server.service.IAppleService;
import xin.altitude.cms.common.entity.AjaxResult;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

@RestController
@RequestMapping("/server/apple")
public class AppleController {

    @Resource
    private IAppleService appleService;

    @GetMapping("/list1")
    public AjaxResult list1() {
        return AjaxResult.success(appleService.selectAppleList1());
    }

    @GetMapping("/list2")
    public AjaxResult list2() {
        return AjaxResult.success(appleService.selectAppleList2());
    }

    @GetMapping("/list3")
    public AjaxResult list3() {
        return AjaxResult.success(appleService.selectAppleList7());
    }
}
