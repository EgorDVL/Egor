package com.zhyzhko.service.impl;

import com.zhyzhko.dao.RequiredDao;
import com.zhyzhko.dao.entity.Required;
import com.zhyzhko.dto.RequiredDto;
import com.zhyzhko.service.RequiredService;
import com.zhyzhko.util.converter.RequiredConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Egor on 09.04.2017.
 */
@Service
public class RequiredServiceImpl implements RequiredService {
    @Autowired
    private RequiredDao requiredDao;

    @Autowired
    private RequiredConverter converter;

    @Transactional
    @Override
    public RequiredDto createRequired(RequiredDto requiredDto) {
        Required required = converter.convertToEntity(requiredDto);
        return converter.convertToDto(requiredDao.createRequired(required));
    }

    @Transactional
    @Override
    public RequiredDto getRequired(int requiredId) {
        return converter.convertToDto(requiredDao.getRequired(requiredId));
    }

    @Transactional
    @Override
    public List<RequiredDto> getAllRequired() {
        return mapRequiredDto(requiredDao.getAllRequired());
    }

    @Transactional
    @Override
    public boolean updateRequired(RequiredDto requiredDto) {
        Required required = converter.convertToEntity(requiredDto);
        return requiredDao.updateRequired(required);
    }

    @Transactional
    @Override
    public boolean deleteRequired(int requiredId) {
        return requiredDao.deleteRequired(requiredId);
    }

    private List<RequiredDto> mapRequiredDto(List<Required> requireds) {
        return requireds
                .stream()
                .map(converter::convertToDto)
                .collect(Collectors.toList());
    }
}
