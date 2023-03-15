package org.dog.server.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.Objects;

/**
 * @Author: Odin
 * @Date: 2023/3/14 23:02
 * @Description:
 */

@Getter
public enum GenderEnum implements IEnum<Integer> {

    /**
     * 1
     */
    MALE(1,"男"),

    /**
     * 2
     */
    FEMALE(2, "女"),

    /**
     * 3
     */
    UNKNOWN(3,"未知");

    @EnumValue
    private final int value;

    @JsonValue
    private final String desc;

    GenderEnum(final Integer value, final String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.desc;
    }
    @JsonCreator
    public static GenderEnum getByCode(int value) {
        for (GenderEnum gender : GenderEnum.values()) {
            if (Objects.equals(value, gender.getDesc())) {
                return gender;
            }
        }
        return null;
    }
}
