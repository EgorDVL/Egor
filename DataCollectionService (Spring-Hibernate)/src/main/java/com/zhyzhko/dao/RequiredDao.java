package com.zhyzhko.dao;

import com.zhyzhko.dao.entity.Required;

import java.util.List;

/**
 * Created by Egor on 09.04.2017.
 */
public interface RequiredDao {
    Required createRequired(Required required);

    Required getRequired(int requiredId);

    List<Required> getAllRequired();

    boolean updateRequired(Required required);

    boolean deleteRequired(int requiredId);
}
