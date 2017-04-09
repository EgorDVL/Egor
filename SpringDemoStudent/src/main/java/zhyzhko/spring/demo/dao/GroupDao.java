package zhyzhko.spring.demo.dao;


import zhyzhko.spring.demo.dao.entity.Groupp;

import java.util.List;

/**
 * Created by Egor on 24.02.2017.
 */
public interface GroupDao {
    Groupp createGroup(Groupp groupp);

    Groupp getGroup(int groupId);

    List<Groupp> getAllGroups();

    boolean updateGroup(Groupp groupp);

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
