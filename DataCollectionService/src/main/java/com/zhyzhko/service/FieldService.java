package com.zhyzhko.service;

import com.zhyzhko.controllers.forms.FieldForm;
import com.zhyzhko.controllers.forms.ResponseCollectionCreateForm;
import com.zhyzhko.dto.FieldDto;

import java.util.List;

/**
 * Created by Egor on 09.04.2017.
 */
public interface FieldService {
    FieldDto createField(FieldForm fieldForm);

    FieldDto getField(int fieldId);

    List<FieldDto> getAllField();

    boolean updateField(FieldDto fieldDto);

    boolean updateRequired(int requiredId, int id);

    boolean updateStatus(int statusId, int id);

    boolean deleteFielde(int fieldId);

    boolean updateFieldForm(FieldForm fieldForm, FieldDto fieldDto);

    boolean updateFieldStatusRequired(FieldForm fieldForm);

    ResponseCollectionCreateForm getResponseCollectionCreateForm(List<FieldDto> fieldDtoList);
}
