package db.dao.impl;

import bean.Product;
import bean.Sales;
import bean.enams.DeliveryMethod;
import bean.enams.PaymentMethod;
import db.DBManager;
import db.dao.SalesDAO;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Egor on 30.10.2016.
 */
public class SalesDAOImpl implements SalesDAO {
    private static final Logger LOG = Logger.getLogger(SalesDAOImpl.class);
    private static final String CREATE_SALES = "insert into sales values(default,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String GET_SALES_BY_ID = "select email, userName, userSurname, userPhone, userCity, userAddress, userHouse, " +
            "delivery, payment, productId, price, productCount, allPrice, dateBuy from sales where salesId = ?";
    private static final String GET_ALL_SALES = "select salesId, email, userName, userSurname, userPhone, userCity, userAddress, userHouse, " +
            "delivery, payment, productId, price, productCount, allPrice, dateBuy from sales";


    @Override
    public int createSales(Sales sales, Connection con) throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;
        int result = -1;
        try {
            st = con.prepareStatement(CREATE_SALES, PreparedStatement.RETURN_GENERATED_KEYS);
            st.setString(1, sales.getEmail());
            st.setString(2, sales.getUserName());
            st.setString(3, sales.getUserSurname());
            st.setString(4, sales.getUserPhone());
            st.setString(5, sales.getUserCity());
            st.setString(6, sales.getUserAddress());
            st.setInt(7, sales.getUserHouse());
            st.setString(8, sales.getDeliveryMethod().toString());
            st.setString(9, sales.getPaymentMethod().toString());
            st.setInt(10, sales.getProductId());
            st.setInt(11, sales.getPrice());
            st.setInt(12, sales.getProductCount());
            st.setInt(13, sales.getAllPrice());
            st.setDate(14, new Date(sales.getDateBuy().getTime()));
            st.executeUpdate();
            rs = st.getGeneratedKeys();
            while (rs.next()) {
                result = rs.getInt(1);
            }
        } catch (SQLException e) {
            LOG.error("Can't create new sales");
            throw e;
        } finally {
            DBManager.closeRs(rs);
            DBManager.closeStat(st);
        }
        return result;
    }

    @Override
    public Sales getSalesById(int salesId, Connection con) throws SQLException {
        Sales sales = null;
        PreparedStatement st = null;
        ResultSet set = null;
        try {
            st = con.prepareStatement(GET_SALES_BY_ID);
            st.setInt(1, salesId);
            set = st.executeQuery();
            while (set.next()) {
                sales = new Sales();
                sales.setSalesId(set.getInt(1));
                sales.setEmail(set.getString(2));
                sales.setUserName(set.getString(3));
                sales.setUserSurname(set.getString(4));
                sales.setUserPhone(set.getString(5));
                sales.setUserCity(set.getString(6));
                sales.setUserAddress(set.getString(7));
                sales.setUserHouse(set.getInt(8));
                sales.setDeliveryMethod(DeliveryMethod.getValue(set.getString(9)));
                sales.setPaymentMethod(PaymentMethod.getValue(set.getString(10)));
                sales.setProductId(set.getInt(11));
                sales.setPrice(set.getInt(12));
                sales.setProductCount(set.getInt(13));
                sales.setAllPrice(set.getInt(14));
                sales.setDateBuy(set.getDate(15));
            }
        } catch (SQLException e) {
            LOG.error("Can't get sales by Id");
            throw e;
        } finally {
            DBManager.closeRs(set);
            DBManager.closeStat(st);
        }
        return sales;
    }

    @Override
    public List<Sales> getAllSales(Connection con) throws SQLException {
        List<Sales> salesList = new ArrayList<>();
        PreparedStatement st = null;
        ResultSet set = null;
        try {
            st = con.prepareStatement(GET_ALL_SALES);
            set = st.executeQuery();
            while (set.next()) {
                Sales sales = new Sales();
                sales.setSalesId(set.getInt(1));
                sales.setEmail(set.getString(2));
                sales.setUserName(set.getString(3));
                sales.setUserSurname(set.getString(4));
                sales.setUserPhone(set.getString(5));
                sales.setUserCity(set.getString(6));
                sales.setUserAddress(set.getString(7));
                sales.setUserHouse(set.getInt(8));
                sales.setDeliveryMethod(DeliveryMethod.getValue(set.getString(9)));
                sales.setPaymentMethod(PaymentMethod.getValue(set.getString(10)));
                sales.setProductId(set.getInt(11));
                sales.setPrice(set.getInt(12));
                sales.setProductCount(set.getInt(13));
                sales.setAllPrice(set.getInt(14));
                sales.setDateBuy(set.getDate(15));
                salesList.add(sales);
            }
        } catch (SQLException e) {
            LOG.error("Can't get sales list");
            throw e;
        } finally {
            DBManager.closeRs(set);
            DBManager.closeStat(st);
        }
        return salesList;
    }
}
