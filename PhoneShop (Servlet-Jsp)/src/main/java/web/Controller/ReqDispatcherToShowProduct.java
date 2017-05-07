package web.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static util.page.page.PRODUCT_SELECTION_PAGE;

/**
 * Created by Egor on 11.10.2016.
 */
public class ReqDispatcherToShowProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(PRODUCT_SELECTION_PAGE).forward(req, resp);
    }
}
