package com.zhyzhko.util.converter;

import com.zhyzhko.dao.entity.Ttype;
import com.zhyzhko.dto.TypeDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Egor on 09.04.2017.
 */
@Component
public class TypeConverter {
    @Autowired
    public ModelMapper modelMapper;

    public TypeDto convertToDto(Ttype type) {
        return modelMapper.map(type, TypeDto.class);
    }

    public Ttype convertToEntity(TypeDto typeDto) {
        return modelMapper.map(typeDto, Ttype.class);
    }
}
