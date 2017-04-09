package com.zhyzhko.service;

import com.zhyzhko.dto.FieldDto;

import java.util.List;

/**
 * Created by Egor on 09.04.2017.
 */
public interface FieldService {
    FieldDto createField(FieldDto fieldDto);

    FieldDto getField(int fieldId);

    List<FieldDto> getAllField();

    boolean updateField(FieldDto fieldDto);

    boolean deleteFielde(int fieldId);
}
