package db.dao.impl;

import db.DBManager;
import db.TransactionProxyManager;
import db.exception.ObtainObjectException;
import db.exception.PersistException;
import db.rowmapper.RowMapper;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Egor on 06.01.2017.
 */
public class JdbcTemplate<T> {

    private static final Logger LOG = Logger.getLogger(JdbcTemplate.class);

    public int create(String sql, Object... args) {
        Connection con = DBManager.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        int result = -1;
        try {
            LOG.info("Connection status. IsClosed: " + con.isClosed() + ". HashCode: " + con.hashCode());
            st = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            for (int i = 0; i < args.length; i++) {
                st.setObject(i + 1, args[i]);
            }
            st.executeUpdate();
            rs = st.getGeneratedKeys();
            if (rs.next()) {
                result = rs.getInt(1);
            }
        } catch (SQLException e) {
            LOG.error("Can't execute persisting", e);
            throw new PersistException(e);
        } finally {
            DBManager.closeRs(rs);
            DBManager.closeStat(st);
        }
        return result;
    }

    public T get(String sql, RowMapper mapper, Object... args) {
        Connection con = DBManager.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        T result = null;
        try {
            LOG.info("Connection status. IsClosed: " + con.isClosed() + ". HashCode: " + con.hashCode());
            st = con.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                st.setObject(i + 1, args[i]);
            }
            rs = st.executeQuery();
            if (rs.next()) {
                result = (T) mapper.extract(rs);
            }
        } catch (SQLException e) {
            LOG.error("Can't obtain object", e);
            throw new ObtainObjectException(e);
        } finally {
            DBManager.closeRs(rs);
            DBManager.closeStat(st);
        }
        return result;
    }

    public List<T> getAll(String sql, RowMapper mapper, Object... args) {
        Connection con = DBManager.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        List<T> result = new ArrayList<>();
        try {
            LOG.info("Connection status. IsClosed: " + con.isClosed() + ". HashCode: " + con.hashCode());
            st = con.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                st.setObject(i + 1, args[i]);
            }
            rs = st.executeQuery();
            while (rs.next()) {
                result.add((T) mapper.extract(rs));
            }
        } catch (SQLException e) {
            LOG.error("Can't obtain object", e);
            throw new ObtainObjectException(e);
        } finally {
            DBManager.closeRs(rs);
            DBManager.closeStat(st);
        }
        return result;
    }

    public <T> List<T> getAllParametrized(String sql, RowMapper mapper, Object... args) {
        return (List<T>) getAll(sql, mapper, args);
    }

    public boolean update(String sql, Object... args) {
        return executeRowUpdate(sql, args);
    }

    public boolean delete(String sql, Object... args) {
        return executeRowUpdate(sql, args);
    }

    private boolean executeRowUpdate(String sql, Object[] args) {
        Connection con = DBManager.getConnection();
        PreparedStatement st = null;
        try {
            LOG.info("Connection status. IsClosed: " + con.isClosed() + ". HashCode: " + con.hashCode());
            st = con.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                st.setObject(i + 1, args[i]);
            }
            st.executeUpdate();
        } catch (SQLException e) {
            LOG.error("Can't update persisting", e);
            throw new PersistException(e);
        } finally {
            DBManager.closeStat(st);
        }
        return true;
    }
}