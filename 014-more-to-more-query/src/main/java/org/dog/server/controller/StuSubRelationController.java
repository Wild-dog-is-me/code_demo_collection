package org.dog.server.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.dog.server.mapper.StuSubRelationMapper;
import java.util.Arrays;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.dog.server.domain.StuSubRelation;
import xin.altitude.cms.common.entity.AjaxResult;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import xin.altitude.cms.common.entity.PageEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.dog.server.service.IStuSubRelationService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/server/stu/sub/relation")
public class StuSubRelationController {

}
