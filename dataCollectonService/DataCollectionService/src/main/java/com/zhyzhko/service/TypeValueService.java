package com.zhyzhko.service;

import com.zhyzhko.dto.TypeValueDto;

import java.util.List;

/**
 * Created by Egor on 09.04.2017.
 */
public interface TypeValueService {
    TypeValueDto createTypeValue(TypeValueDto typeValueDto);

    TypeValueDto getTypeValue(int typeValueId);

    List<TypeValueDto> getAllTypeValue();

    boolean updateTypeValue(TypeValueDto typeValueDto);

    boolean deleteTypeValue(int typeValueId);
}
