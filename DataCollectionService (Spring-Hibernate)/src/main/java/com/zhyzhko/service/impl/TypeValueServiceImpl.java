package com.zhyzhko.service.impl;

import com.zhyzhko.dao.TypeValueDao;
import com.zhyzhko.dao.entity.TypeValue;
import com.zhyzhko.dto.TypeValueDto;
import com.zhyzhko.service.TypeValueService;
import com.zhyzhko.util.converter.TypeValueConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Egor on 09.04.2017.
 */
@Service
public class TypeValueServiceImpl implements TypeValueService {

    @Autowired
    private TypeValueDao typeValueDao;

    @Autowired
    private TypeValueConverter converter;

    @Transactional
    @Override
    public TypeValueDto createTypeValue(TypeValueDto typeValueDto) {
        TypeValue typeValue = converter.convertToEntity(typeValueDto);
        return converter.convertToDto(typeValueDao.createTypeValue(typeValue));
    }

    @Transactional
    @Override
    public TypeValueDto getTypeValue(int typeValueId) {
        return converter.convertToDto(typeValueDao.getTypeValue(typeValueId));
    }

    @Transactional
    @Override
    public List<TypeValueDto> getAllTypeValue() {
        return mapTypeValueDto(typeValueDao.getAllTypeValue());
    }

    @Transactional
    @Override
    public List<TypeValueDto> getAllTypeValueByTypeId(int typeId) {
        return mapTypeValueDto(typeValueDao.getAllValueByTypeId(typeId));
    }

    @Transactional
    @Override
    public boolean updateTypeValue(TypeValueDto typeValueDto) {
        TypeValue typeValue = converter.convertToEntity(typeValueDto);
        return typeValueDao.updateTypeValue(typeValue);
    }

    @Transactional
    @Override
    public boolean deleteTypeValue(int typeValueId) {
        return typeValueDao.deleteTypeValue(typeValueId);
    }

    private List<TypeValueDto> mapTypeValueDto(List<TypeValue> typeValues) {
        return typeValues
                .stream()
                .map(converter::convertToDto)
                .collect(Collectors.toList());
    }
}
