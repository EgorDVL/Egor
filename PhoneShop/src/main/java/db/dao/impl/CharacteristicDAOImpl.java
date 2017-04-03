package db.dao.impl;

import bean.Category;
import bean.Characteristic;
import bean.User;
import bean.enams.CategoryEnam;
import db.DBManager;
import db.dao.CharacteristicDAO;
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
public class CharacteristicDAOImpl implements CharacteristicDAO {

    private static final Logger LOG = Logger.getLogger(CharacteristicDAOImpl.class);

    private static final String CREATE_CHARACTERISTIC = "insert into characteristic values(default, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_CHARACTERISTIC = "update characteristic set color =?, memory =?, " +
            "screenSize =?, processor =?, ram =?, frontCamera =?, mainCamera =?  where characteristicId = ?";

    private static final String GET_CHARACTERISTIC_BY_ID = "select characteristicId, color, memory, screenSize," +
            " processor, ram, frontCamera, mainCamera from characteristic where characteristicId = ?";

    private static final String GET_ALL_CHARACTERISTIC = "select characteristicId, color, memory, screenSize, processor," +
            " ram, frontCamera, mainCamera from characteristic";

    @Override
    public int createCharacteristic(Characteristic characteristic, Connection con) throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;
        int result = -1;
        try {
            st = con.prepareStatement(CREATE_CHARACTERISTIC, PreparedStatement.RETURN_GENERATED_KEYS);
            st.setString(1, characteristic.getColor());
            st.setInt(2, characteristic.getMemory());
            st.setDouble(3, characteristic.getScreenSize());
            st.setString(4, characteristic.getProcessor());
            st.setDouble(5, characteristic.getRam());
            st.setDouble(6, characteristic.getFrontCamera());
            st.setDouble(7, characteristic.getMainCamera());
            st.executeUpdate();
            rs = st.getGeneratedKeys();
            while (rs.next()) {
                result = rs.getInt(1);
            }
        } catch (SQLException e) {
            LOG.error("Can't create new Characheristic");
            throw e;
        } finally {
            DBManager.closeRs(rs);
            DBManager.closeStat(st);
        }
        return result;
    }

    @Override
    public Characteristic getCharacteristicById(int characteristicId, Connection con) throws SQLException {
        Characteristic characteristic = null;
        PreparedStatement st = null;
        ResultSet set = null;
        try {
            st = con.prepareStatement(GET_CHARACTERISTIC_BY_ID);
            st.setInt(1, characteristicId);
            set = st.executeQuery();
            while (set.next()) {
                characteristic = new Characteristic();
                characteristic.setCharacteristicId(set.getInt(1));
                characteristic.setColor(set.getString(2));
                characteristic.setMemory(set.getInt(3));
                characteristic.setScreenSize(set.getDouble(4));
                characteristic.setProcessor(set.getString(5));
                characteristic.setRam(set.getDouble(6));
                characteristic.setFrontCamera(set.getDouble(7));
                characteristic.setMainCamera(set.getDouble(8));
            }
        } catch (SQLException e) {
            LOG.error("Can't get characheristic by Id");
            throw e;
        } finally {
            DBManager.closeRs(set);
            DBManager.closeStat(st);
        }
        return characteristic;
    }

    @Override
    public List<Characteristic> getAllCharacteristic(Connection con) throws SQLException {
        List<Characteristic> characteristicList = new ArrayList<>();
        PreparedStatement st = null;
        ResultSet set = null;
        try {
            st = con.prepareStatement(GET_ALL_CHARACTERISTIC);
            set = st.executeQuery();
            while (set.next()) {
                Characteristic characteristic = new Characteristic();
                characteristic.setCharacteristicId(set.getInt(1));
                characteristic.setColor(set.getString(2));
                characteristic.setMemory(set.getInt(3));
                characteristic.setScreenSize(set.getDouble(4));
                characteristic.setProcessor(set.getString(5));
                characteristic.setRam(set.getDouble(6));
                characteristic.setFrontCamera(set.getDouble(7));
                characteristic.setMainCamera(set.getDouble(8));
                characteristicList.add(characteristic);
            }
        } catch (SQLException e) {
            LOG.error("Can't get all characteristic");
            throw e;
        } finally {
            DBManager.closeRs(set);
            DBManager.closeStat(st);
        }
        return characteristicList;
    }

    @Override
    public boolean updateCharacteristic(Characteristic characteristic, Connection con) throws SQLException {
        PreparedStatement st = null;
        try {
            st = con.prepareStatement(UPDATE_CHARACTERISTIC);
            st.setString(1, characteristic.getColor());
            st.setInt(2, characteristic.getMemory());
            st.setDouble(3, characteristic.getScreenSize());
            st.setString(4, characteristic.getProcessor());
            st.setDouble(5, characteristic.getRam());
            st.setDouble(6, characteristic.getFrontCamera());
            st.setDouble(7, characteristic.getMainCamera());
            st.setInt(8, characteristic.getCharacteristicId());
            st.executeUpdate();
        } catch (SQLException e) {
            LOG.error("Can't update characteristic");
            throw e;
        } finally {
            DBManager.closeStat(st);
        }
        return true;
    }
}
