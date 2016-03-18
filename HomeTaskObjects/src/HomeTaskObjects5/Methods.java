package HomeTaskObjects5;

import java.util.ArrayList;

public class Methods {
	ArrayList<House> house = new ArrayList<House>();

	public void addHouse(House h) {
		house.add(h);
	}

	public void showAll() {
		for (House hou : house) {
			System.out.println(hou);
		}
	}

	// список квартир, имеющих заданное число комнат
	public void allRoomCounter(int countRoom) {
		for (House ho : house) {
			if (ho.getRoomCounter() == countRoom) {
				System.out.println(ho);
			}
		}
	}

	// список квартир, имеющих заданное число комнат и расположенных
	// на этаже, который находится в заданном промежутке
	public void flats(int countRoom, int from, int to) {
		for (House ho : house) {
			if (ho.getRoomCounter() == countRoom) {
				if (ho.getFloar() >= from && ho.getFloar() <= to) {
					System.out.println(ho);
				}
			}
		}
	}

	// список квартир, имеющих площадь, превосходящую заданную
	public void biggerSquare(int square) {
		for (House ho : house) {
			if (ho.getSquare() > square) {
				System.out.println(ho);
			}
		}
	}
}
