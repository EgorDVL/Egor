package zhyzhko.spring.demo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zhyzhko.spring.demo.dao.GroupDao;
import zhyzhko.spring.demo.dao.entity.Groupp;
import zhyzhko.spring.demo.dto.GroupDto;
import zhyzhko.spring.demo.services.GroupService;
import zhyzhko.spring.demo.until.GroupConvertor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Egor on 24.02.2017.
 */
@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupDao groupDao;

    @Autowired
    private GroupConvertor groupConvertor;

    @Transactional
    @Override
    public GroupDto createGroup(GroupDto groupDto) {
        Groupp groupp = groupConvertor.convertToEntity(groupDto);
        return groupConvertor.convertToDto(groupDao.createGroup(groupp));
//        return groupDao.createGroup(groupDto);
    }

    @Transactional
    @Override
    public GroupDto getGroup(int groupId) {
        return groupConvertor.convertToDto(groupDao.getGroup(groupId));
//        return groupDao.getGroup(groupId);
    }

    @Transactional
    @Override
    public List<GroupDto> getAllGroups() {
        return mapGroupDto(groupDao.getAllGroups());
//        return groupDao.getAllGroups();
    }

    @Transactional
    @Override
    public boolean updateGroup(GroupDto groupDto) {
        Groupp groupp = groupConvertor.convertToEntity(groupDto);
        return groupDao.updateGroup(groupp);
//        return groupDao.updateGroup(groupDto);
    }

    @Transactional
    @Override
    public boolean deleteGroup(int groupId) {
        return groupDao.deleteGroup(groupId);
    }

    private List<GroupDto> mapGroupDto(List<Groupp> groupps) {
        return groupps
                .stream()
                .map(groupConvertor::convertToDto)
                .collect(Collectors.toList());
    }
}
