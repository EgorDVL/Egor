package db.dao;

import bean.SubcategoryAccessories;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Egor on 23.09.2016.
 */
public interface SubcategoryAccessoriesDAO {

    int createSubCategoryAccessories(SubcategoryAccessories subcategoryAccessories, Connection con) throws SQLException;

    SubcategoryAccessories getSubCategoryAccessoriesById(int subcategoryAccessoriesId, Connection con) throws SQLException;

    List<SubcategoryAccessories> getAllSubcategoryAccessories(Connection con) throws SQLException;

    boolean updateSubcategoryAccessories(SubcategoryAccessories subcategoryAccessories, Connection con) throws SQLException;

}
