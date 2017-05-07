package bean;

import bean.enams.DeliveryMethod;
import bean.enams.PaymentMethod;

import java.util.Date;

/**
 * Created by Egor on 30.10.2016.
 */
public class Sales {
    private int salesId;
    private String email;
    private String userName;
    private String userSurname;
    private String userPhone;
    private String userCity;
    private String userAddress;
    private int userHouse;
    private DeliveryMethod deliveryMethod;
    private PaymentMethod paymentMethod;
    private int productId;
    private int price;
    private int productCount;
    private int allPrice;
    private Date dateBuy;

    public Sales() {
    }

    public Sales(String email, String userName, String userSurname, String userPhone, String userCity, String userAddress, int userHouse,
                 DeliveryMethod deliveryMethod, PaymentMethod paymentMethod, int productId, int price, int productCount, int allPrice, Date dateBuy) {
        this.email = email;
        this.userName = userName;
        this.userSurname = userSurname;
        this.userPhone = userPhone;
        this.userCity = userCity;
        this.userAddress = userAddress;
        this.userHouse = userHouse;
        this.deliveryMethod = deliveryMethod;
        this.paymentMethod = paymentMethod;
        this.productId = productId;
        this.price = price;
        this.productCount = productCount;
        this.allPrice = allPrice;
        this.dateBuy = dateBuy;
    }

    public int getSalesId() {
        return salesId;
    }

    public void setSalesId(int salesId) {
        this.salesId = salesId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public int getUserHouse() {
        return userHouse;
    }

    public void setUserHouse(int userHouse) {
        this.userHouse = userHouse;
    }

    public DeliveryMethod getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(DeliveryMethod deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public int getAllPrice() {
        return allPrice;
    }

    public void setAllPrice(int allPrice) {
        this.allPrice = allPrice;
    }

    public Date getDateBuy() {
        return dateBuy;
    }

    public void setDateBuy(Date dateBuy) {
        this.dateBuy = dateBuy;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "salesId=" + salesId +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", userSurname='" + userSurname + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userCity='" + userCity + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userHouse=" + userHouse +
                ", deliveryMethod=" + deliveryMethod +
                ", paymentMethod=" + paymentMethod +
                ", productId=" + productId +
                ", price=" + price +
                ", productCount=" + productCount +
                ", allPrice=" + allPrice +
                ", dateBuy=" + dateBuy +
                '}';
    }
}
