package Service;

import bean.Product;
import bean.Sales;
import bean.enams.DeliveryMethod;
import bean.enams.PaymentMethod;
import db.Basket;
import db.DBManager;
import db.dao.DaoFactory;
import db.dao.ProductDAO;
import db.dao.SalesDAO;
import org.apache.log4j.Logger;
import util.UpdateStoreException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Egor on 28.10.2016.
 */
public class CheckoutService {
    private static final Logger LOG = Logger.getLogger(CheckoutService.class);
    private ProductDAO productDAO = DaoFactory.getProductDao();
    private SalesDAO salesDAO = DaoFactory.getSalesDAO();

    public boolean basketCleaner(Basket basket, String email, String name, String surname, String phone, String city, String address, int house,
                                 DeliveryMethod deliveryMethod, PaymentMethod paymentMethod) {
        Connection con = DBManager.getConnection();
        Date currentDate = new Date();
        Map<Product, Integer> productMap = basket.getContains();
        for (Product p : productMap.keySet()) {
            try {
                Sales sales = new Sales(email, name, surname, phone, city, address,
                        house, deliveryMethod, paymentMethod, p.getProductId(), p.getPrice(), productMap.get(p), p.getPrice() * productMap.get(p), currentDate);
                salesDAO.createSales(sales, con);
                productDAO.updateProductCount(p.getProductId(), p.getCount() - productMap.get(p), con);
            } catch (SQLException e) {
                LOG.error("Can't update product and create sales");
                DBManager.rollback(con);
                throw new UpdateStoreException(e);
            }
        }
        DBManager.commit(con);
        DBManager.closeCon(con);
        return true;
    }

    public List<Sales> getAllSales() {
        Connection con = DBManager.getConnection();
        List<Sales> salesList = new ArrayList<>();
        try {
            salesList = salesDAO.getAllSales(con);
            DBManager.commit(con);
        } catch (SQLException e) {
            LOG.error("Can't get all sales in checkout service");
            DBManager.rollback(con);
        } finally {
            DBManager.closeCon(con);
        }
        return salesList;
    }
}
