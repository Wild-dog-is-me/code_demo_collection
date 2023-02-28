package org.dog.server.service;
import com.baomidou.mybatisplus.extension.service.IService;
import org.dog.server.domain.Apple;

import java.util.List;
import java.util.Map;

public interface IAppleService extends IService<Apple>{

    public List<Apple> selectAppleList1();

    public List<Apple> selectAppleList2();

    public List<Apple> selectAppleList3();

    public List<Apple> selectAppleList4();

    public Map<String, Apple> selectAppleList7();

}
