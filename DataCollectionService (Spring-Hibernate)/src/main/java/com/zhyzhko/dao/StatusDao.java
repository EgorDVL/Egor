package com.zhyzhko.dao;

import com.zhyzhko.dao.entity.Status;

import java.util.List;

/**
 * Created by Egor on 09.04.2017.
 */
public interface StatusDao {
    Status createStatus(Status status);

    Status getStatus(int statusId);

    List<Status> getAllStatus();

    boolean updateStatus(Status status);

    boolean deleteStatus(int statusId);
}
