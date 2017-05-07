package web.Controller;

import Service.ProductService;
import bean.Product;
import db.Basket;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static util.page.page.CHIP_BASKET;

/**
 * Created by Egor on 26.10.2016.
 */

@WebServlet("/AddToBasket")
public class AddToBasket extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(AddToBasket.class);

    private ProductService productService = new ProductService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Work with basket - start");
        int productId = Integer.parseInt(req.getParameter("productId"));
        String nameDoing = req.getParameter("nameDoing");
        Product product = productService.getProductById(productId);
        HttpSession session = req.getSession();
        Basket basket = (Basket) session.getAttribute("basket");

        if (nameDoing.equalsIgnoreCase("add")) {
            addProduct(basket, product, session);
        } else {
            deleteProduct(product, basket);
        }
        LOG.info("Work with basket - end");
//        resp.sendRedirect(req.getHeader("Referer"));
        resp.sendRedirect(CHIP_BASKET);
    }

    private void addProduct(Basket basket, Product product, HttpSession session) throws IOException {
        LOG.info("Add product to basket - start");
        if (basket != null) {
            basket.addProduct(product);
        } else {
            Basket newBasket = new Basket();
            newBasket.addProduct(product);
            LOG.info("Add product to basket - end");
            session.setAttribute("basket", newBasket);
        }
    }

    private void deleteProduct(Product product, Basket basket) throws IOException {
        LOG.info("Delete product to basket - start");
        if (basket != null) {
            basket.removeProduct(product);
        }
        LOG.info("Delete product to basket - end");
    }
}