package com.zhyzhko.dao;

import com.zhyzhko.dao.entity.Field;

import java.util.List;

/**
 * Created by Egor on 09.04.2017.
 */
public interface FieldDao {
    Field createField(Field field);

    Field getField(int fieldId);

    List<Field> getAllField();

    boolean updateField(Field field);

    boolean updateRequired(int requiredId, int id);

    boolean updateStatus(int statusId, int id);

    boolean deleteField(int fieldId);
}
