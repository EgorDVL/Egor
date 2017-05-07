package com.zhyzhko.service;

import com.zhyzhko.controllers.forms.ResponseCollectionShowForm;
import com.zhyzhko.dto.FieldDto;
import com.zhyzhko.dto.FieldResponseDto;
import com.zhyzhko.dto.ResponseDto;

import java.util.List;
import java.util.Map;

/**
 * Created by Egor on 09.04.2017.
 */
public interface FieldResponseService {
    FieldResponseDto createFieldResponse(FieldResponseDto fieldResponseDto);

    FieldResponseDto getFieldResponse(int fieldResponseId);

    List<FieldResponseDto> getAllFieldResponse();

    boolean updateFieldResponse(FieldResponseDto fieldResponseDto);

    boolean deleteFieldResponse(int fieldResponseId);

    Map<FieldDto, List<String>> showAllResponses(List<FieldDto> fieldDtoList, List<FieldResponseDto> fieldResponseDtoList);

    void createFieldResponseFromForm(List<ResponseCollectionShowForm> showFormList, ResponseDto responseDto);
}
