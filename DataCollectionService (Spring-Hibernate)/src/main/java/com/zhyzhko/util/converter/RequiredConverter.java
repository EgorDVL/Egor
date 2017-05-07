package com.zhyzhko.util.converter;

import com.zhyzhko.dao.entity.Required;
import com.zhyzhko.dto.RequiredDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Egor on 09.04.2017.
 */
@Component
public class RequiredConverter {
    @Autowired
    public ModelMapper modelMapper;

    public RequiredDto convertToDto(Required required) {
        return modelMapper.map(required, RequiredDto.class);
    }

    public Required convertToEntity(RequiredDto requiredDto) {
        return modelMapper.map(requiredDto, Required.class);
    }
}
