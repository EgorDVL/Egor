package db.dao.impl;

import bean.Description;
import bean.Manufacturer;
import bean.enams.ManufacturerEnam;
import db.DBManager;
import db.dao.ManufacturerDAO;
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
public class ManufacturerDAOImpl implements ManufacturerDAO {
    private static final Logger LOG = Logger.getLogger(ManufacturerDAOImpl.class);

    private static final String CREATE_MANUFACTURER = "insert into manufacturer values(default, ?)";
    private static final String UPDATE_MANUFACTURER = "update manufacturer set nameManufacturer = ?  where manufacturerId = ?";
    private static final String GET_MANUFACTURER_BY_ID = "select manufacturerId , nameManufacturer from manufacturer where manufacturerId = ?";
    private static final String GET_ALL_MANUFACTURER = "select manufacturerId , nameManufacturer from manufacturer";

    @Override
    public int createManufacturer(Manufacturer manufacturer, Connection con) throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;
        int result = -1;
        try {
            st = con.prepareStatement(CREATE_MANUFACTURER, PreparedStatement.RETURN_GENERATED_KEYS);
            st.setString(1, manufacturer.getNameManufacturer().toString());
            st.executeUpdate();
            rs = st.getGeneratedKeys();
            while (rs.next()) {
                result = rs.getInt(1);
            }
        } catch (SQLException e) {
            LOG.error("Can't create new manufacturer");
            throw e;
        } finally {
            DBManager.closeRs(rs);
            DBManager.closeStat(st);
        }
        return result;
    }

    @Override
    public Manufacturer getManufacturerById(int manufacturerId, Connection con) throws SQLException {
        Manufacturer manufacturer = null;
        PreparedStatement st = null;
        ResultSet set = null;
        try {
            st = con.prepareStatement(GET_MANUFACTURER_BY_ID);
            st.setInt(1, manufacturerId);
            set = st.executeQuery();
            while (set.next()) {
                manufacturer = new Manufacturer();
                manufacturer.setManufacturerId(set.getInt(1));
                manufacturer.setNameManufacturer(ManufacturerEnam.getValue(set.getString(2)));
            }
        } catch (SQLException e) {
            LOG.error("Can't get manufacturer by Id");
            throw e;
        } finally {
            DBManager.closeRs(set);
            DBManager.closeStat(st);
        }
        return manufacturer;
    }

    @Override
    public List<Manufacturer> getAllManufacturer(Connection con) throws SQLException {
        List<Manufacturer> manufacturerList = new ArrayList<>();
        PreparedStatement st = null;
        ResultSet set = null;
        try {
            st = con.prepareStatement(GET_ALL_MANUFACTURER);
            set = st.executeQuery();
            while (set.next()) {
                Manufacturer manufacturer = new Manufacturer();
                manufacturer.setManufacturerId(set.getInt(1));
                manufacturer.setNameManufacturer(ManufacturerEnam.getValue(set.getString(2)));
                manufacturerList.add(manufacturer);
            }
        } catch (SQLException e) {
            LOG.error("Can't get manufacturer list by Id");
            throw e;
        } finally {
            DBManager.closeRs(set);
            DBManager.closeStat(st);
        }
        return manufacturerList;
    }

    @Override
    public boolean updateManufacturer(Manufacturer manufacturer, Connection con) throws SQLException {
        PreparedStatement st = null;
        try {
            st = con.prepareStatement(UPDATE_MANUFACTURER);
            st.setString(1, manufacturer.getNameManufacturer().toString());
            st.setInt(2, manufacturer.getManufacturerId());
            st.executeUpdate();
        } catch (SQLException e) {
            LOG.error("Can't update manufacturer");
            throw e;
        } finally {
            DBManager.closeStat(st);
        }
        return true;
    }
}
