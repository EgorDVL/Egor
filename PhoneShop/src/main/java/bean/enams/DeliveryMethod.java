package bean.enams;

public enum DeliveryMethod {
	PICKUP, NOVA_POSHTA;

	public static DeliveryMethod getValue(String delivery) {
		for (DeliveryMethod deliveryMethod : values()) {
			if (deliveryMethod.toString().equalsIgnoreCase(delivery)) {
				return deliveryMethod;
			}
		}
		return null;
	}
}
