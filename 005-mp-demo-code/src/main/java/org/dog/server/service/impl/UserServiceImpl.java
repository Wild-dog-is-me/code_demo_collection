package org.dog.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.dog.server.domain.User;
import org.dog.server.mapper.UserMapper;
import org.dog.server.service.UserService;
import org.springframework.stereotype.Service;
import xin.altitude.cms.common.util.MapUtils;

import java.util.HashMap;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: Odin
 * @Date: 2023/2/27 00:13
 * @Description:
 */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    /**
     * （方法一）计数操作 ｜ 按照部门统计用户数
     */
    @Override
    public Map<Long, Long> selectUserList1() {
        List<User> list = this.list();
        /**
         *   key:deptId
         * value:每个部门的用户数
         */
        Map<Long, Long> map =
                list.stream().collect(Collectors.groupingBy(User::getDeptId,
                        Collectors.counting()));
        return map;
    }

    /**
     * （方法二）计数操作 ｜ 按照部门统计用户数
     */
    @Override
    public Map<Long, Long> selectUserList2() {
        List<User> list = this.list();
        /**
         *   key:deptId
         * value:summarizingLong -> 包含count、sum、max、min
         */
        Map<Long, LongSummaryStatistics> map =
                list.stream().collect(Collectors.groupingBy(User::getDeptId,
                        Collectors.summarizingLong(User::getUserId)));
        System.out.println(map);
        // 不使用java8新特性
        HashMap<Long, Long> hashMap = new HashMap<>();
        for (Map.Entry<Long, LongSummaryStatistics> entry : map.entrySet()) {
            hashMap.put(entry.getKey(), Long.valueOf(entry.getValue().getCount()));
        }
        /**
         *   key:deptId
         * value:每个部门的用户数
         */
        Map<Long, Long> newMap = MapUtils.transMap(map, LongSummaryStatistics::getCount);
        return newMap;
    }

    /**
     * 分组统计用户表中对应性别的年龄平均值
     */
    public Map<String, Double> selectUserList3() {
        List<User> list = this.list();
        /**
         *   key:性别
         * value:summarizingLong -> 包含count、sum、max、min
         */
        Map<String, LongSummaryStatistics> map =
                list.stream().collect(Collectors.groupingBy(User::getSex,
                        Collectors.summarizingLong(User::getAge)));
        System.out.println(map);
        /**
         *   key:性别
         * value:平均年龄
         */
        Map<String, Double> newMap = MapUtils.transMap(map, LongSummaryStatistics::getAverage);
        return newMap;
    }

    /**
     * 分组统计用户表中对应性别的年龄最大值
     */
    public Map<String, Long> selectUserList4() {
        List<User> list = this.list();
        Map<String, LongSummaryStatistics> collect = list.stream().collect(Collectors.groupingBy(User::getSex, Collectors.summarizingLong(User::getAge)));
        Map<String, Long> newMap = MapUtils.transMap(collect, LongSummaryStatistics::getMax);
        return newMap;

    }

    /**
     * 分组统计用户表中对应性别的年龄最小值
     */
    @Override
    public Map<String, Long> selectUserList5() {
        List<User> list = this.list();
        Map<String, LongSummaryStatistics> collect = list.stream().collect(Collectors.groupingBy(User::getSex, Collectors.summarizingLong(User::getAge)));
        Map<String, Long> newMap = MapUtils.transMap(collect, LongSummaryStatistics::getMin);
        return newMap;
    }

    /**
     * 分组统计用户表中对应性别的年龄和
     */
    @Override
    public Map<String, Long> selectUserList6() {
        List<User> list = this.list();
        Map<String, LongSummaryStatistics> collect = list.stream().collect(Collectors.groupingBy(User::getSex, Collectors.summarizingLong(User::getAge)));
        Map<String, Long> newMap = MapUtils.transMap(collect, LongSummaryStatistics::getSum);
        return newMap;
    }
}
