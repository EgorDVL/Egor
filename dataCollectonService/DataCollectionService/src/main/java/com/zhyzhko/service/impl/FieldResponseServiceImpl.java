package com.zhyzhko.service.impl;

import com.zhyzhko.dao.FieldResponseDao;
import com.zhyzhko.dao.entity.FieldResponse;
import com.zhyzhko.dto.FieldResponseDto;
import com.zhyzhko.service.FieldResponseService;
import com.zhyzhko.util.converter.FieldResponseConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Egor on 09.04.2017.
 */
@Service
public class FieldResponseServiceImpl implements FieldResponseService {
    @Autowired
    private FieldResponseDao fieldResponseDao;

    @Autowired
    private FieldResponseConverter converter;

    @Transactional
    @Override
    public FieldResponseDto createFieldResponse(FieldResponseDto fieldResponseDto) {
        FieldResponse fieldResponse = converter.convertToEntity(fieldResponseDto);
        return converter.convertToDto(fieldResponseDao.createFieldResponse(fieldResponse));
    }

    @Transactional
    @Override
    public FieldResponseDto getFieldResponse(int fieldResponseId) {
        return converter.convertToDto(fieldResponseDao.getFieldResponse(fieldResponseId));
    }

    @Transactional
    @Override
    public List<FieldResponseDto> getAllFieldResponse() {
        return mapFieldResponseDto(fieldResponseDao.getAllFieldResponse());
    }

    @Transactional
    @Override
    public boolean updateFieldResponse(FieldResponseDto fieldResponseDto) {
        FieldResponse fieldResponse = converter.convertToEntity(fieldResponseDto);
        return fieldResponseDao.updateFieldResponse(fieldResponse);
    }

    @Transactional
    @Override
    public boolean deleteFieldResponse(int fieldResponseId) {
        return fieldResponseDao.deleteFieldResponse(fieldResponseId);
    }

    private List<FieldResponseDto> mapFieldResponseDto(List<FieldResponse> fieldResponseList) {
        return fieldResponseList
                .stream()
                .map(converter::convertToDto)
                .collect(Collectors.toList());
    }
}