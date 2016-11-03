package web.form;

import bean.enams.DeliveryMethod;
import bean.enams.PaymentMethod;

/**
 * Created by Egor on 28.10.2016.
 */
public class CheckoutForm {
    private String email;
    private String name;
    private String surname;
    private String phone;
    private String city;
    private String addres;
    private int house;
    private DeliveryMethod deliveryMethod;
    private PaymentMethod paymentMethod;

    public CheckoutForm() {
    }

    public CheckoutForm(String email, String name, String surname, String phone,
                        String city, String addres, int house, DeliveryMethod deliveryMethod,
                        PaymentMethod paymentMethod) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.city = city;
        this.addres = addres;
        this.house = house;
        this.deliveryMethod = deliveryMethod;
        this.paymentMethod = paymentMethod;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
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

    @Override
    public String toString() {
        return "CheckoutForm{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", city='" + city + '\'' +
                ", addres='" + addres + '\'' +
                ", house=" + house +
                ", deliveryMethod=" + deliveryMethod +
                ", paymentMethod=" + paymentMethod +
                '}';
    }
}
