package web.Controller;

import Service.ProductService;
import bean.enams.CategoryEnam;
import bean.enams.ManufacturerEnam;
import org.apache.log4j.Logger;
import util.AddProductValidator;
import web.form.AddProductForm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static util.ErrorMessage.ADD_PRODUCT_ERROR;
import static util.ErrorMessage.EMPTY_FIELD_ERROR;
import static util.ErrorMessage.ILLEGAL_CHARACTER_ERROR;
import static util.page.page.*;

/**
 * Created by Egor on 10.11.2016.
 */
@WebServlet("/AddNewProduct")
public class AddNewProduct extends HttpServlet {
    private static final String ERROR_MESSAGE = "errorMessage";
    private static final Logger LOG = Logger.getLogger(AddNewProduct.class);
    private ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        LOG.info("Add new product - clean Error message - start");
        String errorMessage = (String) session.getAttribute(ERROR_MESSAGE);
        if (errorMessage != null) {
            session.removeAttribute(ERROR_MESSAGE);
            req.setAttribute(ERROR_MESSAGE, errorMessage);
        }
        LOG.info("Add new product - clean Error message - end");
        req.getRequestDispatcher(ADD_NEW_PRODUCT).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Add new product - start");
        HttpSession session = req.getSession();
        AddProductForm addProductForm = null;
        try {
            addProductForm = extractAddProductForm(req);
        } catch (NumberFormatException e) {
            errorMessageToAddProductForm(resp, session, EMPTY_FIELD_ERROR);
            LOG.error("Empty field error or incorrect value. Redirect to create apartment page");
            return;
        }
        if (AddProductValidator.nonEmptyAddProduct(addProductForm)) {
            errorMessageToAddProductForm(resp, session, EMPTY_FIELD_ERROR);
            LOG.error("Empty field error");
            return;
        }
        int categoryId = (Integer) session.getAttribute("categoryId");

        productService.createNewProduct(categoryId, addProductForm.getManufacturer(), addProductForm.getName(), addProductForm.getPrice(),
                addProductForm.getCount(), addProductForm.getDescription(), addProductForm.getColor(), addProductForm.getMemory(), addProductForm.getScreenSize(),
                addProductForm.getProcessor(), addProductForm.getRam(), addProductForm.getFrontCamera(), addProductForm.getMainCamera());

        LOG.info("Add new product - end");
        resp.sendRedirect(MAIN_PAGE);
    }

    private AddProductForm extractAddProductForm(HttpServletRequest req) throws NumberFormatException {
        int manufacturerId = Integer.parseInt(req.getParameter("manufacturer"));
        String name = req.getParameter("name");
        int price = Integer.parseInt(req.getParameter("price"));
        int count = Integer.parseInt(req.getParameter("count"));
        String description = req.getParameter("description");
        String color = req.getParameter("color");
        int memory = Integer.parseInt(req.getParameter("memory"));
        double screenSize = Double.parseDouble(req.getParameter("screenSize"));
        String processor = req.getParameter("processor");
        int ram = Integer.parseInt(req.getParameter("ram"));
        double frontCamera = Double.parseDouble(req.getParameter("frontCamera"));
        double mainCamera = Double.parseDouble(req.getParameter("mainCamera"));
        return new AddProductForm(manufacturerId, name, price, count, description, color, memory, screenSize, processor, ram, frontCamera, mainCamera);
    }

    private void errorMessageToAddProductForm(HttpServletResponse resp, HttpSession session, String errorMessage) throws IOException {
        session.setAttribute(ERROR_MESSAGE, errorMessage);
        resp.sendRedirect("AddNewProduct");
    }
}