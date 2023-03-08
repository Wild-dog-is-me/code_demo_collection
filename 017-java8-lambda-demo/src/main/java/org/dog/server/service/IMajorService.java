package org.dog.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.dog.server.domain.Major;

import java.util.List;
import java.util.Map;

public interface IMajorService extends IService<Major> {

    public Map<Long,String> selectMajor();
}
