package HomeTaskObjects2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Methods {
	ArrayList<Customer> customer = new ArrayList<Customer>();

	public void addCustomer(Customer c) {
		customer.add(c);
	}

	public void showALL() {
		for (Customer cus : customer) {
			System.out.println(cus);
		}
	}

	// список покупателей в алфавитном порядке;
	public void alphabetCustomer() {
		Collections.sort(customer, new Comparator<Customer>() {
			@Override
			public int compare(Customer o1, Customer o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		for (Customer cus : customer) {
			System.out.println(cus);
		}
	}

	// список покупателей, у которых номер кредитной карточки находится в
	// заданном интервале.
	public ArrayList<Customer> numberCards(int from, int to) {
		ArrayList<Customer> cust = new ArrayList<Customer>();
		for (Customer cus : customer) {
			if (cus.getCreditCardNumber() >= from
					&& cus.getCreditCardNumber() <= to) {
				cust.add(cus);
			}
		}
		return cust;
	}
}
