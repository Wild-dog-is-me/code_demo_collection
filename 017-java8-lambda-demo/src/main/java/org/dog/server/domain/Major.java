package org.dog.server.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * 部门
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "tb_major")
public class Major {
    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.AUTO)
    private Long majorId;
    private String majorName;

    public Major(Major major) {
        if (Objects.nonNull(major)) {
            this.majorId = major.majorId;
            this.majorName = major.majorName;
        }
    }
}
