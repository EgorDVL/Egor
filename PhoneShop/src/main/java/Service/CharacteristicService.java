package Service;

import bean.Characteristic;
import db.DBManager;
import db.dao.CharacteristicDAO;
import db.dao.DaoFactory;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Egor on 19.10.2016.
 */
public class CharacteristicService {
    private static final Logger LOG = Logger.getLogger(CharacteristicService.class);
    private CharacteristicDAO characteristicDAO = DaoFactory.getCharacteristicDao();

    public Characteristic getCharacteristicById(int characteristicId) {
        Connection con = DBManager.getConnection();
        Characteristic characteristic = null;
        try {
            characteristic = characteristicDAO.getCharacteristicById(characteristicId, con);
            DBManager.commit(con);
        } catch (SQLException e) {
            LOG.error("Can't get characteristic by Id");
            DBManager.rollback(con);
        } finally {
            DBManager.closeCon(con);
        }
        return characteristic;
    }
}
