package web.Controller;

import Service.*;
import bean.*;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static util.page.page.*;

/**
 * Created by Egor on 19.10.2016.
 */
public class ShowAllProduct extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(ShowAllProduct.class);
    private ProductService productService = new ProductService();
    private DescriptionService descriptionService = new DescriptionService();
    private CharacteristicService characteristicService = new CharacteristicService();
    private ManufacturerService manufacturerService = new ManufacturerService();
    private CategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Show all product - start");
        List<Product> allProductList = productService.getAllProductCount();
        req.setAttribute("allProductList", allProductList);
        req.getRequestDispatcher(SHOW_ALL_PRODUCT).forward(req, resp);
        LOG.info("Show all product - end");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Show selected product - start");
        int productId = Integer.parseInt(req.getParameter("productId"));
        int descriptionId = Integer.parseInt(req.getParameter("descriptionId"));
        int characteristicId = Integer.parseInt(req.getParameter("characteristicId"));
        int manufacturerId = Integer.parseInt(req.getParameter("manufacturerId"));
        int categoryId = Integer.parseInt(req.getParameter("categoryId"));

        Product product = productService.getProductById(productId);
        Description description = descriptionService.getDescriptionById(descriptionId);
        Characteristic characteristic = characteristicService.getCharacteristicById(characteristicId);
        Manufacturer manufacturer = manufacturerService.getManufacturerById(manufacturerId);
        Category category = categoryService.getCategoryById(categoryId);
        SubcategoryAccessories subcategoryAccessories = categoryService.getSubCategoryById(category.getSubcatId());


        req.setAttribute("product", product);
        req.setAttribute("description", description);
        req.setAttribute("characteristic", characteristic);
        req.setAttribute("manufacturer", manufacturer);
        req.setAttribute("category", category);
        req.setAttribute("subcategoryAccessories", subcategoryAccessories);
        req.getRequestDispatcher(SHOW_PRODUCT).forward(req, resp);
        LOG.info("Show selected product - end");
        return;
    }
}
