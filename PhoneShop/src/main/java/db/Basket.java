package db;

import bean.Product;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Egor on 26.10.2016.
 */
public class Basket {
    private Map<Product, Integer> productMap;
    private double totalPrice = 0.0;

    public Basket() {
        this.productMap = new HashMap<>();
    }

    public Map<Product, Integer> getContains() {
        return productMap;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void addProduct(Product product) {
        totalPrice += product.getPrice();
        if (productMap.containsKey(product)) {
            Integer currentCount = productMap.get(product);
            productMap.put(product, ++currentCount);
        } else {
            productMap.put(product, 1);
        }
    }

    public boolean removeProduct(Product product) {
        if (product != null) {
            totalPrice -= (product.getPrice() * productMap.get(product));
            productMap.remove(product);
            return true;
        }
        return false;
    }
}