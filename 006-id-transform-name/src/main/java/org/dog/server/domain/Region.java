package org.dog.server.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "tb_region")
public class Region {
    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.AUTO)
    private Integer regionId;
    private String regionName;
    private Integer parentId;
    private String ancestors;
    private Integer regionSort;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    public Region(Region region) {
        if (Objects.nonNull(region)) {
            this.regionId = region.regionId;
            this.regionName = region.regionName;
            this.parentId = region.parentId;
            this.ancestors = region.ancestors;
            this.regionSort = region.regionSort;
            this.createTime = region.createTime;
            this.updateTime = region.updateTime;
        }
    }
}
