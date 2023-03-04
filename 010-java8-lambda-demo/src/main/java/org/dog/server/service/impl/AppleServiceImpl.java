package org.dog.server.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.dog.server.domain.Apple;
import org.dog.server.mapper.AppleMapper;
import org.dog.server.service.IAppleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AppleServiceImpl extends ServiceImpl<AppleMapper,Apple> implements IAppleService{
}
