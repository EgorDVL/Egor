package Service;

import bean.Description;
import db.DBManager;
import db.dao.DaoFactory;
import db.dao.DescriptionDAO;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Egor on 19.10.2016.
 */
public class DescriptionService {
    private static final Logger LOG = Logger.getLogger(DescriptionService.class);
    private DescriptionDAO descriptionDAO = DaoFactory.getDescriptionDao();

    public Description getDescriptionById(int descriptionId) {
        Connection con = DBManager.getConnection();
        Description description = null;
        try {
            description = descriptionDAO.getDescriptionById(descriptionId, con);
            DBManager.commit(con);
        } catch (SQLException e) {
            LOG.error("Can't get description by Id");
            DBManager.rollback(con);
        } finally {
            DBManager.closeCon(con);
        }
        return description;
    }
}
