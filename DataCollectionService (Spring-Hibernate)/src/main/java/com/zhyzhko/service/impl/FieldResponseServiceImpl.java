package com.zhyzhko.service.impl;

import com.zhyzhko.controllers.forms.ResponseCollectionShowForm;
import com.zhyzhko.dao.FieldResponseDao;
import com.zhyzhko.dao.entity.FieldResponse;
import com.zhyzhko.dto.*;
import com.zhyzhko.service.FieldResponseService;
import com.zhyzhko.util.converter.FieldResponseConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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

    @Autowired
    private HttpSession session;

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

    @Override
    public Map<FieldDto, List<String>> showAllResponses(List<FieldDto> fieldDtoList, List<FieldResponseDto> fieldResponseDtoList) {
        Map<FieldDto, List<String>> map = new LinkedHashMap<>();
        addingAllFields(fieldDtoList, map);
        substituteValueById(fieldResponseDtoList, map);
        return map;
    }

    private void substituteValueById(List<FieldResponseDto> fieldResponseDtoList, Map<FieldDto, List<String>> map) {
        for (Map.Entry<FieldDto, List<String>> entry : map.entrySet()) {
            fieldResponseDtoList.stream().filter(responseDto -> entry.getKey().getId() == responseDto.getField().getId()).forEach(responseDto -> {
                List<String> listValues = entry.getValue();
                listValues.add(responseDto.getValue());
            });
        }
    }

    private void addingAllFields(List<FieldDto> fieldDtoList, Map<FieldDto, List<String>> map) {
        for (FieldDto fieldDto : fieldDtoList) {
            map.put(fieldDto, new ArrayList<>());
        }
    }

    @Transactional
    @Override
    public void createFieldResponseFromForm(List<ResponseCollectionShowForm> showFormList, ResponseDto responseDto) {
        for (ResponseCollectionShowForm form : showFormList) {
            FieldDto fieldDto = getFieldDto(form);
            String listString;
            if (form.getTypeValues() == null) {
                listString = "";
            } else {
                listString = String.join(", ", form.getTypeValues());
            }
            createFieldResponse(new FieldResponseDto(responseDto.getId(), fieldDto, listString));
        }
    }

    private FieldDto getFieldDto(ResponseCollectionShowForm form) {
        return new FieldDto(form.getFieldId(),
                form.getFieldLabel(),
                new TypeDto(form.getTypeName()),
                new RequiredDto(form.isRequired()),
                new StatusDto(form.isStatus()));
    }

}