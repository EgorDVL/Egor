package com.zhyzhko.dao.entity.enums;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Egor on 09.04.2017.
 */
public enum TypeEnum {
    SIMPLE_LINE("Simple line"),
    MULTI_LINE("Multi line"),
    RADIO_BUTTON("Radio"),
    CHECK_BOX("Check box"),
    COMBO_BOX("Combo box"),
    DATE("Date");

    private String name;

    TypeEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static TypeEnum getValue(String typeName) {
        for (TypeEnum typeEnum : values()) {
            if (typeEnum.getName().toString().equalsIgnoreCase(typeName)) {
                return typeEnum;
            }
        }
        return null;
    }


    private int code;

    TypeEnum(int code) {
        this.code = code;
    }

    public static List<String> getEnumsValuesAsList() {
        return Stream.of(values())
                .map(typeEnum -> typeEnum.getName().toString())
                .collect(Collectors.toList());
    }
}
