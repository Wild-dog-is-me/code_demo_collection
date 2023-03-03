package org.dog.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dog.server.domain.UserAggr;

/**
 * @Author: Odin
 * @Date: 2023/3/2 10:42
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAggrVo extends UserAggr {

    private String deptName;

    public UserAggrVo(UserAggr user) {
        super(user);
    }

}
