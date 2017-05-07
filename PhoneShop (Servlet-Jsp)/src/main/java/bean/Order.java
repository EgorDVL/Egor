package bean;

import bean.enams.DeliveryMethod;
import bean.enams.PaymentMethod;

public class Order {
	private int orderId;
	private String city;
	private String addres;
	private PaymentMethod paymentMethod;
	private DeliveryMethod deliveryMethod;
	private String comments;
	private int userId;

	public Order() {
		super();
	}

	public Order(String city, String addres, PaymentMethod paymentMethod,
			DeliveryMethod deliveryMethod, String comments, int userId) {
		super();
		this.city = city;
		this.addres = addres;
		this.paymentMethod = paymentMethod;
		this.deliveryMethod = deliveryMethod;
		this.comments = comments;
		this.userId = userId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
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

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public DeliveryMethod getDeliveryMethod() {
		return deliveryMethod;
	}

	public void setDeliveryMethod(DeliveryMethod deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", city=" + city + ", addres="
				+ addres + ", paymentMethod=" + paymentMethod
				+ ", deliveryMethod=" + deliveryMethod + ", comments="
				+ comments + ", userId=" + userId + "]";
	}
}
