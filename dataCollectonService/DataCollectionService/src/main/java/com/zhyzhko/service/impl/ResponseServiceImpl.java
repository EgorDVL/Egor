package com.zhyzhko.service.impl;

import com.zhyzhko.dao.ResponseDao;
import com.zhyzhko.dao.entity.Response;
import com.zhyzhko.dto.ResponseDto;
import com.zhyzhko.service.ResponseService;
import com.zhyzhko.util.converter.ResponseConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Egor on 09.04.2017.
 */
@Service
public class ResponseServiceImpl implements ResponseService {
    @Autowired
    private ResponseDao responseDao;

    @Autowired
    private ResponseConverter converter;

    @Transactional
    @Override
    public ResponseDto createResponse(ResponseDto responseDto) {
        Response response = converter.convertToEntity(responseDto);
        return converter.convertToDto(responseDao.createResponse(response));
    }

    @Transactional
    @Override
    public ResponseDto getResponse(int responseId) {
        return converter.convertToDto(responseDao.getResponse(responseId));
    }

    @Transactional
    @Override
    public List<ResponseDto> getAllResponse() {
        return mapResponseDto(responseDao.getAllResponse());
    }

    @Transactional
    @Override
    public boolean updateResponse(ResponseDto responseDto) {
        Response response = converter.convertToEntity(responseDto);
        return responseDao.updateResponse(response);
    }

    @Transactional
    @Override
    public boolean deleteResponse(int responseId) {
        return responseDao.deleteResponse(responseId);
    }

    private List<ResponseDto> mapResponseDto(List<Response> responses) {
        return responses
                .stream()
                .map(converter::convertToDto)
                .collect(Collectors.toList());
    }
}
