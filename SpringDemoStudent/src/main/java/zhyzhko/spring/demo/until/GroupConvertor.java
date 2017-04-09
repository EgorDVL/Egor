package zhyzhko.spring.demo.until;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import zhyzhko.spring.demo.dao.entity.Groupp;
import zhyzhko.spring.demo.dto.GroupDto;

/**
 * Created by Egor on 21.03.2017.
 */
@Component
public class GroupConvertor {
    @Autowired
    public ModelMapper modelMapper;

    public GroupDto convertToDto(Groupp groupp) {
        return modelMapper.map(groupp, GroupDto.class);
    }

    public Groupp convertToEntity(GroupDto groupDto) {
        return modelMapper.map(groupDto, Groupp.class);
    }
}
