package db.dao.impl;

import bean.Category;
import bean.enams.CategoryEnam;
import db.DBManager;
import db.dao.CategoryDAO;
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
public class CategoryDAOImpl implements CategoryDAO {

    private static final Logger LOG = Logger.getLogger(CategoryDAOImpl.class);

    private static final String CREATE_CATEGORY = "insert into category values(default, ?, ?)";
    private static final String UPDATE_CATEGORY = "update category set nameCategory = ?, subcatId = ?, where categoryId = ?";
    private static final String GET_CATEGORY_BY_ID = "select categoryId ,nameCategory, subcatId from category where categoryId = ?";
    private static final String GET_ALL_CATEGORYS = "select categoryId ,nameCategory, subcatId from category";

    @Override
    public int createCategory(Category category, Connection con) throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;
        int result = -1;
        try {
            st = con.prepareStatement(CREATE_CATEGORY, PreparedStatement.RETURN_GENERATED_KEYS);
            st.setString(1, category.getNameCategory().toString());
            st.setInt(2, category.getSubcatId());
            st.executeUpdate();
            rs = st.getGeneratedKeys();
            while (rs.next()) {
                result = rs.getInt(1);
            }
        } catch (SQLException e) {
            LOG.error("Can't create new Category");
            throw e;
        } finally {
            DBManager.closeRs(rs);
            DBManager.closeStat(st);
        }
        return result;
    }

    @Override
    public Category getCategoryById(int categoryId, Connection con) throws SQLException {
        Category category = null;
        PreparedStatement st = null;
        ResultSet set = null;
        try {
            st = con.prepareStatement(GET_CATEGORY_BY_ID);
            st.setInt(1, categoryId);
            set = st.executeQuery();
            while (set.next()) {
                category = new Category();
                category.setCategoryId(set.getInt(1));
                category.setNameCategory(CategoryEnam.getValue(set.getString(2)));
                category.setSubcatId(set.getInt(3));
            }
        } catch (SQLException e) {
            LOG.error("Can't get category by Id");
            throw e;
        } finally {
            DBManager.closeRs(set);
            DBManager.closeStat(st);
        }
        return category;
    }

    @Override
    public List<Category> getAllCategory(Connection con) throws SQLException {
        List<Category> categoryList = new ArrayList<>();
        PreparedStatement st = null;
        ResultSet set = null;
        try {
            st = con.prepareStatement(GET_ALL_CATEGORYS);
            set = st.executeQuery();
            while (set.next()) {
                Category category = new Category();
                category.setCategoryId(set.getInt(1));
                category.setNameCategory(CategoryEnam.getValue(set.getString(2)));
                category.setSubcatId(set.getInt(3));
                categoryList.add(category);
            }
        } catch (SQLException e) {
            LOG.error("Can't get all categorys");
            throw e;
        } finally {
            DBManager.closeRs(set);
            DBManager.closeStat(st);
        }
        return categoryList;
    }

    @Override
    public boolean updateCategory(Category category, Connection con) throws SQLException {
        PreparedStatement st = null;
        try {
            st = con.prepareStatement(UPDATE_CATEGORY);
            st.setString(1, category.getNameCategory().toString());
            st.setInt(2, category.getSubcatId());
            st.setInt(3, category.getCategoryId());
            st.executeUpdate();
        } catch (SQLException e) {
            LOG.error("Can't update category");
            throw e;
        } finally {
            DBManager.closeStat(st);
        }
        return true;
    }
}
