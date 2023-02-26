package org.dog.server.service;

import org.dog.server.domain.User;
import org.springframework.transaction.annotation.Transactional;
import xin.altitude.cms.common.support.ICacheService;

/**
 * @Author: Odin
 * @Date: 2023/2/26 23:05
 * @Description:
 */
public interface UserService extends ICacheService<User> {

    /**
     * 一、普通更新
     *
     * @return
     */
    boolean updateUser1(User user);

    /**
     * 二、Mysql与缓存一致性更新
     */
    @Transactional(rollbackFor = Exception.class)
    boolean updateUser2(User user);

    boolean updateUser3(User user);


}
