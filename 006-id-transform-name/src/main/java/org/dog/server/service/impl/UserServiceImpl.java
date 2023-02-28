package org.dog.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.dog.server.domain.Dept;
import org.dog.server.domain.Post;
import org.dog.server.domain.Region;
import org.dog.server.domain.User;
import org.dog.server.entity.UserVo;
import org.dog.server.mapper.DeptMapper;
import org.dog.server.mapper.PostMapper;
import org.dog.server.mapper.RegionMapper;
import org.dog.server.mapper.UserMapper;
import org.dog.server.service.IUserService;
import org.springframework.stereotype.Service;
import xin.altitude.cms.common.util.EntityUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private DeptMapper deptMapper;

    @Resource
    private PostMapper postMapper;

    @Resource
    private RegionMapper regionMapper;

    /**
     * 直接查询用户表中的原始数据
     */
    @Override
    public List<User> selectUserList1() {
        return this.list();
    }

    /**
     * 将User转换为UserVo 并对其中name字段进行赋值
     * 理论分析：至少查询一次DB，至多查询四次DB
     * 效率分析：通过ID取name涉及到的索引查询 -> 主键查询，那么肯定走索引，且会比通常的索引要快，可能涉及到聚簇索引
     * 数据量增长时，时间复杂度变化趋势 -> 几乎没有影响
     */
    @Override
    public List<UserVo> selectUserList2() {
        List<User> userList = this.list();
        List<UserVo> userVoList = EntityUtils.toList(userList, UserVo::new);

        // 代码运行时健壮性优化，提高效率
        if (userList.size() > 0) {
            // 查询出所有ID
            Set<Long> deptIds = EntityUtils.toSet(userVoList, UserVo::getDeptId);
            Set<Integer> postIds = EntityUtils.toSet(userVoList, UserVo::getPostId);
            Set<Integer> regionIds = EntityUtils.toSet(userVoList, UserVo::getRegionId);
//            方法一
            // 查询出所有ID对应的部门信息
            List<Dept> deptList = deptMapper
                    .selectList(Wrappers.lambdaQuery(Dept.class)
                    .in(Dept::getDeptId, deptIds));
            List<Post> postList = postMapper
                    .selectList(Wrappers.lambdaQuery(Post.class)
                    .in(Post::getPostId, postIds));
            List<Region> regionList = regionMapper
                    .selectList(Wrappers.lambdaQuery(Region.class)
                    .in(Region::getRegionId, regionIds));

            // key为主键ID，value为name
            Map<Long, String> deptMap =
                    EntityUtils.toMap(deptList, Dept::getDeptId, Dept::getDeptName);
            Map<Integer, String> postMap =
                    EntityUtils.toMap(postList, Post::getPostId, Post::getPostName);
            Map<Integer, String> regionMap =
                    EntityUtils.toMap(regionList, Region::getRegionId, Region::getRegionName);

            // 赋值给Vo
            for (UserVo userVo : userVoList) {
                userVo.setDeptName(deptMap.get(userVo.getDeptId()));
                userVo.setPostName(postMap.get(userVo.getPostId()));
                userVo.setRegionName(regionMap.get(userVo.getRegionId()));
            }
//            方法二
//            if (userVoList.size() > 0) {
//                addDeptName(userVoList, deptIds);
//            }
        }
        return userVoList;
    }

    /**
     * 添加名称
     * @param userVoList
     * @param deptIds
     */
    private void addDeptName(List<UserVo> userVoList, Set<Long> deptIds) {
        LambdaQueryWrapper<Dept> wrap1 = Wrappers.lambdaQuery(Dept.class)
                .in(Dept::getDeptId, deptIds)
                .select(Dept::getDeptId, Dept::getDeptName);
        List<Dept> deptIdList = deptMapper.selectList(wrap1);
        Map<Long, String> map1 = EntityUtils.toMap(deptIdList, Dept::getDeptId, Dept::getDeptName);
        userVoList.forEach(e -> e.setDeptName(map1.get(e.getDeptId())));
    }
}
