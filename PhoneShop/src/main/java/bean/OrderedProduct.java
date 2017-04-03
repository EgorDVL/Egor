package bean;

public class OrderedProduct {
	private int orderedProductId;
	private int orderId;
	private int productId;

	public OrderedProduct() {
		super();
	}

	public OrderedProduct(int orderId, int productId) {
		super();
		this.orderId = orderId;
		this.productId = productId;
	}

	public int getOrderedProductId() {
		return orderedProductId;
	}

	public void setOrderedProductId(int orderedProductId) {
		this.orderedProductId = orderedProductId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "OrderedProduct [orderedProductId=" + orderedProductId
				+ ", orderId=" + orderId + ", productId=" + productId + "]";
	}
}
