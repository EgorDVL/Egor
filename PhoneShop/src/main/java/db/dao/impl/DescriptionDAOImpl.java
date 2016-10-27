package db.dao.impl;

import bean.Characteristic;
import bean.Description;
import db.DBManager;
import db.dao.DescriptionDAO;
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
public class DescriptionDAOImpl implements DescriptionDAO {
    private static final Logger LOG = Logger.getLogger(DescriptionDAOImpl.class);

    private static final String CREATE_DESCRIPTION = "insert into description values(default, ?)";
    private static final String UPDATE_DESCRIPTION = "update description set description = ?  where descriptionId = ?";

    private static final String GET_DESCRIPTION_BY_ID = "select descriptionId, description from description where descriptionId = ?";

    private static final String GET_ALL_DESCRIPTION = "select descriptionId, description from description";

    @Override
    public int createDescription(Description description, Connection con) throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;
        int result = -1;
        try {
            st = con.prepareStatement(CREATE_DESCRIPTION, PreparedStatement.RETURN_GENERATED_KEYS);
            st.setString(1, description.getDescription());
            st.executeUpdate();
            rs = st.getGeneratedKeys();
            while (rs.next()) {
                result = rs.getInt(1);
            }
        } catch (SQLException e) {
            LOG.error("Can't create new description");
            throw e;
        } finally {
            DBManager.closeRs(rs);
            DBManager.closeStat(st);
        }
        return result;
    }

    @Override
    public Description getDescriptionById(int descriptionId, Connection con) throws SQLException {
        Description description = null;
        PreparedStatement st = null;
        ResultSet set = null;
        try {
            st = con.prepareStatement(GET_DESCRIPTION_BY_ID);
            st.setInt(1, descriptionId);
            set = st.executeQuery();
            while (set.next()) {
                description = new Description();
                description.setDescriptionId(set.getInt(1));
                description.setDescription(set.getString(2));
            }
        } catch (SQLException e) {
            LOG.error("Can't get descriotion by Id");
            throw e;
        } finally {
            DBManager.closeRs(set);
            DBManager.closeStat(st);
        }
        return description;
    }

    @Override
    public List<Description> getAllDescription(Connection con) throws SQLException {
        List<Description> descriptionList = new ArrayList<>();
        PreparedStatement st = null;
        ResultSet set = null;
        try {
            st = con.prepareStatement(GET_ALL_DESCRIPTION);
            set = st.executeQuery();
            while (set.next()) {
                Description description = new Description();
                description.setDescriptionId(set.getInt(1));
                description.setDescription(set.getString(2));
                descriptionList.add(description);
            }
        } catch (SQLException e) {
            LOG.error("Can't get descriotion list by Id");
            throw e;
        } finally {
            DBManager.closeRs(set);
            DBManager.closeStat(st);
        }
        return descriptionList;
    }

    @Override
    public boolean updateDescription(Description description, Connection con) throws SQLException {
        PreparedStatement st = null;
        try {
            st = con.prepareStatement(UPDATE_DESCRIPTION);
            st.setString(1, description.getDescription());
            st.setInt(2, description.getDescriptionId());
            st.executeUpdate();
        } catch (SQLException e) {
            LOG.error("Can't update description");
            throw e;
        } finally {
            DBManager.closeStat(st);
        }
        return true;
    }
}
