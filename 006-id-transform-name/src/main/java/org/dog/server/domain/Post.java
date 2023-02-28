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
@TableName(value = "tb_post")
public class Post {
    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.AUTO)
    private Integer postId;
    private String postCode;
    private String postName;
    private Integer postSort;
    private Integer status;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    public Post(Post post) {
        if (Objects.nonNull(post)) {
            this.postId = post.postId;
            this.postCode = post.postCode;
            this.postName = post.postName;
            this.postSort = post.postSort;
            this.status = post.status;
            this.createTime = post.createTime;
            this.updateTime = post.updateTime;
        }
    }
}
