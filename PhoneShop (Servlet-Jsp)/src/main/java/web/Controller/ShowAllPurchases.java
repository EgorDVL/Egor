package web.Controller;

import Service.CheckoutService;
import bean.Sales;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static util.page.page.SHOW_ALL_SALES;

/**
 * Created by Egor on 31.10.2016.
 */
@WebServlet("/ShowAllPurchases")
public class ShowAllPurchases extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(ShowAllPurchases.class);
    private CheckoutService checkoutService = new CheckoutService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Get all purchases for admin - start");
        List<Sales> salesList = checkoutService.getAllSales();
        req.setAttribute("salesList", salesList);
        req.getRequestDispatcher(SHOW_ALL_SALES).forward(req, resp);
        LOG.info("Get all purchases for admin - end");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
