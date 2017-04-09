package com.zhyzhko.util.converter;

import com.zhyzhko.dao.entity.Field;
import com.zhyzhko.dto.FieldDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Egor on 09.04.2017.
 */
@Component
public class FieldConverter {

    @Autowired
    public ModelMapper modelMapper;

    public FieldDto convertToDto(Field field) {
        return modelMapper.map(field, FieldDto.class);
    }

    public Field convertToEntity(FieldDto fieldDto) {
        return modelMapper.map(fieldDto, Field.class);
    }
}
