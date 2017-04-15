package com.zhyzhko.service.impl;

import com.zhyzhko.dao.TypeDao;
import com.zhyzhko.dao.entity.Ttype;
import com.zhyzhko.dto.TypeDto;
import com.zhyzhko.service.TypeService;
import com.zhyzhko.util.converter.TypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Egor on 09.04.2017.
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeDao typeDao;

    @Autowired
    private TypeConverter converter;

    @Transactional
    @Override
    public TypeDto createType(TypeDto typeDto) {
        Ttype type = converter.convertToEntity(typeDto);
        return converter.convertToDto(typeDao.createType(type));
    }

    @Transactional
    @Override
    public TypeDto getType(int typeId) {
        return converter.convertToDto(typeDao.getType(typeId));
    }

    @Transactional
    @Override
    public List<TypeDto> getAllType() {
        return mapTypeDto(typeDao.getAllType());
    }

    @Transactional
    @Override
    public boolean updateType(TypeDto typeDto) {
        Ttype type = converter.convertToEntity(typeDto);
        return typeDao.updateType(type);
    }

    @Transactional
    @Override
    public boolean deleteType(int typeId) {
        return typeDao.deleteType(typeId);
    }

    private List<TypeDto> mapTypeDto(List<Ttype> types) {
        return types
                .stream()
                .map(converter::convertToDto)
                .collect(Collectors.toList());
    }
}
