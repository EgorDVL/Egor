package db.dao.impl;

import bean.Order;
import bean.SubcategoryAccessories;
import bean.enams.DeliveryMethod;
import bean.enams.PaymentMethod;
import bean.enams.SubCategoryAccessory;
import db.DBManager;
import db.dao.SubcategoryAccessoriesDAO;
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
public class SubcategoryAccessoriesDAOImpl implements SubcategoryAccessoriesDAO {
    private static final Logger LOG = Logger.getLogger(SubcategoryAccessoriesDAOImpl.class);

    private static final String CREATE_SUBCATEGORY_ACCESSORIES = "insert into subcategoryAccessories values(default, ?)";
    private static final String UPDATE_SUBCATEGORY_ACCESSORIES = "update subcategoryAccessories set nameSubCategoryAccessory =? where subcatId = ?";
    private static final String GET_SUBCATEGORY_ACCESSORIES_BY_ID = "select subcatId , nameSubCategoryAccessory from subcategoryAccessories where subcatId = ?";
    private static final String GET_ALL_SUBCATEGORY_ACCESSORIES = "select subcatId , nameSubCategoryAccessory from subcategoryAccessories";

    @Override
    public int createSubCategoryAccessories(SubcategoryAccessories subcategoryAccessories, Connection con) throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;
        int result = -1;
        try {
            st = con.prepareStatement(CREATE_SUBCATEGORY_ACCESSORIES, PreparedStatement.RETURN_GENERATED_KEYS);
            st.setString(1, subcategoryAccessories.getNameSubCategoryAccessory().toString());
            st.executeUpdate();
            rs = st.getGeneratedKeys();
            while (rs.next()) {
                result = rs.getInt(1);
            }
        } catch (SQLException e) {
            LOG.error("Can't create new subcategory accessorries");
            throw e;
        } finally {
            DBManager.closeRs(rs);
            DBManager.closeStat(st);
        }
        return result;
    }

    @Override
    public SubcategoryAccessories getSubCategoryAccessoriesById(int subcategoryAccessoriesId, Connection con) throws SQLException {
        SubcategoryAccessories subcategoryAccessories = null;
        PreparedStatement st = null;
        ResultSet set = null;
        try {
            st = con.prepareStatement(GET_SUBCATEGORY_ACCESSORIES_BY_ID);
            st.setInt(1, subcategoryAccessoriesId);
            set = st.executeQuery();
            while (set.next()) {
                subcategoryAccessories = new SubcategoryAccessories();
                subcategoryAccessories.setSubcatId(set.getInt(1));
                subcategoryAccessories.setNameSubCategoryAccessory(SubCategoryAccessory.getValue(set.getString(2)));
            }
        } catch (SQLException e) {
            LOG.error("Can't get subcategory accessories by Id");
            throw e;
        } finally {
            DBManager.closeRs(set);
            DBManager.closeStat(st);
        }
        return subcategoryAccessories;
    }

    @Override
    public List<SubcategoryAccessories> getAllSubcategoryAccessories(Connection con) throws SQLException {
        List<SubcategoryAccessories> subcategoryAccessoriesList = new ArrayList<>();
        PreparedStatement st = null;
        ResultSet set = null;
        try {
            st = con.prepareStatement(GET_ALL_SUBCATEGORY_ACCESSORIES);
            set = st.executeQuery();
            while (set.next()) {
                SubcategoryAccessories subcategoryAccessories = new SubcategoryAccessories();
                subcategoryAccessories.setSubcatId(set.getInt(1));
                subcategoryAccessories.setNameSubCategoryAccessory(SubCategoryAccessory.getValue(set.getString(2)));
                subcategoryAccessoriesList.add(subcategoryAccessories);
            }
        } catch (SQLException e) {
            LOG.error("Can't get subcategory accessories list by Id");
            throw e;
        } finally {
            DBManager.closeRs(set);
            DBManager.closeStat(st);
        }
        return subcategoryAccessoriesList;
    }

    @Override
    public boolean updateSubcategoryAccessories(SubcategoryAccessories subcategoryAccessories, Connection con) throws SQLException {
        PreparedStatement st = null;
        try {
            st = con.prepareStatement(UPDATE_SUBCATEGORY_ACCESSORIES);
            st.setString(1, subcategoryAccessories.getNameSubCategoryAccessory().toString());
            st.setInt(2, subcategoryAccessories.getSubcatId());
            st.executeUpdate();
        } catch (SQLException e) {
            LOG.error("Can't update subcategory accessories");
            throw e;
        } finally {
            DBManager.closeStat(st);
        }
        return true;
    }
}
