package org.dog.server.service;
import com.baomidou.mybatisplus.extension.service.IService;
import org.dog.server.domain.User;

public interface IUserService extends IService<User>{

    public boolean updateUserAge1(Long userId);

    public boolean updateUserAge2(Long userId);
}
