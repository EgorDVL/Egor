import java.awt.Event;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MethodsMas {

	// 8. Среди чисел найти число-палиндром. Если таких чисел больше одного,
	// найти второе.
	public static String polindrom(String[] masF) {
		String result = "";
		int counter = 0;
		for (String tmp : masF) {
			StringBuilder sb = new StringBuilder(tmp);
			if (tmp.equals(sb.reverse().toString())) {
				result = tmp;
				counter++;
			}
			if (counter == 2) {
				return result;
			}
			// for (int i = 0; i < tmp.length() / 2; i++) {
			// if (tmp.charAt(i) != tmp.charAt(tmp.length() - i - 1)) {
			// System.out.println(tmp);
			// }
			// }
		}
		return result;
	}

	// 7. Найти число, состоящее только из различных цифр. Если таких чисел не-
	// сколько, найти первое из них.
	public int maxDigits(int[] mas) {
		int result = 0;
		int maxCounter = Integer.MIN_VALUE;

		for (int tmp : mas) {
			String number = String.valueOf(tmp);
			char[] chArr = number.toCharArray();
			int counterRepit = 0;
			for (int i = 0; i < chArr.length; i++) {
				char a = chArr[i];
				for (int j = i + 1; j < chArr.length; j++) {
					if (chArr[j] != a) {
						counterRepit++;
					}
				}
			}
			if (counterRepit > maxCounter) {
				maxCounter = counterRepit;
				result = tmp;
			}
		}
		return result;
	}

	// 4. Найти число, в котором число различных цифр минимально. Если таких
	// чисел несколько, найти первое из них.
	public int minDigits(int[] mas) {
		int minCounter = Integer.MIN_VALUE;
		int result = 0;
		for (int tmp : mas) {
			String number = String.valueOf(tmp);
			char[] chArr = number.toCharArray();
			int counterRepit = 0;
			for (int i = 0; i < chArr.length; i++) {
				char k = chArr[i];
				for (int j = i + 1; j < chArr.length; j++) {
					if (chArr[j] == k) {
						counterRepit++;
					}
				}
			}
			if (counterRepit > minCounter) {
				minCounter = counterRepit;
				result = tmp;
			}
		}
		return result;
	}

	// 6. Найти число, цифры в котором идут в строгом порядке возрастания. Если
	// таких чисел несколько, найти первое из них.
	public int increaseDegits(int[] mas) {
		int result = 0;
		for (int tmp : mas) {
			boolean flag = true;
			String number = String.valueOf(tmp);
			char[] chArr = number.toCharArray();
			for (int i = 0, b = 1; b < chArr.length; i++, b++) {
				if (chArr[i] != chArr[b] - 1) {
					flag = false;
				}
			}
			if (flag) {
				result = tmp;
				break;
			}
		}
		return result;
	}

	// 5. Найти количество чисел, содержащих только четные цифры, а среди них —
	// количество чисел с равным числом четных и нечетных цифр
	public int evenNumbers(int[] mas) {
		int result = 0;
		int counter = 0;
		for (int a = 0; a < mas.length; a++) {
			if (mas[a] % 2 == 0) {
				counter++;
			}
		}
		int newArr[] = new int[counter];
		for (int e = 0, f = 0; e < mas.length; e++) {
			if (mas[e] % 2 == 0) {
				newArr[f++] = mas[e];
			}
		}
		System.out.println(Arrays.toString(newArr));

		for (int tmp : newArr) {
			String number = String.valueOf(tmp);
			int counterNO = 0;
			int counterYES = 0;
			for (int i = 0; i < number.length(); i++) {
				int j = Character.digit(number.charAt(i), 10);
				if (j % 2 != 0) {
					counterNO++;
				}
				if (j % 2 == 0) {
					counterYES++;
				}
			}
			if (counterNO == counterYES) {
				result = tmp;
			}
		}
		return result;
	}

	// 3 Вывести на консоль те числа, длина которых меньше (больше) средней,
	// а также длину.
	public ArrayList<String> minAVG(String[] masF) {
		ArrayList<String> arr = new ArrayList<String>();
		int m = masF.length;
		int s = 0;
		for (int i = 0; i < masF.length; i++) {
			s = s + masF[i].length();
		}
		for (int j = 0; j < masF.length; j++) {
			if (masF[j].length() <= s / m) {
				arr.add(masF[j]);
				System.out.println(" AVG :");
			}
		}
		return arr;
	}

	// 2 Упорядочить и вывести числа в порядке возрастания (убывания) значений
	// их длины.
	public String[] maxLengthDigits(String[] masF) {
		for (int i = masF.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (masF[j].length() > masF[j + 1].length()) {
					String arr = masF[j + 1];
					masF[j + 1] = masF[j];
					masF[j] = arr;
				}
			}
		}
		return masF;
	}

	// 2 Упорядочить и вывести числа в порядке возрастания (убывания) значений
	// их длины.
	public String[] minLengthDigits(String[] masF) {
		for (int k = masF.length - 1; k > 0; k--) {
			for (int b = 0; b < k; b++) {
				if (masF[b].length() < masF[b + 1].length()) {
					String arr1 = masF[b];
					masF[b] = masF[b + 1];
					masF[b + 1] = arr1;
				}
			}
		}
		return masF;
	}

	// 1.Найти самое короткое и самое длинное число. Вывести найденные числа и
	// их длину.
	public void longANDsmallDigits(String[] masF) {
		String longDigit = masF[0];
		String smallDigit = masF[0];
		for (int i = 0; i < masF.length; i++) {
			if (longDigit.length() < masF[i].length()) {
				longDigit = masF[i];
			}
			if (smallDigit.length() > masF[i].length()) {
				smallDigit = masF[i];
			}
		}
		System.out.println("longDigit : " + longDigit.length());
		System.out.println(longDigit);
		System.out.println("smallDigit " + smallDigit.length());
		System.out.println(smallDigit);
	}
}
