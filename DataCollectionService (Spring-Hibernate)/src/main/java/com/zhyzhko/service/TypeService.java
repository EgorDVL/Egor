package com.zhyzhko.service;

import com.zhyzhko.dto.TypeDto;

import java.util.List;

/**
 * Created by Egor on 09.04.2017.
 */
public interface TypeService {
    TypeDto createType(TypeDto typeDto);

    TypeDto getType(int typeId);

    List<TypeDto> getAllType();

    boolean updateType(TypeDto typeDto);

    boolean deleteType(int typeId);
}
