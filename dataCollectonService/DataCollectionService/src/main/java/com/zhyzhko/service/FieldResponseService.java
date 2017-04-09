package com.zhyzhko.service;

import com.zhyzhko.dto.FieldResponseDto;

import java.util.List;

/**
 * Created by Egor on 09.04.2017.
 */
public interface FieldResponseService {
    FieldResponseDto createFieldResponse(FieldResponseDto fieldResponseDto);

    FieldResponseDto getFieldResponse(int fieldResponseId);

    List<FieldResponseDto> getAllFieldResponse();

    boolean updateFieldResponse(FieldResponseDto fieldResponseDto);

    boolean deleteFieldResponse(int fieldResponseId);
}
