package com.zhyzhko.dao;

import com.zhyzhko.dao.entity.Response;

import java.util.List;

/**
 * Created by Egor on 09.04.2017.
 */
public interface ResponseDao {
    Response createResponse(Response response);

    Response getResponse(int responseId);

    List<Response> getAllResponse();

    boolean updateResponse(Response response);

    boolean deleteResponse(int responseId);
}
