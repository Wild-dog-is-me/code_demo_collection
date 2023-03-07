package org.dog.server.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.checkerframework.checker.units.qual.A;
import org.dog.server.domain.Company;
import org.dog.server.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xin.altitude.cms.common.entity.AjaxResult;
import xin.altitude.cms.common.entity.PageEntity;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/server/company")
public class CompanyController {

    @Resource
    private ICompanyService companyService;

    @GetMapping("/list1")
    public AjaxResult list1(List<String> industry,List<String> province,List<String> round) {
        List<Company> companies = companyService.selectCompanyList(industry, province, round);
        return AjaxResult.success(companies);
    }

}
