package zhyzhko.spring.demo.services;

import zhyzhko.spring.demo.dto.GroupDto;

import java.util.List;

/**
 * Created by Egor on 24.02.2017.
 */
public interface GroupService {
    GroupDto createGroup(GroupDto groupDto);

    GroupDto getGroup(int groupId);

    List<GroupDto> getAllGroups();

    boolean updateGroup(GroupDto groupDto);

    boolean deleteGroup(int groupId);
//    int createGroup(GroupDto group);
//
//    GroupDto getGroup(int groupId);
//
//    List<GroupDto> getAllGroups();
//
//    boolean updateGroup(GroupDto group);
//
//    boolean deleteGroup(int groupId);
}
