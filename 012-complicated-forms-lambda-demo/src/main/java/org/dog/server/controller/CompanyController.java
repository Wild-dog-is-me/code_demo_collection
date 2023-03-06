package org.dog.server.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.checkerframework.checker.units.qual.A;
import org.dog.server.domain.Company;
import org.dog.server.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xin.altitude.cms.common.entity.AjaxResult;
import xin.altitude.cms.common.entity.PageEntity;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/server/company")
public class CompanyController {
    @Autowired
    private ICompanyService companyService;

    @GetMapping("/list1")
    public AjaxResult list1(@RequestParam(value = "industry") List<String> industry,@RequestParam(value = "province")  List<String> province,@RequestParam(value = "round") List<String> round) {
        List<Company> companies = companyService.selectCompanyList(industry, province, round);
        return AjaxResult.success(companies);
    }

    @GetMapping("/del/batch")
    public AjaxResult delBatch(@RequestBody List<Integer> ids) {
        return AjaxResult.success(companyService.removeByIds(ids));
    }

    @GetMapping("/page")
    public AjaxResult page(PageEntity pageEntity, Company company) {
        return AjaxResult.success(companyService.page(pageEntity.toPage(), Wrappers.lambdaQuery(company)));
    }

    @GetMapping("/list")
    public AjaxResult list(Company company) {
        return AjaxResult.success(companyService.list(Wrappers.lambdaQuery(company)));
    }

    @PostMapping("/push")
    public AjaxResult add(@RequestBody Company company) {
        return AjaxResult.success(companyService.save(company));
    }

    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody Company company) {
        return AjaxResult.success(companyService.updateById(company));
    }

    @DeleteMapping("/delete/{ids}")
    public AjaxResult delete(@PathVariable Integer[] ids) {
        return AjaxResult.success(companyService.removeByIds(Arrays.asList(ids)));
    }

    @GetMapping(value = "/detail/{id}")
    public AjaxResult detail(@PathVariable("id") Integer id) {
        return AjaxResult.success(companyService.getById(id));
    }
}
