package db.dao;

import bean.OrderedProduct;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Egor on 23.09.2016.
 */
public interface OrderedProductDAO {

    int createOrderProduct(OrderedProduct orderedProduct, Connection con) throws SQLException;

    OrderedProduct getOrderProductById(int orderedProductId, Connection con) throws SQLException;

    List<OrderedProduct> getAllOrderProduct(Connection con) throws SQLException;

    boolean updateOrderedProduct(OrderedProduct orderedProduct, Connection con) throws SQLException;
}
