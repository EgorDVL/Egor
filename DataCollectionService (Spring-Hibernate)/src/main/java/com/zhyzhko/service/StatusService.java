package com.zhyzhko.service;

import com.zhyzhko.dto.StatusDto;

import java.util.List;

/**
 * Created by Egor on 09.04.2017.
 */
public interface StatusService {
    StatusDto createStatus(StatusDto statusDto);

    StatusDto getStatus(int statusId);

    List<StatusDto> getAllStatus();

    boolean updateStatus(StatusDto statusDto);

    boolean deleteStatus(int statusId);
}
