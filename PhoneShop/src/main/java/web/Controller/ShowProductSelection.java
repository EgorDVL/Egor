package web.Controller;

import Service.ProductService;
import bean.Product;
import bean.enams.CategoryEnam;
import bean.enams.ManufacturerEnam;
import bean.enams.SubCategoryAccessory;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static util.page.page.SHOW_ALL_PRODUCT;

/**
 * Created by Egor on 10.10.2016.
 */

public class ShowProductSelection extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(ShowProductSelection.class);

    private ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Show category - start");
        String type = req.getParameter("type");

        List<Product> allProduct;
        if (type.equalsIgnoreCase(CategoryEnam.ACCESSORIES.toString())) {
            SubCategoryAccessory subCategoryAccessory = SubCategoryAccessory.getValue(req.getParameter("subcategory"));
            int subCategoryAccessoryId = subCategoryAccessory.getValueInt();
            allProduct = productService.getAllProductByCategoryAccessory(subCategoryAccessoryId);
        } else {
            CategoryEnam category = CategoryEnam.getValue(type);
            int categoryId = category.getCategoryId();
            ManufacturerEnam manufacturerEnam = ManufacturerEnam.getValue(req.getParameter("manufacturer"));
            int manufacturerId = manufacturerEnam.getValueInt();
            allProduct = productService.getAllProductByCategory(categoryId, manufacturerId);
        }
        req.setAttribute("allProductList", allProduct);
        req.getRequestDispatcher(SHOW_ALL_PRODUCT).forward(req, resp);
        LOG.info("Show category - end");
    }

}
