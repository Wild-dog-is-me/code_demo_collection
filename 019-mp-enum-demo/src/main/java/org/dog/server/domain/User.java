package org.dog.server.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.EnumSerializer;
import com.sun.javafx.css.converters.EnumConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.dog.server.enums.GenderEnum;

/**
 * @Author: Odin
 * @Date: 2023/3/14 22:59
 * @Description:
 */

@Data
@TableName("ts_user")
@Accessors(chain = true)
public class User {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    /**
     * IEnum接口的枚举处理
     */
    private GenderEnum sex;

}
