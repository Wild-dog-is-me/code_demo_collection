package org.dog.server.service;
import com.baomidou.mybatisplus.extension.service.IService;
import org.dog.server.domain.Company;

import java.util.List;

public interface ICompanyService extends IService<Company>{

    public List<Company> selectCompanyList(List<String> industry, List<String> province, List<String> round);

}
