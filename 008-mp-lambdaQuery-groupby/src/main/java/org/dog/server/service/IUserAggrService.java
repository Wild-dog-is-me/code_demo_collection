package org.dog.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.dog.server.domain.User;
import org.dog.server.domain.UserAggr;
import org.dog.server.entity.UserAggrVo;

import java.util.List;

public interface IUserAggrService extends IService<UserAggr> {

    public List<UserAggr> selectUserList1();

    public List<UserAggrVo> selectUserList2();

}
