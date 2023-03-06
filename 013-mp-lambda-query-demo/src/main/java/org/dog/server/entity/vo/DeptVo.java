package org.dog.server.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dog.server.domain.Dept;
import org.dog.server.domain.User;

import javax.swing.plaf.ListUI;
import java.util.List;

/**
 * @Author: Odin
 * @Date: 2023/3/6 10:59
 * @Description:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeptVo extends Dept {

    private List<User> userList;

    public DeptVo(Dept dept) {
        super(dept);
    }

}

