package com.zhyzhko.service;

import com.zhyzhko.dto.ResponseDto;

import java.util.List;

/**
 * Created by Egor on 09.04.2017.
 */
public interface ResponseService {
    ResponseDto createResponse(ResponseDto responseDto);

    ResponseDto getResponse(int responseId);

    List<ResponseDto> getAllResponse();

    boolean updateResponse(ResponseDto responseDto);

    boolean deleteResponse(int responseId);
}
