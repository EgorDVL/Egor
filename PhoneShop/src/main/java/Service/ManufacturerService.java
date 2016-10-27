package Service;

import bean.Manufacturer;
import db.DBManager;
import db.dao.DaoFactory;
import db.dao.ManufacturerDAO;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Egor on 19.10.2016.
 */
public class ManufacturerService {
    private static final Logger LOG = Logger.getLogger(ManufacturerService.class);
    private ManufacturerDAO manufacturerDAO = DaoFactory.getManufacturerDao();

    public Manufacturer getManufacturerById(int manufacturerId) {
        Connection con = DBManager.getConnection();
        Manufacturer manufacturer = null;
        try {
            manufacturer = manufacturerDAO.getManufacturerById(manufacturerId, con);
            DBManager.commit(con);
        } catch (SQLException e) {
            LOG.error("Can't get manufacturer by id");
            DBManager.rollback(con);
        } finally {
            DBManager.closeCon(con);
        }
        return manufacturer;
    }
}
