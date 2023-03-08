package org.dog.server.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.dog.server.domain.Student;
import org.dog.server.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xin.altitude.cms.common.entity.AjaxResult;
import xin.altitude.cms.common.entity.PageEntity;

import javax.annotation.Resource;
import java.util.Arrays;

@RestController
@RequestMapping("/server/student")
public class StudentController {

    @Resource
    private IStudentService studentService;

    @GetMapping("/list1")
    public AjaxResult list1() {
        return AjaxResult.success(studentService.listStudent1());
    }

    @GetMapping("/list2")
    public AjaxResult list2() {
        return AjaxResult.success(studentService.listStudent2());
    }

    @GetMapping("/list3")
    public AjaxResult list3() {
        return AjaxResult.success(studentService.listStudent3());
    }

    @GetMapping("/list4")
    public AjaxResult list4() {
        return AjaxResult.success(studentService.listStudent4());
    }

    @GetMapping("/list5")
    public AjaxResult list5() {
        return AjaxResult.success(studentService.listStudent5());
    }

    @GetMapping("/list6")
    public AjaxResult list6() {
        return AjaxResult.success(studentService.listStudent6());
    }

}

