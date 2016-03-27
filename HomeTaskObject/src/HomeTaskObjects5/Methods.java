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
	public ArrayList<House> allRoomCounter(int countRoom) {
		ArrayList<House> h = new ArrayList<House>();
		for (House ho : house) {
			if (ho.getRoomCounter() == countRoom) {
				h.add(ho);
			}
		}
		return h;
	}

	// список квартир, имеющих заданное число комнат и расположенных
	// на этаже, который находится в заданном промежутке
	public ArrayList<House> flats(int countRoom, int from, int to) {
		ArrayList<House> h = new ArrayList<House>();
		for (House ho : house) {
			if (ho.getRoomCounter() == countRoom) {
				if (ho.getFloar() >= from && ho.getFloar() <= to) {
					h.add(ho);
				}
			}
		}
		return h;
	}

	// список квартир, имеющих площадь, превосходящую заданную
	public ArrayList<House> biggerSquare(int square) {
		ArrayList<House> h = new ArrayList<House>();
		for (House ho : house) {
			if (ho.getSquare() > square) {
				h.add(ho);
			}
		}
		return h;
	}
}
