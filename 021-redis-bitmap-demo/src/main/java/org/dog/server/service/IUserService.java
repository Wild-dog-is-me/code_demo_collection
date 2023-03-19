package org.dog.server.service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.dog.server.domain.User;
import xin.altitude.cms.common.support.ICacheService;
import xin.altitude.cms.common.util.BeanCopyUtils;
import xin.altitude.cms.common.util.EntityUtils;
import xin.altitude.cms.common.util.SpringUtils;

public interface IUserService extends ICacheService<User> {
    /**
     * 演示一：无布隆过滤器 无缓存 主键查询数据
     */
    User selectUser1(Long userId);

    /**
     * 演示二：有布隆过滤器 无缓存 主键查询数据
     */
    User selectUser2(Long userId);

    /**
     * 演示三：有布隆过滤器 有缓存 主键查询数据
     */
    User selectUser3(Long userId);
}
