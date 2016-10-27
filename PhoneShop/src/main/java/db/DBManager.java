package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class DBManager {
    private static final Logger LOG = Logger.getLogger(DBManager.class);

    private static final String url = "jdbc:mysql://localhost:3306/phoneShopDB";
    private static final String user = "root";
    private static final String password = "root";

    private static final String driverClassName = "com.mysql.jdbc.Driver";

    static {
        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            LOG.error("Driver mysql not found");
        }
    }

    public static Connection getConnection() {
        LOG.info("Start create connection");
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, password);
            con.setAutoCommit(false);
        } catch (SQLException e) {
            LOG.error("Can't create connection");
        }
        LOG.info("Create connection end");
        return con;
    }

    public static void commit(Connection con) {
        try {
            if (con != null) {
                con.commit();
            }
        } catch (SQLException e) {
            LOG.error("Can't commit");
        }
    }

    public static void rollback(Connection con) {
        try {
            if (con != null) {
                con.rollback();
            }
        } catch (SQLException e) {
            LOG.error("Can't rollback");
        }
    }

    public static void closeCon(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            LOG.error("Can't close connection");
        }
    }

    public static void closeRs(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            LOG.error("Can't close ResultSet");
        }
    }

    public static void closeStat(Statement stat) {
        try {
            if (stat != null) {
                stat.close();
            }
        } catch (SQLException e) {
            LOG.error("Can't close Statement");
        }
    }
}
