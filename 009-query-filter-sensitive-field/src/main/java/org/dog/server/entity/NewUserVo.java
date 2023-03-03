package org.dog.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dog.server.domain.Dept;

/**
 * @Author: Odin
 * @Date: 2023/3/3 14:26
 * @Description:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewUserVo extends UserPo{

    private String deptName;

    private String tel;

    public NewUserVo(UserPo user) {
        super(user);
    }

    public void addDeptInfo(Dept dept) {
        this.deptName = dept.getDeptName();
        this.tel = dept.getTel();
    }
}
