package web.Controller;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static util.page.page.ADD_NEW_PRODUCT;
import static util.page.page.ADD_NEW_PRODUCT_ACCESSORIES;

/**
 * Created by Egor on 11.11.2016.
 */
@WebServlet("/AddNewProductByCategory")
public class AddNewProductByCategory extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(AddNewProductByCategory.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int categoryId = Integer.parseInt(req.getParameter("category"));
        session.setAttribute("categoryId", categoryId);
        if (categoryId == 1 || categoryId == 2) {
            req.getRequestDispatcher(ADD_NEW_PRODUCT).forward(req, resp);
        } else {
            req.getRequestDispatcher(ADD_NEW_PRODUCT_ACCESSORIES).forward(req, resp);
        }
    }
}
