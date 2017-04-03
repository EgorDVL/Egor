package db;

import org.apache.log4j.Logger;

import java.lang.reflect.Proxy;
import java.sql.Connection;

/**
 * Created by Egor on 21.01.2017.
 */
public class TransactionProxyManager {

    private static final Logger LOGGER = Logger.getLogger(TransactionProxyManager.class);

    @SuppressWarnings(value = "unchecked")
    public static <T> T getTransactionalWrapper(Object object) {
        return (T) Proxy.newProxyInstance(object.getClass().getClassLoader(),
                object.getClass().getInterfaces(), (proxy, method, args) -> {
                    Connection con = DBManager.getConnection();
                    LOGGER.info("Invoke transaction handler. Connection isClosed: " + con.isClosed()
                            + ". Connection hashCode: " + con.hashCode());
                    T result = null;
                    try {
                        LOGGER.info("Begin of transaction executing");
                        result = (T) method.invoke(object, args);
                        DBManager.commit(con);
                        LOGGER.info("Transaction executed successfully");
                    } catch (Throwable th) {
                        DBManager.rollback(con);
                        LOGGER.error("Errors during executing transaction. Initiate rollback", th);
                        throw th;
                    } finally {
                        DBManager.closeCon(con);
                        LOGGER.info("Close connection");
                    }
                    return result;
                });
    }
}
