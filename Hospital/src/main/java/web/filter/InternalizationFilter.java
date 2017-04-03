package web.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

/**
 * Created by Egor on 15.11.2016.
 */
@WebFilter(urlPatterns = "/*")
public class InternalizationFilter implements Filter {
    private String defaultLocale;
    private List<String> supportLocale;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        HttpSession session = httpServletRequest.getSession();

        if (httpServletRequest.getRequestURI().matches(".*(css|jpg|png|gif|js)")) {
            chain.doFilter(request, response);
            return;
        }

        String language = request.getParameter("language");
        if (language != null) {
            chain.doFilter(wrapRequest(httpServletRequest, language),
                    httpServletResponse);
            session.setAttribute("language", language);
            return;
        } else {
            chain.doFilter(wrapRequest(httpServletRequest, defaultLocale),
                    httpServletResponse);
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        this.defaultLocale = config.getServletContext().getInitParameter(
                "defaultLocale");
        this.supportLocale = Arrays.asList(config.getServletContext()
                .getInitParameter("supportLocale").split(","));
    }

    @Override
    public void destroy() {
    }

    private HttpServletRequestWrapper wrapRequest(HttpServletRequest request,
                                                  String lang) {
        return new HttpServletRequestWrapper(request) {
            @Override
            public Locale getLocale() {
                return new Locale(lang);
            }

            @Override
            public Enumeration<Locale> getLocales() {
                return Collections.enumeration(Collections
                        .singletonList(new Locale(lang)));
            }
        };
    }
}
