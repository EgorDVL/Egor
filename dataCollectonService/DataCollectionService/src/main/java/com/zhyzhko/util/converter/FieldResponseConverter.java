package com.zhyzhko.util.converter;

import com.zhyzhko.dao.entity.FieldResponse;
import com.zhyzhko.dto.FieldResponseDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Egor on 09.04.2017.
 */
@Component
public class FieldResponseConverter {
    @Autowired
    public ModelMapper modelMapper;

    public FieldResponseDto convertToDto(FieldResponse fieldResponse) {
        return modelMapper.map(fieldResponse, FieldResponseDto.class);
    }

    public FieldResponse convertToEntity(FieldResponseDto fieldResponseDto) {
        return modelMapper.map(fieldResponseDto, FieldResponse.class);
    }
}
