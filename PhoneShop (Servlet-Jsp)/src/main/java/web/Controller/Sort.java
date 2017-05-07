package web.Controller;

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

import static util.page.page.SHOW_ALL_PRODUCT;
import static util.page.page.SHOW_ALL_PRODUCT_BY_CATEGORY;

/**
 * Created by Egor on 01.11.2016.
 */
@WebServlet("/Sort")
public class Sort extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(Sort.class);
    private ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Sort for category - start");
        HttpSession session = req.getSession();

        String sortParam = req.getParameter("sort");
        int categoryIdInt = (int) session.getAttribute("sortCategoryId");
        String categoryId = String.valueOf(categoryIdInt);

        List<Product> allProductListCategory = productService.getAllProductSortedByCategoryAndParam(categoryId, sortParam);
        req.setAttribute("allProductListCategory", allProductListCategory);
        req.getRequestDispatcher(SHOW_ALL_PRODUCT_BY_CATEGORY).forward(req, resp);
        LOG.info("Sort for category - end");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Sort for all product - start");
        String sortParam = req.getParameter("sort");
        List<Product> allProductList = productService.getAllProductSortedByParam(sortParam);
        req.setAttribute("allProductList", allProductList);
        req.getRequestDispatcher(SHOW_ALL_PRODUCT).forward(req, resp);
        LOG.info("Sort for all product - end");
    }
}
