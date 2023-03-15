package org.dog.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.dog.server.domain.Company;
import org.dog.server.mapper.CompanyMapper;
import org.dog.server.service.ICompanyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements ICompanyService {

    @Override
    public List<Company> selectCompanyList(List<String> industry, List<String> province, List<String> round) {
        LambdaQueryWrapper<Company> wrapper = Wrappers.lambdaQuery(Company.class);
        if (industry.size() > 0) {
            wrapper.and(e -> {
                for (String s : industry) {
                    e.or(f -> f.eq(Company::getIndustry, s));
                }
            });
        }

//        if (province.size() > 0) {
//            wrapper.and(e -> {
//                for (String s : province) {
//                    e.or(f -> f.eq(Company::getProvince, s));
//                }
//            });
//        }
//
//        if (round.size() > 0) {
//            wrapper.and(e -> {
//                for (String s : round) {
//                    e.or(f -> f.eq(Company::getRound, s));
//                }
//            });
//        }
        System.out.println(wrapper.getTargetSql());
        return this.list(wrapper);
    }
}
