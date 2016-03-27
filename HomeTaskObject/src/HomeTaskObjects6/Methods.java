package HomeTaskObjects6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Methods {
	ArrayList<Phone> phone = new ArrayList<Phone>();

	public void addPhone(Phone p) {
		phone.add(p);
	}

	public void showAll() {
		for (Phone pho : phone) {
			System.out.println(pho);
		}
	}

	public void timeCity(int sec) {
		for (Phone ph : phone) {
			int pullseconds = ph.getTimeCity();
			int hours = pullseconds / 3600;
			int minutes = (pullseconds - (hours * 3600)) / 60;
			int seconds = (pullseconds - (hours * 3600) - (minutes * 60));
			System.out.println("hours :" + hours + " min :" + minutes
					+ " sec :" + seconds);
			if (pullseconds > sec) {
				System.out.println(ph);
			}
		}
	}

	public void timeIntercity() {
		for (Phone ph : phone) {
			int pullSeconds = ph.getTimeIntercity();
			if (pullSeconds > 0) {
				System.out.println(ph);
			}
		}
	}

	public List<Phone> phoneSort() {
		ArrayList<Phone> sortedPhone = new ArrayList<Phone>(phone);

		Collections.sort(sortedPhone, new Comparator<Phone>() {
			@Override
			public int compare(Phone o1, Phone o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		return sortedPhone;
	}
}
