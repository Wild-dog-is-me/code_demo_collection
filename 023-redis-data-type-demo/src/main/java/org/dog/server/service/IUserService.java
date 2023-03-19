package org.dog.server.service;
import com.baomidou.mybatisplus.extension.service.IService;
import org.dog.server.domain.User;

import java.util.List;

public interface IUserService extends IService<User>{
    /**
     * 操作对象数据
     *
     * @param id
     * @return
     */
    User selectUser1(Long id);

    /**
     * 操作集合数据
     *
     * @param id
     * @return
     */
    List<User> selectUser2(Long id);

    /**
     * 操作对象数据
     *
     * @param id
     * @return
     */
    User selectUser3(Long id);

    /**
     * 操作集合数据
     *
     * @param id
     * @return
     */
    List<User> selectUser4(Long id);

    // *********** 高级使用
    User selectUser5(Long id);
}
