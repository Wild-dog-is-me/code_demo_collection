package org.dog.server.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Arrays;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import xin.altitude.cms.common.entity.AjaxResult;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import xin.altitude.cms.common.entity.PageEntity;
import org.dog.server.domain.Dept;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.dog.server.mapper.DeptMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.dog.server.service.IDeptService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/server/dept")
public class DeptController {

    @Resource
    private IDeptService deptService;

    @GetMapping("/list1/{deptId}")
    public AjaxResult list1(@PathVariable(value = "deptId") Long deptId) {
        return AjaxResult.success(deptService.selectDeptList1(deptId));
    }

    @GetMapping("/list2")
    public AjaxResult list2() {
        return AjaxResult.success(deptService.selectDeptList2());
    }

    @GetMapping("/list3")
    public AjaxResult list3() {
        return AjaxResult.success(deptService.selectDeptList3());
    }
}
