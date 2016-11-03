package Service;

import bean.Category;
import bean.SubcategoryAccessories;
import db.DBManager;
import db.dao.CategoryDAO;
import db.dao.DaoFactory;
import db.dao.SubcategoryAccessoriesDAO;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Egor on 10.10.2016.
 */
public class CategoryService {
    private static final Logger LOG = Logger.getLogger(CategoryService.class);
    private CategoryDAO categoryDAO = DaoFactory.getCategoryDao();
    private SubcategoryAccessoriesDAO subcategoryAccessoriesDAO = DaoFactory.getSubcategoryAccessoriesDao();


    public SubcategoryAccessories getSubCategoryById(int subCategoryAccessoriesId) {
        Connection con = DBManager.getConnection();
        SubcategoryAccessories subcategoryAccessories = null;
        try {
            subcategoryAccessories = subcategoryAccessoriesDAO.getSubCategoryAccessoriesById(subCategoryAccessoriesId, con);
            DBManager.commit(con);
        } catch (SQLException e) {
            LOG.error("Can't get category by Id");
            DBManager.rollback(con);
        } finally {
            DBManager.closeCon(con);
        }
        return subcategoryAccessories;
    }

    public Category getCategoryById(int categoryId) {
        Connection con = DBManager.getConnection();
        Category category = null;
        try {
            category = categoryDAO.getCategoryById(categoryId, con);
            DBManager.commit(con);
        } catch (SQLException e) {
            LOG.error("Can't get category by Id");
            DBManager.rollback(con);
        } finally {
            DBManager.closeCon(con);
        }
        return category;
    }

    public List<Category> getAllCategory() {
        Connection con = DBManager.getConnection();
        List<Category> categoryList = new ArrayList<>();
        try {
            categoryList = categoryDAO.getAllCategory(con);
            DBManager.commit(con);
        } catch (SQLException e) {
            LOG.error("Can't get all category");
            DBManager.rollback(con);
        } finally {
            DBManager.closeCon(con);
        }
        return categoryList;
    }

    public Category getCategoryBySubcategory(int subcategory) {
        Connection con = DBManager.getConnection();
        Category category = new Category();
        try {
            category = categoryDAO.getCategoryBySubCategory(subcategory, con);
            DBManager.commit(con);
        } catch (SQLException e) {
            LOG.error("Can't get category by subcategory");
            DBManager.rollback(con);
        } finally {
            DBManager.closeCon(con);
        }
        return category;
    }
}
