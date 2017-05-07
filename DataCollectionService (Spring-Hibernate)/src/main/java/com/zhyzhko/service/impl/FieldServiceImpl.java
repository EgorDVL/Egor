package com.zhyzhko.service.impl;

import com.zhyzhko.controllers.forms.FieldForm;
import com.zhyzhko.controllers.forms.ResponseCollectionCreateForm;
import com.zhyzhko.controllers.forms.ResponseCollectionShowForm;
import com.zhyzhko.dao.FieldDao;
import com.zhyzhko.dao.entity.Field;
import com.zhyzhko.dao.entity.enums.TypeEnum;
import com.zhyzhko.dto.*;
import com.zhyzhko.service.FieldService;
import com.zhyzhko.service.TypeService;
import com.zhyzhko.service.TypeValueService;
import com.zhyzhko.util.converter.FieldConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Egor on 09.04.2017.
 */
@Service
public class FieldServiceImpl implements FieldService {

    private static final String RADIO_BUTTON_FIELD_TYPE = "Radio";
    private static final String CHECK_BOX_FIELD_TYPE = "Check box";
    private static final String COMBO_BOX_FIELD_TYPE = "Combo box";

    @Autowired
    private FieldDao fieldDao;

    @Autowired
    private FieldConverter converter;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TypeValueService typeValueService;

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
    public FieldDto createField(FieldForm fieldForm) {
        RequiredDto requiredDto = getRequiredDto(fieldForm);

        StatusDto statusDto = getStatusDto(fieldForm);
//        TypeDto typeDto = typeService.createType(new TypeDto(fieldForm.getType()));
        TypeDto typeDto = typeService.createType(new TypeDto(TypeEnum.getValue(fieldForm.getType()).toString()));

        FieldDto fieldDto = getFieldDto(fieldForm, requiredDto, statusDto, typeDto);

        Field field = converter.convertToEntity(fieldDto);
        return converter.convertToDto(fieldDao.createField(field));
    }

    private FieldDto getFieldDto(FieldForm fieldForm, RequiredDto requiredDto, StatusDto statusDto, TypeDto typeDto) {
        FieldDto fieldDto = new FieldDto(fieldForm.getLabel(), typeDto, requiredDto, statusDto);
        createTypeValues(fieldForm, fieldDto);
        return fieldDto;
    }

    private StatusDto getStatusDto(FieldForm fieldForm) {
        StatusDto statusDto;
        if (fieldForm.isStatus()) {
            statusDto = new StatusDto(1, true);
        } else {
            statusDto = new StatusDto(2, false);
        }
        return statusDto;
    }

    private RequiredDto getRequiredDto(FieldForm fieldForm) {
        RequiredDto requiredDto;
        if (fieldForm.isRequired()) {
            requiredDto = new RequiredDto(1, true);
        } else {
            requiredDto = new RequiredDto(2, false);
        }
        return requiredDto;
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

    @Transactional
    @Override
    public boolean updateFieldForm(FieldForm fieldForm, FieldDto fieldDto) {
        Field field = converter.convertToEntity(updateFieldDto(fieldForm, fieldDto));
        return fieldDao.updateField(field);
    }

    private FieldDto updateFieldDto(FieldForm fieldForm, FieldDto fieldDto) {
        fieldDto.setLabel(fieldForm.getLabel());
        fieldDto.setType(typeService.createType(new TypeDto(TypeEnum.getValue(fieldForm.getType()).toString())));

        createTypeValues(fieldForm, fieldDto);
        return fieldDto;
    }

    private void createTypeValues(FieldForm fieldForm, FieldDto fieldDto) {
        if (isFieldValuePresent(fieldForm) && isRequiredField(fieldForm)) {
            String[] filedValues = splitMultiValueField(fieldForm);
            Stream.of(filedValues)
                    .forEach(value -> typeValueService.createTypeValue(new TypeValueDto(value, fieldDto.getType().getId())));
        }
    }

    private String[] splitMultiValueField(FieldForm fieldForm) {
        return fieldForm.getTypeValue().replace(" ", "").split(",");
    }

    private boolean isFieldValuePresent(FieldForm fieldForm) {
        return fieldForm.getTypeValue() != null;
    }

    private boolean isRequiredField(FieldForm fieldForm) {
        return fieldForm.getType().equalsIgnoreCase(RADIO_BUTTON_FIELD_TYPE)
                || fieldForm.getType().equalsIgnoreCase(CHECK_BOX_FIELD_TYPE)
                || fieldForm.getType().equalsIgnoreCase(COMBO_BOX_FIELD_TYPE);
    }

    @Transactional
    @Override
    public boolean updateRequired(int requiredId, int id) {
        return fieldDao.updateRequired(requiredId, id);
    }

    @Transactional
    @Override
    public boolean updateStatus(int statusId, int id) {
        return fieldDao.updateStatus(statusId, id);
    }


    @Transactional
    @Override
    public ResponseCollectionCreateForm getResponseCollectionCreateForm(List<FieldDto> fieldDtoList) {
        List<ResponseCollectionShowForm> collectionShowForm = new ArrayList<>();
        prepareModelResponseCollectionForm(fieldDtoList, collectionShowForm);

        ResponseCollectionCreateForm createForm = new ResponseCollectionCreateForm();
        createForm.setShowForms(collectionShowForm);
        return createForm;
    }

    private void prepareModelResponseCollectionForm(List<FieldDto> fieldDtoList, List<ResponseCollectionShowForm> collectionShowForm) {
        for (FieldDto fieldDto : fieldDtoList) {
            List<TypeValueDto> typeValuesDto = typeValueService.getAllTypeValueByTypeId(fieldDto.getType().getId());
            collectionShowForm.add(new ResponseCollectionShowForm(
                    fieldDto.getId(),
                    fieldDto.getLabel(),
                    fieldDto.getType().getTypeName(),
                    typeValuesDto.stream().map(TypeValueDto::getValue).collect(Collectors.toList()),
                    fieldDto.getRequired().isValue(),
                    fieldDto.getStatus().isValue()));

        }
    }

    @Transactional
    @Override
    public boolean updateFieldStatusRequired(FieldForm fieldForm) {
        updateRequiredService(fieldForm);
        updateStatusService(fieldForm);
        return true;
    }

    private void updateStatusService(FieldForm fieldForm) {
        if (fieldForm.isStatus()) {
            updateStatus(1, fieldForm.getId());
        } else {
            updateStatus(2, fieldForm.getId());
        }
    }

    private void updateRequiredService(FieldForm fieldForm) {
        if (fieldForm.isRequired()) {
            updateRequired(1, fieldForm.getId());
        } else {
            updateRequired(2, fieldForm.getId());
        }
    }
}
