package org.dog.server.service;
import com.baomidou.mybatisplus.extension.service.IService;
import org.dog.server.domain.Dept;
import org.dog.server.entity.vo.DeptVo;

import java.util.List;

public interface IDeptService extends IService<Dept>{

    /**
     * 根据部门Id查询该部门下的用户
     */
    public DeptVo selectDeptList1(Long deptId);

    /**
     * 查询所有部门下所对应的用户
     */
    public List<DeptVo> selectDeptList2();

    /**
     * 查询每个部门年龄最大的用户
     */
    public List<DeptVo> selectDeptList3();
}
