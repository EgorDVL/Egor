package com.zhyzhko.dao;

import com.zhyzhko.dao.entity.TypeValue;

import java.util.List;

/**
 * Created by Egor on 09.04.2017.
 */
public interface TypeValueDao {
    TypeValue createTypeValue(TypeValue typeValue);

    TypeValue getTypeValue(int typeValueId);

    List<TypeValue> getAllTypeValue();

    boolean updateTypeValue(TypeValue typeValue);

    boolean deleteTypeValue(int typeValueId);
}
