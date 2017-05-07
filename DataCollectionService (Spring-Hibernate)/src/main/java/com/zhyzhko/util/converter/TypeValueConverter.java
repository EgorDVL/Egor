package com.zhyzhko.util.converter;

import com.zhyzhko.dao.entity.TypeValue;
import com.zhyzhko.dto.TypeValueDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Egor on 09.04.2017.
 */
@Component
public class TypeValueConverter {
    @Autowired
    public ModelMapper modelMapper;

    public TypeValueDto convertToDto(TypeValue typeValue) {
        return modelMapper.map(typeValue, TypeValueDto.class);
    }

    public TypeValue convertToEntity(TypeValueDto typeValueDto) {
        return modelMapper.map(typeValueDto, TypeValue.class);
    }
}
