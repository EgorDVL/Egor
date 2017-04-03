package web.Controller;

import Service.CheckoutService;
import bean.enams.DeliveryMethod;
import bean.enams.PaymentMethod;
import db.Basket;
import org.apache.log4j.Logger;
import util.CheckoutValidator;
import web.form.CheckoutForm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static util.ErrorMessage.EMPTY_FIELD_ERROR;
import static util.ErrorMessage.ILLEGAL_CHARACTER_ERROR;
import static util.page.page.CHECKOUT_PAGE;
import static util.page.page.MAIN_PAGE;

/**
 * Created by Egor on 28.10.2016.
 */
@WebServlet("/Checkout")
public class Checkout extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(Checkout.class);
    private static final String ERROR_MESSAGE = "errorMessage";
    private CheckoutService checkoutService = new CheckoutService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Checkout - clean Error message - start");
        HttpSession session = req.getSession();
        String errorMessage = (String) session.getAttribute(ERROR_MESSAGE);
        if (errorMessage != null) {
            session.removeAttribute(ERROR_MESSAGE);
            req.setAttribute(ERROR_MESSAGE, errorMessage);
        }
        LOG.info("Checkout - clean Error message - start");
        req.getRequestDispatcher(CHECKOUT_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Checkout - start");
        HttpSession session = req.getSession();
        CheckoutForm checkoutForm = null;
        try {
            checkoutForm = extractCheckoutForm(req);
        } catch (NumberFormatException e) {
            errorMessageToCheckoutForm(resp, session, EMPTY_FIELD_ERROR);
            LOG.error("Empty field error or incorrect value. Redirect to create apartment page");
            return;
        }

        Basket basket = (Basket) session.getAttribute("basket");

        if (CheckoutValidator.nonEmptyCheckout(checkoutForm)) {
            errorMessageToCheckoutForm(resp, session, EMPTY_FIELD_ERROR);
            LOG.error("Empty field error");
            return;
        }
        if (!CheckoutValidator.validateForm(checkoutForm)) {
            errorMessageToCheckoutForm(resp, session, ILLEGAL_CHARACTER_ERROR);
            LOG.error("Illegal character error");
            return;
        }
        checkoutService.basketCleaner(basket, checkoutForm.getEmail(), checkoutForm.getName(), checkoutForm.getSurname(), checkoutForm.getPhone(),
                checkoutForm.getCity(), checkoutForm.getAddres(), checkoutForm.getHouse(), checkoutForm.getDeliveryMethod(), checkoutForm.getPaymentMethod());
        basket.cleanBasket();
        basket.cleanTotalPrice();
        req.getRequestDispatcher(MAIN_PAGE).forward(req, resp);
        LOG.info("Checkout - end");
    }

    private CheckoutForm extractCheckoutForm(HttpServletRequest req) throws NumberFormatException {
        String email = req.getParameter("email");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String phone = req.getParameter("phone");
        String city = req.getParameter("city");
        String address = req.getParameter("address");
        int house = Integer.parseInt(req.getParameter("house"));
        DeliveryMethod deliveryMethod = DeliveryMethod.getValue(req.getParameter("delivery"));
        PaymentMethod paymentMethod = PaymentMethod.getValue(req.getParameter("payment"));
        return new CheckoutForm(email, name, surname, phone, city, address, house, deliveryMethod, paymentMethod);
    }

    private void errorMessageToCheckoutForm(HttpServletResponse resp, HttpSession session, String errorMessage) throws IOException {
        session.setAttribute(ERROR_MESSAGE, errorMessage);
        resp.sendRedirect("Checkout");
    }
}
