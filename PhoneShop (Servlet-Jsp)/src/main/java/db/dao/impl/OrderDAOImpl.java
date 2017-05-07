package db.dao.impl;

import bean.Characteristic;
import bean.Order;
import bean.enams.DeliveryMethod;
import bean.enams.PaymentMethod;
import db.DBManager;
import db.dao.OrderDAO;
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
public class OrderDAOImpl implements OrderDAO {
    private static final Logger LOG = Logger.getLogger(OrderDAOImpl.class);

    private static final String CREATE_ORDER = "insert into `order` values(default, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_ORDER = "update `order` set city =?, addres =?, paymentMethod =?, " +
            "deliveryMethod =?, comments =?, userId =? where orderId = ?";
    private static final String GET_ORDER_BY_ID = "select orderId, city, addres, paymentMethod, deliveryMethod, comments, " +
            "userId from `order` where orderId = ?";
    private static final String GET_ALL_ORDER = "select orderId, city, addres, paymentMethod, deliveryMethod, comments, " +
            "userId from `order`";

    @Override
    public int createOrder(Order order, Connection con) throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;
        int result = -1;
        try {
            st = con.prepareStatement(CREATE_ORDER, PreparedStatement.RETURN_GENERATED_KEYS);

            st.setString(1, order.getCity());
            st.setString(2, order.getAddres());
            st.setString(3, order.getPaymentMethod().toString());
            st.setString(4, order.getDeliveryMethod().toString());
            st.setString(5, order.getComments());
            st.setInt(6, order.getUserId());
            st.executeUpdate();
            rs = st.getGeneratedKeys();
            while (rs.next()) {
                result = rs.getInt(1);
            }
        } catch (SQLException e) {
            LOG.error("Can't create new Order");
            throw e;
        } finally {
            DBManager.closeRs(rs);
            DBManager.closeStat(st);
        }
        return result;
    }

    @Override
    public Order getOrderById(int orderId, Connection con) throws SQLException {
        Order order = null;
        PreparedStatement st = null;
        ResultSet set = null;
        try {
            st = con.prepareStatement(GET_ORDER_BY_ID);
            st.setInt(1, orderId);
            set = st.executeQuery();
            while (set.next()) {
                order = new Order();
                order.setOrderId(set.getInt(1));
                order.setCity(set.getString(2));
                order.setAddres(set.getString(3));
                order.setPaymentMethod(PaymentMethod.getValue(set.getString(4)));
                order.setDeliveryMethod(DeliveryMethod.getValue(set.getString(5)));
                order.setComments(set.getString(6));
                order.setUserId(set.getInt(7));
            }
        } catch (SQLException e) {
            LOG.error("Can't get order by Id");
            throw e;
        } finally {
            DBManager.closeRs(set);
            DBManager.closeStat(st);
        }
        return order;
    }

    @Override
    public List<Order> getAllOrder(Connection con) throws SQLException {
        List<Order> orderList = new ArrayList<>();
        PreparedStatement st = null;
        ResultSet set = null;
        try {
            st = con.prepareStatement(GET_ALL_ORDER);
            set = st.executeQuery();
            while (set.next()) {
                Order order = new Order();
                order.setOrderId(set.getInt(1));
                order.setCity(set.getString(2));
                order.setAddres(set.getString(3));
                order.setPaymentMethod(PaymentMethod.getValue(set.getString(4)));
                order.setDeliveryMethod(DeliveryMethod.getValue(set.getString(5)));
                order.setComments(set.getString(6));
                order.setUserId(set.getInt(7));
                orderList.add(order);
            }
        } catch (SQLException e) {
            LOG.error("Can't get order list by Id");
            throw e;
        } finally {
            DBManager.closeRs(set);
            DBManager.closeStat(st);
        }
        return orderList;
    }

    @Override
    public boolean updateOrder(Order order, Connection con) throws SQLException {
        PreparedStatement st = null;
        try {
            st = con.prepareStatement(UPDATE_ORDER);
            st.setString(1, order.getCity());
            st.setString(2, order.getAddres());
            st.setString(3, order.getPaymentMethod().toString());
            st.setString(4, order.getDeliveryMethod().toString());
            st.setString(5, order.getComments());
            st.setInt(6, order.getUserId());
            st.setInt(7, order.getOrderId());
            st.executeUpdate();
        } catch (SQLException e) {
            LOG.error("Can't update order");
            throw e;
        } finally {
            DBManager.closeStat(st);
        }
        return true;
    }
}
