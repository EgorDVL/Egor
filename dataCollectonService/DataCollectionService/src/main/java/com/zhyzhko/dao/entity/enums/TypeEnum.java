package com.zhyzhko.dao.entity.enums;

import java.util.Arrays;

/**
 * Created by Egor on 09.04.2017.
 */
public enum TypeEnum {
    SIMPLE_LINE(1),
    MULTI_LINE(2),
    RADIO_BUTTON(3),
    CHECK_BOX(4),
    COMBO_BOX(5),
    DATE(6);

    private int code;

    TypeEnum(int code) {
        this.code = code;
    }

    public static TypeEnum fromCode(int code) {
        return Arrays.stream(values())
                .filter(type -> type.code == code)
                .findFirst()
                .orElse(null);
    }

    public int getCode() {
        return this.code;
    }
}
