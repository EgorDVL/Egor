package db.dao;

import bean.Manufacturer;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Egor on 23.09.2016.
 */
public interface ManufacturerDAO {

    int createManufacturer(Manufacturer manufacturer, Connection con) throws SQLException;

    Manufacturer getManufacturerById(int manufacturerId, Connection con) throws SQLException;

    List<Manufacturer> getAllManufacturer(Connection con) throws SQLException;

    boolean updateManufacturer(Manufacturer manufacturer, Connection con) throws SQLException;
}
