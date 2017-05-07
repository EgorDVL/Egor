package db.dao;

import bean.Characteristic;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Egor on 23.09.2016.
 */
public interface CharacteristicDAO {

    int createCharacteristic(Characteristic characteristic, Connection con) throws SQLException;

    Characteristic getCharacteristicById(int characteristicId, Connection con) throws SQLException;

    List<Characteristic> getAllCharacteristic(Connection con) throws SQLException;

    boolean updateCharacteristic(Characteristic characteristic, Connection con) throws SQLException;
}
