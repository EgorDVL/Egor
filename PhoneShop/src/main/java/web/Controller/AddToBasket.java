package web.Controller;

import Service.ProductService;
import bean.Product;
import db.Basket;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Egor on 26.10.2016.
 */

@WebServlet("/addToBasket")
public class AddToBasket extends HttpServlet {

    private ProductService productService = new ProductService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
        resp.sendRedirect(req.getHeader("Referer"));
    }

    private void addProduct(Basket basket, Product product, HttpSession session) throws IOException {
        if (basket != null) {
            basket.addProduct(product);
        } else {
            Basket newBasket = new Basket();
            newBasket.addProduct(product);
            session.setAttribute("basket", newBasket);
        }
    }

    private void deleteProduct(Product product, Basket basket) throws IOException {
        if (basket != null) {
            basket.removeProduct(product);
        }
    }
}