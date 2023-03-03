package org.dog.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.dog.server.domain.User;
import org.dog.server.entity.NewUserVo;
import org.dog.server.entity.UserVo;

import java.util.List;

public interface IUserService extends IService<User> {

    public List<UserVo> selectUserList1();

    public List<NewUserVo> selectUserList2();

    public List<UserVo> selectUserList3();
}
