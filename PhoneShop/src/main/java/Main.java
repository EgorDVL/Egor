import bean.*;
import bean.enams.*;
import db.DBManager;
import db.dao.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by Egor on 23.09.2016.
 */
public class Main {

    public static void main(String[] args) {
//        Connection con = DBManager.getConnection();
//        Date currentDate = new Date();
//        Sales sales = new Sales("SSS@gmail.com", "Fff", "FSF", "+380507070123", "Kiev",
//                "dffefef", 11, DeliveryMethod.PICKUP, PaymentMethod.CASH_PAYMENT, 1, 500, 2, 1000, currentDate);

//        User user = new User("Vasua@gmail.com", "1111", "Egor", "Zhyzhko", 0507070342, 1);
//        Category category = new Category(CategoryEnam.PHONE, 0);
//        Characteristic characteristic = new Characteristic("green", 12, 4.56, "Intel dual" , 8.43 , 5.6 , 13);
//        Description description = new Description("trololo lo lala lslsls");
//        Manufacturer manufacturer = new Manufacturer(ManufacturerEnam.LG);
//        Order order = new Order("Kharkiv", "Lenina str 23", PaymentMethod.CASH_PAYMENT, DeliveryMethod.PICKUP, "norm phone", 2);
//        OrderedProduct orderedProduct = new OrderedProduct(3, 3);
//        SubcategoryAccessories subcategoryAccessories = new SubcategoryAccessories(SubCategoryAccessory.COVERS);
//        Product product = new Product("iphone 7s", 800, 22, 1, 1, 1, 1);
//        try {
//            System.out.println(DaoFactory.getSalesDAO().getAllSales(con));
//            DaoFactory.getSalesDAO().createSales(sales, con);
//            Product
//            DaoFactory.getProductDao().createProduct(product,con);
//            System.out.println(DaoFactory.getProductDao().getProductById(1,con));
//            System.out.println(DaoFactory.getProductDao().getAllProduct(con));

//            SubCategoryAccessory
//            DaoFactory.getSubcategoryAccessoriesDao().createSubCategoryAccessories(subcategoryAccessories,con);
//            System.out.println(DaoFactory.getSubcategoryAccessoriesDao().getSubCategoryAccessoriesById(1,con));
//            System.out.println(DaoFactory.getSubcategoryAccessoriesDao().getAllSubcategoryAccessories(con));

//            OrderedProduct
//            DaoFactory.getOrderedProductDao().createOrderProduct(orderedProduct,con);
//            System.out.println(DaoFactory.getOrderedProductDao().getOrderProductById(1,con));
//            System.out.println(DaoFactory.getOrderedProductDao().getAllOrderProduct(con));

//            Order
//            DaoFactory.getOrderDao().createOrder(order,con);
//            System.out.println(DaoFactory.getOrderDao().getOrderById(1,con));
//            System.out.println(DaoFactory.getOrderDao().getAllOrder(con));

//            Manufacturer
//            DaoFactory.getManufacturerDao().createManufacturer(manufacturer,con);
//            System.out.println(DaoFactory.getManufacturerDao().getManufacturerById(1, con));
//            System.out.println(DaoFactory.getManufacturerDao().getAllManufacturer(con));

//            Description
//            DaoFactory.getDescriptionDao().createDescription(description,con);
//            System.out.println(DaoFactory.getDescriptionDao().getDescriptionById(1, con));
//            System.out.println(DaoFactory.getDescriptionDao().getAllDescription(con));

//            Characteristic
//            DaoFactory.getCharacteristicDao().createCharacteristic(characteristic,con);
//            System.out.println(DaoFactory.getCharacteristicDao().getCharacteristicById(1,con));
//            System.out.println(DaoFactory.getCharacteristicDao().getAllCharacteristic(con));


//            Category
//            DaoFactory.getCategoryDao().createCategory(category, con);
//            System.out.println(DaoFactory.getCategoryDao().getCategoryById(1, con));
//            System.out.println(DaoFactory.getCategoryDao().getAllCategory(con));

//            User
//            System.out.println(DaoFactory.getUserDAO().getUserById(1, con));
//            DaoFactory.getUserDAO().createUser(user, con);
//            System.out.println(DaoFactory.getUserDAO().getUserByEmail("user@gmail.com", con));
//            System.out.println(DaoFactory.getUserDAO().getAllUsers(con));

//            DBManager.commit(con);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}
