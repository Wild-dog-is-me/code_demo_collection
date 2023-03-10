package org.dog.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.dog.server.domain.User;
import org.dog.server.domain.UserAggr;
import org.dog.server.entity.UserAggrVo;

import java.util.List;

public interface IUserService extends IService<User> {

    public List<UserAggr> selectList1();

    public List<UserAggrVo> selectList2();
}
