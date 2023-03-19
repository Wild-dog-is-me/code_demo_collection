package org.dog.server.service;
import com.baomidou.mybatisplus.extension.service.IService;
import org.dog.server.domain.Dept;
import org.dog.server.domain.User;

import java.util.List;

public interface IDeptService extends IService<Dept>{
    Dept selectDept1();

    Dept selectDept2();

    List<Dept> selectDept3();

    List<Dept> selectDept4();
}
