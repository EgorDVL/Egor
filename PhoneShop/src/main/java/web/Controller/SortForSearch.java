package web.Controller;

import static util.page.page.*;

import Service.ProductService;
import bean.Product;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Egor on 03.11.2016.
 */
@WebServlet("/SortForSearch")
public class SortForSearch extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(SortForSearch.class);
    private ProductService productService = new ProductService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Sort for search list - start");
        HttpSession session = req.getSession();
        StringBuilder sb = new StringBuilder();
        String sqlQuerySearch = (String) session.getAttribute("sqlQuerySearch");
        String sortParam = req.getParameter("sort");
        sb.append(sqlQuerySearch).deleteCharAt(sb.length() - 1).append("order by ").append(sortParam).append(";");

        System.out.println(sb.toString());
        List<Product> searchListProducts = productService.getAllProductForSearch(sb.toString());
        req.setAttribute("searchListProducts", searchListProducts);
        req.getRequestDispatcher(SEARCH_LIST_PRODUCTS).forward(req, resp);
        LOG.info("Sort for search list - end");
    }
}
