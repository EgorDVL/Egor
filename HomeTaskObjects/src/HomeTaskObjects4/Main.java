package HomeTaskObjects4;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Methods methods = new Methods();
		methods.addAbiturients(new Abiturient(1, "Vasua", "Pupkin",
				"Kharkiv,Lenina 2", 507070342, new ArrayList<Integer>(Arrays
						.asList(60, 75, 90))));
		methods.addAbiturients(new Abiturient(2, "Egor", "Zhyzhko",
				"Kharkiv,Svobody 5", 507073453, new ArrayList<Integer>(Arrays
						.asList(66, 76, 98))));

		methods.addAbiturients(new Abiturient(3, "Dima", "Zhyrba",
				"Slaviansk,Batuka 43", 660342323, new ArrayList<Integer>(Arrays
						.asList(61, 66, 80))));

		methods.addAbiturients(new Abiturient(4, "Andrey", "Hoduka",
				"Kharkiv,Asharova 18", 506063423, new ArrayList<Integer>(Arrays
						.asList(75, 85, 100))));

		methods.showAll();
		methods.badMarks(61);
		methods.sumMarks(230);
		System.out.println(methods.goodAbiturientsMarks(2));
	}
}
