package com.zhyzhko.dao;

import com.zhyzhko.dao.entity.Ttype;

import java.util.List;

/**
 * Created by Egor on 09.04.2017.
 */
public interface TypeDao {
    Ttype createType(Ttype type);

    Ttype getType(int typeId);

    List<Ttype> getAllType();

    boolean updateType(Ttype type);

    boolean deleteType(int typeId);
}