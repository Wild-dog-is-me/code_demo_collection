package org.dog.server.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.dog.server.domain.Dept;
import org.dog.server.entity.vo.DeptVo;
import org.dog.server.mapper.DeptMapper;
import org.dog.server.service.IDeptService;
import org.springframework.stereotype.Service;
import xin.altitude.cms.common.util.EntityUtils;

@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper,Dept> implements IDeptService{
    @Override
    public DeptVo selectDeptList1(Long deptId) {
        Dept dept = this.getById(deptId);
        DeptVo deptVo = EntityUtils.toObj(dept, DeptVo::new);
        return deptVo;
    }
}
