package org.dog.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.dog.server.domain.User;

import java.util.List;

public interface IUserService extends IService<User> {

    public List<User> selectUserList1();

    public List<User> selectUserList2();

    public List<User> selectUserList3();

    public List<User> selectUserList4();

}
