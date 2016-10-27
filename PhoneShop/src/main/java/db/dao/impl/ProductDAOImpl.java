package db.dao.impl;

import bean.Order;
import bean.Product;
import bean.enams.DeliveryMethod;
import bean.enams.PaymentMethod;
import db.DBManager;
import db.dao.ProductDAO;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Egor on 26.09.2016.
 */
public class ProductDAOImpl implements ProductDAO {
    private static final Logger LOG = Logger.getLogger(ProductDAOImpl.class);

    private static final String CREATE_PRODUCT = "insert into product values(default, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_PRODUCT = "update product set name =?, price =?, count =?, descriptionId =?," +
            " characteristicId =?, manufacturerId =?, categoryId =? where productId = ?";
    private static final String GET_PRODUCT_BY_ID = "select productId, name, price, count, descriptionId, characteristicId, manufacturerId, " +
            "categoryId from product where productId = ?";
    private static final String GET_ALL_PRODUCT = "select productId, name, price, count, descriptionId, characteristicId, " +
            "manufacturerId, categoryId from product";
    private static final String GET_ALL_PRODUCT_COUNT = "select productId, name, price, count, descriptionId, characteristicId, " +
            "manufacturerId, categoryId from product where count > 0";

    private static final String GET_PRODUCT_BY_CATEGORY = "select productId, name, price, count, descriptionId, characteristicId, manufacturerId, " +
            "categoryId from product where categoryId = ? and manufacturerId = ?";

    private static final String GET_PRODUCT_BY_CATEGORY_ACCESSORY = "select productId, name, price, count, descriptionId, characteristicId," +
            " manufacturerId, categoryId from product where categoryId = (select categoryId from category where subcatId = ?)";

    @Override
    public int createProduct(Product product, Connection con) throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;
        int result = -1;
        try {
            st = con.prepareStatement(CREATE_PRODUCT, PreparedStatement.RETURN_GENERATED_KEYS);
            st.setString(1, product.getName());
            st.setInt(2, product.getPrice());
            st.setInt(3, product.getCount());
            st.setInt(4, product.getDescriptionId());
            st.setInt(5, product.getCharacteristicId());
            st.setInt(6, product.getManufacturerId());
            st.setInt(7, product.getCategoryId());
            st.executeUpdate();
            rs = st.getGeneratedKeys();
            while (rs.next()) {
                result = rs.getInt(1);
            }
        } catch (SQLException e) {
            LOG.error("Can't create new product");
            throw e;
        } finally {
            DBManager.closeRs(rs);
            DBManager.closeStat(st);
        }
        return result;
    }

    @Override
    public Product getProductById(int productId, Connection con) throws SQLException {
        Product product = null;
        PreparedStatement st = null;
        ResultSet set = null;
        try {
            st = con.prepareStatement(GET_PRODUCT_BY_ID);
            st.setInt(1, productId);
            set = st.executeQuery();
            while (set.next()) {
                product = new Product();
                product.setProductId(set.getInt(1));
                product.setName(set.getString(2));
                product.setPrice(set.getInt(3));
                product.setCount(set.getInt(4));
                product.setDescriptionId(set.getInt(5));
                product.setCharacteristicId(set.getInt(6));
                product.setManufacturerId(set.getInt(7));
                product.setCategoryId(set.getInt(8));
            }
        } catch (SQLException e) {
            LOG.error("Can't get product by Id");
            throw e;
        } finally {
            DBManager.closeRs(set);
            DBManager.closeStat(st);
        }
        return product;
    }

    @Override
    public List<Product> getAllProduct(Connection con) throws SQLException {
        List<Product> productList = new ArrayList<>();
        PreparedStatement st = null;
        ResultSet set = null;
        try {
            st = con.prepareStatement(GET_ALL_PRODUCT);
            set = st.executeQuery();
            while (set.next()) {
                Product product = new Product();
                product.setProductId(set.getInt(1));
                product.setName(set.getString(2));
                product.setPrice(set.getInt(3));
                product.setCount(set.getInt(4));
                product.setDescriptionId(set.getInt(5));
                product.setCharacteristicId(set.getInt(6));
                product.setManufacturerId(set.getInt(7));
                product.setCategoryId(set.getInt(8));
                productList.add(product);
            }
        } catch (SQLException e) {
            LOG.error("Can't get product List by Id");
            throw e;
        } finally {
            DBManager.closeRs(set);
            DBManager.closeStat(st);
        }
        return productList;
    }

    @Override
    public List<Product> getAllProductCount(Connection con) throws SQLException {
        List<Product> productList = new ArrayList<>();
        PreparedStatement st = null;
        ResultSet set = null;
        try {
            st = con.prepareStatement(GET_ALL_PRODUCT_COUNT);
            set = st.executeQuery();
            while (set.next()) {
                Product product = new Product();
                product.setProductId(set.getInt(1));
                product.setName(set.getString(2));
                product.setPrice(set.getInt(3));
                product.setCount(set.getInt(4));
                product.setDescriptionId(set.getInt(5));
                product.setCharacteristicId(set.getInt(6));
                product.setManufacturerId(set.getInt(7));
                product.setCategoryId(set.getInt(8));
                productList.add(product);
            }
        } catch (SQLException e) {
            LOG.error("Can't get product List by Id");
            throw e;
        } finally {
            DBManager.closeRs(set);
            DBManager.closeStat(st);
        }
        return productList;
    }

    @Override
    public boolean updateProduct(Product product, Connection con) throws SQLException {
        PreparedStatement st = null;
        try {
            st = con.prepareStatement(UPDATE_PRODUCT);
            st.setString(1, product.getName());
            st.setInt(2, product.getPrice());
            st.setInt(3, product.getCount());
            st.setInt(4, product.getDescriptionId());
            st.setInt(5, product.getCharacteristicId());
            st.setInt(6, product.getManufacturerId());
            st.setInt(7, product.getCategoryId());
            st.setInt(8, product.getProductId());
            st.executeUpdate();
        } catch (SQLException e) {
            LOG.error("Can't update product");
            throw e;
        } finally {
            DBManager.closeStat(st);
        }
        return true;
    }

    @Override
    public List<Product> getProductByCategory(int categoryId, int manufacturerId, Connection con) throws SQLException {
        List<Product> productList = new ArrayList<>();
        PreparedStatement st = null;
        ResultSet set = null;
        try {
            st = con.prepareStatement(GET_PRODUCT_BY_CATEGORY);
            st.setInt(1, categoryId);
            st.setInt(2, manufacturerId);
            set = st.executeQuery();
            while (set.next()) {
                Product product = new Product();
                product.setProductId(set.getInt(1));
                product.setName(set.getString(2));
                product.setPrice(set.getInt(3));
                product.setCount(set.getInt(4));
                product.setDescriptionId(set.getInt(5));
                product.setCharacteristicId(set.getInt(6));
                product.setManufacturerId(set.getInt(7));
                product.setCategoryId(set.getInt(8));
                productList.add(product);
            }
        } catch (SQLException e) {
            LOG.error("Can't get all products by category");
            throw e;
        } finally {
            DBManager.closeRs(set);
            DBManager.closeStat(st);
        }
        return productList;
    }

    @Override
    public List<Product> getProductByCategoryByAccessory(int subcatId, Connection con) throws SQLException {
        List<Product> productList = new ArrayList<>();
        PreparedStatement st = null;
        ResultSet set = null;
        try {
            st = con.prepareStatement(GET_PRODUCT_BY_CATEGORY_ACCESSORY);
            st.setInt(1, subcatId);
            set = st.executeQuery();
            while (set.next()) {
                Product product = new Product();
                product.setProductId(set.getInt(1));
                product.setName(set.getString(2));
                product.setPrice(set.getInt(3));
                product.setCount(set.getInt(4));
                product.setDescriptionId(set.getInt(5));
                product.setCharacteristicId(set.getInt(6));
                product.setManufacturerId(set.getInt(7));
                product.setCategoryId(set.getInt(8));
                productList.add(product);
            }
        } catch (SQLException e) {
            LOG.error("Can't get all products by category");
            throw e;
        } finally {
            DBManager.closeRs(set);
            DBManager.closeStat(st);
        }
        return productList;
    }
}
