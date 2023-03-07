package org.dog.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.dog.server.domain.StuSubRelation;
import org.dog.server.mapper.StuSubRelationMapper;
import org.dog.server.service.IStuSubRelationService;
import org.springframework.stereotype.Service;

@Service
public class StuSubRelationServiceImpl extends ServiceImpl<StuSubRelationMapper, StuSubRelation> implements IStuSubRelationService {
}
