package com.zhyzhko.service.impl;

import com.zhyzhko.dao.FieldDao;
import com.zhyzhko.dao.entity.Field;
import com.zhyzhko.dto.FieldDto;
import com.zhyzhko.service.FieldService;
import com.zhyzhko.util.converter.FieldConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Egor on 09.04.2017.
 */
@Service
public class FieldServiceImpl implements FieldService {
    @Autowired
    private FieldDao fieldDao;

    @Autowired
    private FieldConverter converter;

    @Transactional
    @Override
    public FieldDto createField(FieldDto fieldDto) {
        Field field = converter.convertToEntity(fieldDto);
        return converter.convertToDto(fieldDao.createField(field));
    }

    @Transactional
    @Override
    public FieldDto getField(int fieldId) {
        return converter.convertToDto(fieldDao.getField(fieldId));
    }

    @Transactional
    @Override
    public List<FieldDto> getAllField() {
        return mapFieldDto(fieldDao.getAllField());
    }

    @Transactional
    @Override
    public boolean updateField(FieldDto fieldDto) {
        Field field = converter.convertToEntity(fieldDto);
        return fieldDao.updateField(field);
    }

    @Transactional
    @Override
    public boolean deleteFielde(int fieldId) {
        return fieldDao.deleteField(fieldId);
    }

    private List<FieldDto> mapFieldDto(List<Field> fields) {
        return fields
                .stream()
                .map(converter::convertToDto)
                .collect(Collectors.toList());
    }
}
