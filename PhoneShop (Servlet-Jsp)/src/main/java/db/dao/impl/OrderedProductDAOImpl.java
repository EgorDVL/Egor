package db.dao.impl;

import bean.Order;
import bean.OrderedProduct;
import bean.enams.DeliveryMethod;
import bean.enams.PaymentMethod;
import db.DBManager;
import db.dao.OrderedProductDAO;
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
public class OrderedProductDAOImpl implements OrderedProductDAO {
    private static final Logger LOG = Logger.getLogger(OrderedProductDAOImpl.class);

    private static final String CREATE_ORDERED_PRODUCT = "insert into orderedProduct values(default, ?, ?)";
    private static final String UPDATE_ORDERED_PRODUCT = "update orderId =?, productId =? where orderedProductId = ?";
    private static final String GET_ORDERED_PRODUCT_BY_ID = "select orderedProductId, orderId, productId from orderedProduct" +
            " where orderedProductId = ?";
    private static final String GET_ALL_ORDERED_PRODUCT = "select orderedProductId, orderId, productId from orderedProduct";

    @Override
    public int createOrderProduct(OrderedProduct orderedProduct, Connection con) throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;
        int result = -1;
        try {
            st = con.prepareStatement(CREATE_ORDERED_PRODUCT, PreparedStatement.RETURN_GENERATED_KEYS);
            st.setInt(1, orderedProduct.getOrderId());
            st.setInt(2, orderedProduct.getProductId());
            st.executeUpdate();
            rs = st.getGeneratedKeys();
            while (rs.next()) {
                result = rs.getInt(1);
            }
        } catch (SQLException e) {
            LOG.error("Can't create new Ordered product");
            throw e;
        } finally {
            DBManager.closeRs(rs);
            DBManager.closeStat(st);
        }
        return result;
    }

    @Override
    public OrderedProduct getOrderProductById(int orderedProductId, Connection con) throws SQLException {
        OrderedProduct orderedProduct = null;
        PreparedStatement st = null;
        ResultSet set = null;
        try {
            st = con.prepareStatement(GET_ORDERED_PRODUCT_BY_ID);
            st.setInt(1, orderedProductId);
            set = st.executeQuery();
            while (set.next()) {
                orderedProduct = new OrderedProduct();
                orderedProduct.setOrderedProductId(set.getInt(1));
                orderedProduct.setOrderId(set.getInt(2));
                orderedProduct.setProductId(set.getInt(3));
            }
        } catch (SQLException e) {
            LOG.error("Can't get ordered product by Id");
            throw e;
        } finally {
            DBManager.closeRs(set);
            DBManager.closeStat(st);
        }
        return orderedProduct;
    }

    @Override
    public List<OrderedProduct> getAllOrderProduct(Connection con) throws SQLException {
        List<OrderedProduct> orderedProductList = new ArrayList<>();
        PreparedStatement st = null;
        ResultSet set = null;
        try {
            st = con.prepareStatement(GET_ALL_ORDERED_PRODUCT);
            set = st.executeQuery();
            while (set.next()) {
                OrderedProduct orderedProduct = new OrderedProduct();
                orderedProduct.setOrderedProductId(set.getInt(1));
                orderedProduct.setOrderId(set.getInt(2));
                orderedProduct.setProductId(set.getInt(3));
                orderedProductList.add(orderedProduct);
            }
        } catch (SQLException e) {
            LOG.error("Can't get ordered product list by Id");
            throw e;
        } finally {
            DBManager.closeRs(set);
            DBManager.closeStat(st);
        }
        return orderedProductList;
    }

    @Override
    public boolean updateOrderedProduct(OrderedProduct orderedProduct, Connection con) throws SQLException {
        PreparedStatement st = null;
        try {
            st = con.prepareStatement(UPDATE_ORDERED_PRODUCT);
            st.setInt(1, orderedProduct.getOrderId());
            st.setInt(2, orderedProduct.getProductId());
            st.setInt(3, orderedProduct.getOrderedProductId());
            st.executeUpdate();
        } catch (SQLException e) {
            LOG.error("Can't update ordered product");
            throw e;
        } finally {
            DBManager.closeStat(st);
        }
        return true;
    }
}
