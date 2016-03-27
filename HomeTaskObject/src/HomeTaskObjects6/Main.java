package HomeTaskObjects6;

public class Main {

	public static void main(String[] args) {
		Methods methods = new Methods();
		methods.addPhone(new Phone(1, "Vasua", "Pupkin", "Kharkiv, Lenina 2",
				1234, 100, 100, 5000, 1235));
		methods.addPhone(new Phone(2, "Egor", "Zhyzhko", "Kharkiv,Nova 23",
				1233, 150, 170, 500, 0));
		methods.addPhone(new Phone(3, "Andrew", "Hoduka", "Kharkiv,Svobody 5",
				1223, 25, 300, 65, 2322));
		methods.addPhone(new Phone(4, "Dima", "Zhyrba", "Slaviansks,Batuka 76",
				1423, 500, 15, 8002, 1504));
		// methods.showAll();
		// methods.timeCity(6000);
		// methods.timeIntercity();
		methods.phoneSort();
	}

}
