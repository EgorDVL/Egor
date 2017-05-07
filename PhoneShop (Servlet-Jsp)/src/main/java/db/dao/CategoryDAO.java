package db.dao;

import bean.Category;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Egor on 23.09.2016.
 */
public interface CategoryDAO {

    int createCategory(Category category, Connection con) throws SQLException;

    Category getCategoryById(int categoryId, Connection con) throws SQLException;

    List<Category> getAllCategory(Connection con) throws SQLException;

    boolean updateCategory(Category category, Connection con) throws SQLException;

    Category getCategoryBySubCategory(int subcategoryId, Connection con) throws SQLException;

}
