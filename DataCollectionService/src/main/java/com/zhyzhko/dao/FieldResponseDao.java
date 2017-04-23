package com.zhyzhko.dao;

import com.zhyzhko.dao.entity.FieldResponse;

import java.util.List;

/**
 * Created by Egor on 09.04.2017.
 */
public interface FieldResponseDao {
    FieldResponse createFieldResponse(FieldResponse fieldResponse);

    FieldResponse getFieldResponse(int fieldResponseId);

    List<FieldResponse> getAllFieldResponse();

    boolean updateFieldResponse(FieldResponse fieldResponse);

    boolean deleteFieldResponse(int fieldResponseId);
    
}
