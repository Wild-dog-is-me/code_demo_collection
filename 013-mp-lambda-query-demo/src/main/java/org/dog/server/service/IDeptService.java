package org.dog.server.service;
import com.baomidou.mybatisplus.extension.service.IService;
import org.dog.server.domain.Dept;
import org.dog.server.entity.vo.DeptVo;

public interface IDeptService extends IService<Dept>{

    public DeptVo selectDeptList1(Long deptId);
}
