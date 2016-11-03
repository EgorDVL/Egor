package web.Controller;

import Service.CategoryService;
import Service.CharacteristicService;
import Service.ManufacturerService;
import Service.ProductService;
import bean.Category;
import bean.Characteristic;
import bean.Manufacturer;
import bean.Product;
import db.QueryConstructor;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import static util.page.page.*;

/**
 * Created by Egor on 02.11.2016.
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(Search.class);
    private ProductService productService = new ProductService();
    private CategoryService categoryService = new CategoryService();
    private ManufacturerService manufacturerService = new ManufacturerService();
    private CharacteristicService characteristicService = new CharacteristicService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Search - start");
        List<Category> category = categoryService.getAllCategory();
        req.setAttribute("category", category);

        List<Manufacturer> manufacturers = manufacturerService.getAllManufacturer();
        req.setAttribute("manufacturers", manufacturers);

        List<Characteristic> characteristics = characteristicService.getAllCharacteristic();
        req.setAttribute("characteristics", characteristics);

        req.getRequestDispatcher(SEARCH).forward(req, resp);
        LOG.info("Search - end");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Search - start");
        String[] categoryId = req.getParameterValues("categoryId");
        String[] manufacturerId = req.getParameterValues("manufacturerId");
        String priceFrom = req.getParameter("priceFrom");
        String priceTo = req.getParameter("priceTo");
        String[] mainCamera = req.getParameterValues("mainCamera");
        String[] screenSize = req.getParameterValues("screenSize");
        String[] memory = req.getParameterValues("memory");
        String[] color = req.getParameterValues("color");
        String[] ram = req.getParameterValues("ram");

        QueryConstructor queryConstructor = new QueryConstructor();

        String sqlQuerySearch = queryConstructor.constructor(categoryId, manufacturerId, priceFrom, priceTo, mainCamera, screenSize, memory, color, ram);
        HttpSession session = req.getSession();
        session.setAttribute("sqlQuerySearch", sqlQuerySearch);
        List<Product> searchListProducts = productService.getAllProductForSearch(sqlQuerySearch);

        req.setAttribute("searchListProducts", searchListProducts);
        req.getRequestDispatcher(SEARCH_LIST_PRODUCTS).forward(req, resp);
        queryConstructor.cleanConstructor();
        LOG.info("Search - end");
    }
}
