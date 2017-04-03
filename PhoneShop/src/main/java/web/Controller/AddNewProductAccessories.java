package web.Controller;

import Service.ProductService;
import org.apache.log4j.Logger;
import util.AddProductAccessoriesValidator;
import web.form.AddProductAccessoriesForm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static util.ErrorMessage.ADD_PRODUCT_ERROR;
import static util.ErrorMessage.EMPTY_FIELD_ERROR;
import static util.page.page.ADD_NEW_PRODUCT_ACCESSORIES;
import static util.page.page.MAIN_PAGE;

/**
 * Created by Egor on 11.11.2016.
 */
@WebServlet("/AddNewProductAccessories")
public class AddNewProductAccessories extends HttpServlet {
    private static final String ERROR_MESSAGE = "errorMessage";
    private static final Logger LOG = Logger.getLogger(AddNewProductAccessories.class);
    private ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Add new product - clean Error message - start");
        HttpSession session = req.getSession();
        String errorMessage = (String) session.getAttribute(ERROR_MESSAGE);
        if (errorMessage != null) {
            session.removeAttribute(ERROR_MESSAGE);
            req.setAttribute(ERROR_MESSAGE, errorMessage);
        }
        LOG.info("Add new product - clean Error message - end");
        req.getRequestDispatcher(ADD_NEW_PRODUCT_ACCESSORIES).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("add new product accessories - start");
        HttpSession session = req.getSession();
        AddProductAccessoriesForm addProductAccessoriesForm = null;
        try {
            addProductAccessoriesForm = extractAddProductForm(req);
        } catch (NumberFormatException e) {
            errorMessageToAddProductForm(resp, session, EMPTY_FIELD_ERROR);
            LOG.error("Empty field error or incorrect value. Redirect to create apartment page");
            return;
        }
        if (AddProductAccessoriesValidator.nonEmptyAddProduct(addProductAccessoriesForm)) {
            errorMessageToAddProductForm(resp, session, EMPTY_FIELD_ERROR);
            LOG.error("Empty field error");
            return;
        }
        boolean result = productService.createNewProductAccessories(addProductAccessoriesForm.getSubCategoryAccessory(),
                addProductAccessoriesForm.getManufacturerId(), addProductAccessoriesForm.getName(), addProductAccessoriesForm.getPrice(),
                addProductAccessoriesForm.getCount(), addProductAccessoriesForm.getDescription());
        if (result = false) {
            errorMessageToAddProductForm(resp, session, ADD_PRODUCT_ERROR);
            LOG.error("Empty field error or incorrect value. Redirect to create apartment page");
            return;
        }
        LOG.info("add new product accessories - end");
        resp.sendRedirect(MAIN_PAGE);
    }

    private AddProductAccessoriesForm extractAddProductForm(HttpServletRequest req) throws NumberFormatException {
        int subCategoryAccessory = Integer.parseInt(req.getParameter("subcategory"));
        int manufacturerId = Integer.parseInt(req.getParameter("manufacturer"));
        String name = req.getParameter("name");
        int price = Integer.parseInt(req.getParameter("price"));
        int count = Integer.parseInt(req.getParameter("count"));
        String description = req.getParameter("description");
        return new AddProductAccessoriesForm(subCategoryAccessory, manufacturerId, name, price, count, description);
    }

    private void errorMessageToAddProductForm(HttpServletResponse resp, HttpSession session, String errorMessage) throws IOException {
        session.setAttribute(ERROR_MESSAGE, errorMessage);
        resp.sendRedirect("AddNewProductAccessories");
    }
}