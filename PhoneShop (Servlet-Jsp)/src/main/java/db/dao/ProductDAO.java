package db.dao;

import bean.Product;
import bean.enams.ManufacturerEnam;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Egor on 23.09.2016.
 */
public interface ProductDAO {

    int createProduct(Product product, Connection con) throws SQLException;

    Product getProductById(int productId, Connection con) throws SQLException;

    List<Product> getAllProduct(Connection con) throws SQLException;

    List<Product> getAllProductCount(Connection con) throws SQLException;

    boolean updateProduct(Product product, Connection con) throws SQLException;

    boolean updateProductCount(int productId, int count, Connection con) throws SQLException;

    List<Product> getProductByCategory(int categoryId, int manufacturerId, Connection con) throws SQLException;

    List<Product> getProductByCategoryByAccessory(int subcatId, Connection con) throws SQLException;

    List<Product> getSortedProductByCategoryAndParam(String categoryId, String sortParam, Connection con) throws SQLException;

    List<Product> getSortedProductByParam(String sortParam, Connection con) throws SQLException;

    List<Product> getAllProductSearch(String sqlQuery, Connection con) throws SQLException;

}
