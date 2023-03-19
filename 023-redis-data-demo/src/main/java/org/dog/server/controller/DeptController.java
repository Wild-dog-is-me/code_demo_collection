package org.dog.server.controller;

import org.dog.server.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.altitude.cms.common.entity.AjaxResult;

import javax.annotation.Resource;

@RestController
@RequestMapping("/server/dept")
public class DeptController {

//    @Resource
//    private IDeptService deptService;
//
//    @GetMapping("/list1")
//    public AjaxResult list1() {
//        return AjaxResult.success(deptService.selectDept1());
//    }
//
//    @GetMapping("/list2")
//    public AjaxResult list2() {
//        return AjaxResult.success(deptService.selectDept2());
//    }
//
//    @GetMapping("/list3")
//    public AjaxResult list3() {
//        return AjaxResult.success(deptService.selectDept3());
//    }
//
//    @GetMapping("/list4")
//    public AjaxResult list4() {
//        return AjaxResult.success(deptService.selectDept4());
//    }

}
