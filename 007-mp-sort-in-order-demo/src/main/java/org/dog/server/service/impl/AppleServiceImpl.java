package org.dog.server.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.dog.server.domain.Apple;
import org.dog.server.mapper.AppleMapper;
import org.dog.server.service.IAppleService;
import org.springframework.stereotype.Service;
import xin.altitude.cms.common.util.ColUtils;
import xin.altitude.cms.common.util.MapUtils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AppleServiceImpl extends ServiceImpl<AppleMapper, Apple> implements IAppleService {

    private List<Apple> sourceList() {
        return this.list();
    }

    /**
     * 实现 Comparable 接口，完成排序
     */
    public List<Apple> selectAppleList1() {
        List<Apple> appleList = sourceList();
        Collections.sort(appleList);
        return appleList;
    }

    /**
     * 使用 Comparator + 匿名内部类来应对多变的排序需求
     */
    public List<Apple> selectAppleList2() {
        List<Apple> appleList = sourceList();
        // 使用Comparator实现自定义排序，灵活性更高 （）
        Collections.sort(appleList, new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight() - o2.getWeight();
            }
        });
        return appleList;
    }

    /**
     * 使用Lambda优化匿名内部类中代码
     */
    public List<Apple> selectAppleList3() {
        List<Apple> appleList = sourceList();
        Collections.sort(appleList, (o1, o2) -> o2.getWeight() - o1.getWeight());
        return appleList;
    }

    /**
     * 省份字符串排序
     */
    public List<Apple> selectAppleList4() {
        List<Apple> appleList = sourceList();
        Collections.sort(appleList, (o1, o2) -> o1.getOrigin().compareTo(o2.getOrigin()));
        return appleList;
    }

    /**
     * 传统方式取出集合中最值元素
     * <p>
     * 缺点：排序规则不直观
     */
    public Apple selectAppleList5() {
        List<Apple> appleList = sourceList();
        Collections.sort(appleList, (o1, o2) -> o1.getOrigin().compareTo(o2.getOrigin()));
        return appleList.get(appleList.size() - 1);
    }

    /**
     * 取出集合中最值元素
     * <p>
     * 优点：语义直观
     */
    public Apple selectAppleList6() {
        List<Apple> appleList = sourceList();
        return ColUtils.max(appleList, Apple::getWeight);
    }

    /**
     * 按产地分别取出最值苹果
     */
    public Map<String, Apple> selectAppleList7() {
        List<Apple> appleList = sourceList();
        Map<String, List<Apple>> collect = appleList.stream().collect(Collectors.groupingBy(Apple::getOrigin));
        return MapUtils.transMap(collect, e -> ColUtils.max(e, Apple::getWeight));
    }

}

