package Service;

import bean.Category;
import bean.Characteristic;
import bean.Description;
import bean.Product;
import bean.enams.CategoryEnam;
import bean.enams.ManufacturerEnam;
import db.DBManager;
import db.dao.*;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Egor on 10.10.2016.
 */
public class ProductService {
    private static final Logger LOG = Logger.getLogger(ProductService.class);

    private ProductDAO productDAO = DaoFactory.getProductDao();
    private CharacteristicDAO characteristicDAO = DaoFactory.getCharacteristicDao();
    private DescriptionDAO descriptionDAO = DaoFactory.getDescriptionDao();
    private CategoryDAO categoryDAO = DaoFactory.getCategoryDao();


    public boolean createNewProduct(int categoryId, int manufacturerId, String name, int price, int count, String description,
                                    String color, int memory, double screenSize, String processor, double ram, double frontCamera, double mainCamera) {
        Connection con = DBManager.getConnection();
        Characteristic characteristic = new Characteristic(color, memory, screenSize, processor, ram, frontCamera, mainCamera);
        Description desc = new Description(description);
        try {
            int characteristicId = characteristicDAO.createCharacteristic(characteristic, con);
            int descriprionId = descriptionDAO.createDescription(desc, con);
            Product product = new Product(name, price, count, descriprionId, characteristicId, manufacturerId, categoryId);
            productDAO.createProduct(product, con);
            DBManager.commit(con);
        } catch (SQLException e) {
            LOG.error("can't create product");
            DBManager.rollback(con);
        } finally {
            DBManager.closeCon(con);
        }
        return true;
    }

    public boolean createNewProductAccessories(int subCategoryAccessory, int manufacturerId, String name, int price, int count, String description) {
        Connection con = DBManager.getConnection();
        Category category = new Category(CategoryEnam.ACCESSORIES, subCategoryAccessory);
        Description desc = new Description(description);
        Characteristic characteristic = new Characteristic(null, 0, 0, null, 0, 0, 0);
        try {
            int categoryId = categoryDAO.createCategory(category, con);
            int descriprionId = descriptionDAO.createDescription(desc, con);
            int characheristicId = characteristicDAO.createCharacteristic(characteristic, con);
            Product product = new Product(name, price, count, descriprionId, characheristicId, manufacturerId, categoryId);
            productDAO.createProduct(product, con);
            DBManager.commit(con);
        } catch (SQLException e) {
            LOG.error("can't create product");
            DBManager.rollback(con);
        } finally {
            DBManager.closeCon(con);
        }
        return true;
    }

    public List<Product> getAllProductForSearch(String sqlQuery) {
        Connection con = DBManager.getConnection();
        List<Product> productList = new ArrayList<>();
        try {
            productList = productDAO.getAllProductSearch(sqlQuery, con);
            DBManager.commit(con);
        } catch (SQLException e) {
            LOG.error("Can't get product list");
            DBManager.rollback(con);
        } finally {
            DBManager.closeCon(con);
        }
        return productList;
    }

    public List<Product> getAllProductSortedByParam(String sortParam) {
        Connection con = DBManager.getConnection();
        List<Product> productList = new ArrayList<>();
        try {
            productList = productDAO.getSortedProductByParam(sortParam, con);
            DBManager.commit(con);
        } catch (SQLException e) {
            LOG.error("Can't sorted product");
            DBManager.rollback(con);
        } finally {
            DBManager.closeCon(con);
        }
        return productList;
    }

    public List<Product> getAllProductSortedByCategoryAndParam(String categoryId, String sprtParam) {
        Connection con = DBManager.getConnection();
        List<Product> productList = new ArrayList<>();
        try {
            productList = productDAO.getSortedProductByCategoryAndParam(categoryId, sprtParam, con);
            DBManager.commit(con);
        } catch (SQLException e) {
            LOG.error("Can't sorted product");
            DBManager.rollback(con);
        } finally {
            DBManager.closeCon(con);
        }
        return productList;
    }

    public List<Product> getAllProductByCategoryAccessory(int subCategoryAccessoryId) {
        Connection con = DBManager.getConnection();
        List<Product> productList = new ArrayList<>();
        try {
            productList = productDAO.getProductByCategoryByAccessory(subCategoryAccessoryId, con);
            DBManager.commit(con);
        } catch (SQLException e) {
            LOG.error("Can't get all product by category");
            DBManager.rollback(con);
        } finally {
            DBManager.closeCon(con);
        }
        return productList;
    }

    public Product getProductById(int productId) {
        Connection con = DBManager.getConnection();
        Product product = null;
        try {
            product = productDAO.getProductById(productId, con);
            DBManager.commit(con);
        } catch (SQLException e) {
            LOG.error("Can't get product by id");
            DBManager.rollback(con);
        } finally {
            DBManager.closeCon(con);
        }
        return product;
    }

    public List<Product> getAllProductCount() {
        Connection con = DBManager.getConnection();
        List<Product> allProductList = new ArrayList<>();
        try {
            allProductList = productDAO.getAllProductCount(con);
            DBManager.commit(con);
        } catch (SQLException e) {
            LOG.error("Cam't get all product");
            DBManager.rollback(con);
        } finally {
            DBManager.closeCon(con);
        }
        return allProductList;
    }

    public List<Product> getAllProduct() {
        Connection con = DBManager.getConnection();
        List<Product> allProductList = new ArrayList<>();
        try {
            allProductList = productDAO.getAllProduct(con);
            DBManager.commit(con);
        } catch (SQLException e) {
            LOG.error("Cam't get all product");
            DBManager.rollback(con);
        } finally {
            DBManager.closeCon(con);
        }
        return allProductList;
    }

    public List<Product> getAllProductByCategory(int categoryId, int manufacturerId) {
        Connection con = DBManager.getConnection();
        List<Product> productList = new ArrayList<>();
        try {
            productList = productDAO.getProductByCategory(categoryId, manufacturerId, con);
            DBManager.commit(con);
        } catch (SQLException e) {
            LOG.error("Can't get all product by category");
            DBManager.rollback(con);
        } finally {
            DBManager.closeCon(con);
        }
        return productList;
    }
}
