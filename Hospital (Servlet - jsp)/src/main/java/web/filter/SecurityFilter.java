package web.filter;

import bean.enums.UserRole;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by Egor on 15.11.2016.
 */
@WebFilter(initParams = {@WebInitParam(name = "uncheckedPaths", value = "/Login,/Registration,/Logout,/Main")},
        urlPatterns = "/*")
public class SecurityFilter implements Filter {

    private static final String PERMISSIONS_MAP = "permissions";
    private static final String USER_ROLE_ATTRIBUTE = "role";
    private final static Logger LOG = Logger.getLogger(SecurityFilter.class);

    private Map<UserRole, List<String>> permissions;
    private List<String> uncheckedPaths;


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        if (httpServletRequest.getRequestURI().matches(".*(css|jpg|png|gif|js)")) {
            chain.doFilter(request, response);
            return;
        }
        String requestedPath = httpServletRequest.getServletPath();
        if (uncheckedPaths.contains(requestedPath)) {
            chain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }
        LOG.info(MessageFormat.format("Requested path: {0}", requestedPath));

        UserRole role = UserRole.getValue((String) httpServletRequest.getSession().getAttribute(USER_ROLE_ATTRIBUTE));

        if (permissions.containsKey(role)) {
            LOG.info(MessageFormat.format("User role: {0}", role.toString()));
            List<String> rolePermissions = permissions.get(role);
            if (rolePermissions.contains(requestedPath)) {
                LOG.info(MessageFormat.format(
                        "User have permission, forward to request path {0}",
                        requestedPath));
                chain.doFilter(httpServletRequest, httpServletResponse);
                return;
            }
        }
        LOG.info("User haven't permissions, send 403 error code");
        httpServletResponse.sendError(403);
    }

    @SuppressWarnings("unchecked")
    public void init(FilterConfig filterConfig) throws ServletException {
        permissions = (Map<UserRole, List<String>>) filterConfig.getServletContext().getAttribute(PERMISSIONS_MAP);
        uncheckedPaths = Arrays.asList(filterConfig.getInitParameter("uncheckedPaths").split(","));
    }

    @Override
    public void destroy() {
    }
}