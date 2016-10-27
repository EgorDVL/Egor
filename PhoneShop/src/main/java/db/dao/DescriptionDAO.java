package db.dao;

import bean.Characteristic;
import bean.Description;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Egor on 23.09.2016.
 */
public interface DescriptionDAO {

    int createDescription(Description description, Connection con) throws SQLException;

    Description getDescriptionById(int descriptionId, Connection con) throws SQLException;

    List<Description> getAllDescription(Connection con) throws SQLException;

    boolean updateDescription(Description description, Connection con) throws SQLException;
}
