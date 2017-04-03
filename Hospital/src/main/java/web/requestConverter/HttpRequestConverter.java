package web.requestConverter;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Egor on 16.01.2017.
 */
public interface HttpRequestConverter<T> {

    T fromRequest(HttpServletRequest req);
}
