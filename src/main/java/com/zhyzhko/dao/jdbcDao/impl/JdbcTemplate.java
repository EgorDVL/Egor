package com.zhyzhko.dao.jdbcDao.impl;

import com.zhyzhko.util.DBManager;
import com.zhyzhko.exception.ObtainObjectException;
import com.zhyzhko.exception.PersistException;
import com.zhyzhko.dao.jdbcDao.rowmapper.RowMapper;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 03.07.17.
 */
public class JdbcTemplate<T> {

    private static final Logger LOG = Logger.getLogger(JdbcTemplate.class);

    public int create(String sql, Object... args) {
        Connection con = DBManager.getConnection();
        int result = -1;

        try (PreparedStatement st = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            LOG.info("Connection status. IsClosed: " + con.isClosed() + ". HashCode: " + con.hashCode());
            for (int i = 0; i < args.length; i++) {
                st.setObject(i + 1, args[i]);
            }
            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
                result = rs.getInt(1);
            }
        } catch (SQLException e) {
            LOG.error("Can't create object", e);
            throw new PersistException(e);
        }
        return result;
    }

    public T get(String sql, RowMapper mapper, Object... args) {
        Connection con = DBManager.getConnection();
        T result = null;

        try (PreparedStatement st = con.prepareStatement(sql)) {
            LOG.info("Connection status. IsClosed: " + con.isClosed() + ". HashCode: " + con.hashCode());

            for (int i = 0; i < args.length; i++) {
                st.setObject(i + 1, args[i]);
            }
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                result = (T) mapper.extract(rs);
            }
        } catch (SQLException e) {
            LOG.error("Can't obtain object", e);
            throw new ObtainObjectException(e);
        }
        return result;
    }

    public List<T> getAll(String sql, RowMapper mapper, Object... args) {
        Connection con = DBManager.getConnection();
        List<T> result = new ArrayList<>();

        try (PreparedStatement st = con.prepareStatement(sql)) {
            LOG.info("Connection status. IsClosed: " + con.isClosed() + ". HashCode: " + con.hashCode());

            for (int i = 0; i < args.length; i++) {
                st.setObject(i + 1, args[i]);
            }
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                result.add((T) mapper.extract(rs));
            }
        } catch (SQLException e) {
            LOG.error("Can't obtain object", e);
            throw new ObtainObjectException(e);
        }
        return result;
    }

    public boolean update(String sql, Object... args) {
        return executeRowUpdate(sql, args);
    }

    public boolean delete(String sql, Object... args) {
        return executeRowUpdate(sql, args);
    }

    private boolean executeRowUpdate(String sql, Object[] args) {
        Connection con = DBManager.getConnection();
        try (PreparedStatement st = con.prepareStatement(sql)) {
            LOG.info("Connection status. IsClosed: " + con.isClosed() + ". HashCode: " + con.hashCode());

            for (int i = 0; i < args.length; i++) {
                st.setObject(i + 1, args[i]);
            }
            st.executeUpdate();
        } catch (SQLException e) {
            LOG.error("Can't update persisting", e);
            throw new PersistException(e);
        }
        return true;
    }
}