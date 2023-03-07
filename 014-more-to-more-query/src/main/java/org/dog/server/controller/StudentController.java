package org.dog.server.controller;

import org.dog.server.service.IStudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.altitude.cms.common.entity.AjaxResult;

import javax.annotation.Resource;

@RestController
@RequestMapping("/server/student")
public class StudentController {

    @Resource
    private IStudentService studentService;

    @GetMapping("/get1/{stuId}")
    public AjaxResult get1(@PathVariable Integer stuId) {
        return AjaxResult.success(studentService.getStudent3(stuId));
    }
}
