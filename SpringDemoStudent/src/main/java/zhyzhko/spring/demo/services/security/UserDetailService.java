package zhyzhko.spring.demo.services.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import zhyzhko.spring.demo.dao.entity.enums.RoleEnum;
import zhyzhko.spring.demo.dto.UserDto;
import zhyzhko.spring.demo.services.UserService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Egor on 27.03.2017.
 */

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    public UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDto user = userService.getUser(email);
        if (user != null) {
            List<SimpleGrantedAuthority> list = user.getRoles()
                    .stream()
                    .map(RoleEnum::getGrantedAuthority)
                    .collect(Collectors.toList());
            return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), list);
        } else {
            throw new UsernameNotFoundException("User Not Found!!!");
        }
    }
}