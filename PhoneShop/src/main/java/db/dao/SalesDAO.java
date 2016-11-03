package db.dao;

import bean.Sales;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Egor on 30.10.2016.
 */
public interface SalesDAO {

    int createSales(Sales sales, Connection con) throws SQLException;

    Sales getSalesById(int salesId, Connection con) throws SQLException;

    List<Sales> getAllSales(Connection con) throws SQLException;

}
