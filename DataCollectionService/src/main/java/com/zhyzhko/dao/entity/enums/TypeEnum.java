package com.zhyzhko.dao.entity.enums;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public static List<String> getEnumsValuesAsList() {
        return Stream.of(values())
                .map(typeEnum -> typeEnum.toString())
                .collect(Collectors.toList());
    }
}
