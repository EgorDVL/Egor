package com.zhyzhko.util.converter;

import com.zhyzhko.dao.entity.Status;
import com.zhyzhko.dto.StatusDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Egor on 09.04.2017.
 */
@Component
public class StatusConverter {
    @Autowired
    public ModelMapper modelMapper;

    public StatusDto convertToDto(Status status) {
        return modelMapper.map(status, StatusDto.class);
    }

    public Status convertToEntity(StatusDto statusDto) {
        return modelMapper.map(statusDto, Status.class);
    }
}
