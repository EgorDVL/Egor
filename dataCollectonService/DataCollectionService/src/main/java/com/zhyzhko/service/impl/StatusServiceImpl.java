package com.zhyzhko.service.impl;

import com.zhyzhko.dao.StatusDao;
import com.zhyzhko.dao.entity.Status;
import com.zhyzhko.dto.StatusDto;
import com.zhyzhko.service.StatusService;
import com.zhyzhko.util.converter.StatusConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Egor on 09.04.2017.
 */
@Service
public class StatusServiceImpl implements StatusService {
    @Autowired
    private StatusDao statusDao;

    @Autowired
    private StatusConverter converter;

    @Transactional
    @Override
    public StatusDto createStatus(StatusDto statusDto) {
        Status status = converter.convertToEntity(statusDto);
        return converter.convertToDto(statusDao.createStatus(status));
    }

    @Transactional
    @Override
    public StatusDto getStatus(int statusId) {
        return converter.convertToDto(statusDao.getStatus(statusId));
    }

    @Transactional
    @Override
    public List<StatusDto> getAllStatus() {
        return mapStatusDto(statusDao.getAllStatus());
    }

    @Transactional
    @Override
    public boolean updateStatus(StatusDto statusDto) {
        Status status = converter.convertToEntity(statusDto);
        return statusDao.updateStatus(status);
    }

    @Transactional
    @Override
    public boolean deleteStatus(int statusId) {
        return statusDao.deleteStatus(statusId);
    }

    private List<StatusDto> mapStatusDto(List<Status> statuses) {
        return statuses
                .stream()
                .map(converter::convertToDto)
                .collect(Collectors.toList());
    }
}
