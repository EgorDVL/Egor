package HomeTaskObjects4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Methods {
	ArrayList<Abiturient> abiturient = new ArrayList<Abiturient>();

	public void addAbiturients(Abiturient a) {
		abiturient.add(a);
	}

	public void showAll() {
		for (Abiturient abit : abiturient) {
			System.out.println(abit);
		}
	}

	// список абитуриентов, имеющих неудовлетворительные оценки;
	public ArrayList<Abiturient> badMarks(int fatalmark) {
		ArrayList<Abiturient> ab = new ArrayList<Abiturient>();
		for (Abiturient abi : abiturient) {
			for (int ma : abi.getMarks()) {
				if (ma < fatalmark) {
					ab.add(abi);
				}
			}
		}
		return ab;
	}

	// список абитуриентов, у которых сумма баллов выше заданной;
	public ArrayList<Abiturient> sumMarks(int specialMark) {
		ArrayList<Abiturient> ab = new ArrayList<Abiturient>();
		for (Abiturient abi : abiturient) {
			int sum = 0;
			for (int ma : abi.getMarks()) {
				sum += ma;
				if (sum > specialMark) {
					ab.add(abi);
				}
			}
		}
		return ab;
	}

	// выбрать заданное число n абитуриентов, имеющих самую высокую сумму баллов
	public List<Abiturient> goodAbiturientsMarks(int fewBetterAbiturients) {
		Collections.sort(abiturient, new Comparator<Abiturient>() {
			@Override
			public int compare(Abiturient o1, Abiturient o2) {
				return sumMarks(o2) - sumMarks(o1);
			}

			private int sumMarks(Abiturient abit) {
				int sum = 0;
				for (int mark : abit.getMarks()) {
					sum += mark;
				}
				return sum;
			}
		});
		return abiturient.subList(0, fewBetterAbiturients);
	}
}
