package zhyzhko.spring.demo.until;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import zhyzhko.spring.demo.dao.entity.User;
import zhyzhko.spring.demo.dto.UserDto;

/**
 * Created by Egor on 21.03.2017.
 */
@Component
public class UserConvertor {

    @Autowired
    public ModelMapper modelMapper;

    public UserDto convertToDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    public User convertToEntity(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }
}
