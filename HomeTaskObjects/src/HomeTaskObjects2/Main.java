package HomeTaskObjects2;

public class Main {

	public static void main(String[] args) {
		Methods methods = new Methods();
		methods.addCustomer(new Customer(1, "Sasha", "Pupkin", "Egorovich",
				"Kharkiv,Lenina 1", 1234));
		methods.addCustomer(new Customer(2, "Vasua", "Dron", "Ivanovich",
				"Kiev,Svobodu 2", 1233));
		methods.addCustomer(new Customer(3, "Kola", "Koko", "Shanel",
				"Donetsk", 1224));
		methods.addCustomer(new Customer(4, "Dasha", "Petrova", "Nicolaevna",
				"Kharkiv , Lenina 23", 1442));
		// methods.showALL();
		// methods.alphabetCustomer();
		methods.numberCards(0, 1230);

	}
}
