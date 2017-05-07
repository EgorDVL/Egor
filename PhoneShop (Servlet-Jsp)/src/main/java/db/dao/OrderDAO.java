package db.dao;

import bean.Order;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Egor on 23.09.2016.
 */
public interface OrderDAO {

    int createOrder(Order order, Connection con) throws SQLException;

    Order getOrderById(int orderId, Connection con) throws SQLException;

    List<Order> getAllOrder(Connection con) throws SQLException;

    boolean updateOrder(Order order, Connection con) throws SQLException;
}
