package web.Controller;

import Service.*;
import bean.*;
import bean.enams.CategoryEnam;
import bean.enams.ManufacturerEnam;
import bean.enams.SubCategoryAccessory;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import static util.page.page.*;

/**
 * Created by Egor on 10.10.2016.
 */


public class ShowProductSelection extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(ShowProductSelection.class);

    private ProductService productService = new ProductService();
    private DescriptionService descriptionService = new DescriptionService();
    private CharacteristicService characteristicService = new CharacteristicService();
    private ManufacturerService manufacturerService = new ManufacturerService();
    private CategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Show category - start");
        String type = req.getParameter("type");
        HttpSession session = req.getSession();

        List<Product> allProduct;
        if (type.equalsIgnoreCase(CategoryEnam.ACCESSORIES.toString())) {
            SubCategoryAccessory subCategoryAccessory = SubCategoryAccessory.getValue(req.getParameter("subcategory"));
            int subCategoryAccessoryId = subCategoryAccessory.getValueInt();

            Category category = categoryService.getCategoryBySubcategory(subCategoryAccessoryId);
            session.setAttribute("sortCategoryId", category.getCategoryId());//category id for sort
            
            allProduct = productService.getAllProductByCategoryAccessory(subCategoryAccessoryId);
        } else {
            CategoryEnam category = CategoryEnam.getValue(type);
            int categoryId = category.getCategoryId();
            session.setAttribute("sortCategoryId", categoryId);//category id for sort
            ManufacturerEnam manufacturerEnam = ManufacturerEnam.getValue(req.getParameter("manufacturer"));
            int manufacturerId = manufacturerEnam.getValueInt();
            allProduct = productService.getAllProductByCategory(categoryId, manufacturerId);
        }
        req.setAttribute("allProductListCategory", allProduct);
        req.getRequestDispatcher(SHOW_ALL_PRODUCT_BY_CATEGORY).forward(req, resp);
        LOG.info("Show category - end");
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
