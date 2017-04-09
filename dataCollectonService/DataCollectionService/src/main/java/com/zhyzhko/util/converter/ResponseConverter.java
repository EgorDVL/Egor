package com.zhyzhko.util.converter;

import com.zhyzhko.dao.entity.Response;
import com.zhyzhko.dto.ResponseDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Egor on 09.04.2017.
 */
@Component
public class ResponseConverter {
    @Autowired
    public ModelMapper modelMapper;

    public ResponseDto convertToDto(Response response) {
        return modelMapper.map(response, ResponseDto.class);
    }

    public Response convertToEntity(ResponseDto responseDto) {
        return modelMapper.map(responseDto, Response.class);
    }
}
