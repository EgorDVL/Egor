package db.dao;

import db.dao.impl.*;

public final class DaoFactory {

    private DaoFactory() {
    }

    public static UserDAO getUserDAO() {
        return new UserDAOImpl();
    }

    public static CategoryDAO getCategoryDao() {
        return new CategoryDAOImpl();
    }

    public static CharacteristicDAO getCharacteristicDao() {
        return new CharacteristicDAOImpl();
    }

    public static DescriptionDAO getDescriptionDao() {
        return new DescriptionDAOImpl();
    }

    public static ManufacturerDAO getManufacturerDao() {
        return new ManufacturerDAOImpl();
    }

    public static OrderDAO getOrderDao() {
        return new OrderDAOImpl();
    }

    public static OrderedProductDAO getOrderedProductDao() {
        return new OrderedProductDAOImpl();
    }

    public static ProductDAO getProductDao() {
        return new ProductDAOImpl();
    }

    public static SubcategoryAccessoriesDAO getSubcategoryAccessoriesDao() {
        return new SubcategoryAccessoriesDAOImpl();
    }
}
