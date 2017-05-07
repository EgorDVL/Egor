package com.zhyzhko.service;

import com.zhyzhko.dto.RequiredDto;

import java.util.List;

/**
 * Created by Egor on 09.04.2017.
 */
public interface RequiredService {
    RequiredDto createRequired(RequiredDto requiredDto);

    RequiredDto getRequired(int requiredId);

    List<RequiredDto> getAllRequired();

    boolean updateRequired(RequiredDto requiredDto);

    boolean deleteRequired(int requiredId);
}
