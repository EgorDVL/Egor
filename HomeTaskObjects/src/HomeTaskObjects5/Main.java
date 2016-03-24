package HomeTaskObjects5;

public class Main {

	public static void main(String[] args) {
		Methods methods = new Methods();
		methods.addHouse(new House(1, 12, 35, 4, 1, "Lenina 2", "Novostroy",
				100));
		methods.addHouse(new House(2, 35, 70, 6, 3, "Nova 23", "Novostroy", 150));
		methods.addHouse(new House(3, 54, 60, 2, 2, "Batuka 53", "Stalinka",
				200));
		methods.addHouse(new House(4, 2, 28, 6, 1, "Pobedu 1", "Hrushevka", 70));
		methods.addHouse(new House(5, 59, 45, 12, 2, "Nauchnaia 33",
				"Hrushevka", 70));
		methods.showAll();
		methods.allRoomCounter(1);
		methods.flats(2, 2, 10);
		methods.biggerSquare(30);
	}

}
