package bean.enams;

public enum PaymentMethod {
	CASH_PAYMENT, TRANSFER_TO_ACCOUNT;

	public static PaymentMethod getValue(String payment) {
		for (PaymentMethod paymentMethod : values()) {
			if (paymentMethod.toString().equalsIgnoreCase(payment)) {
				return paymentMethod;
			}
		}
		return null;
	}
}