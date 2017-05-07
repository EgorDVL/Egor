package web.requestConverter.impl;

import bean.User;
import bean.enums.UserRole;
import web.requestConverter.HttpRequestConverter;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Egor on 22.01.2017.
 */
public class UserRequestConverter implements HttpRequestConverter<User> {

    @Override
    public User fromRequest(HttpServletRequest req) {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        UserRole userRole = UserRole.getValue(req.getParameter("userRole"));
        return new User(email, password, userRole);
    }
}
