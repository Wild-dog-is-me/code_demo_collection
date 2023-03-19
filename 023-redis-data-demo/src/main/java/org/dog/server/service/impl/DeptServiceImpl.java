package org.dog.server.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.dog.server.domain.Dept;
import org.dog.server.mapper.DeptMapper;
import org.dog.server.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper,Dept> implements IDeptService{
    @Override
    public Dept selectDept1() {
        return null;
    }

    @Override
    public Dept selectDept2() {
        return null;
    }

    @Override
    public List<Dept> selectDept3() {
        return null;
    }

    @Override
    public List<Dept> selectDept4() {
        return null;
    }
}
