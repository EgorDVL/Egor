import java.awt.Event;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Number_1 {
	public static void main(String[] args) {
		// int mas[] = { 1001, 3332, 1111, 1234, 1223 };
		// System.out.print(Arrays.toString(mas));
		// System.out.println();
		// System.out.println(maxDigits(mas)); // 7
		// System.out.println(minDigits(mas)); // 4
		// System.out.println(increaseDegits(mas)); // 6
		// System.out.print(evenNumbers(mas)); // 5

		String masF[] = { "132111", "232", "1212", "34323", "75768", "23",
				"1331", "122" };
		System.out.println();
		System.out.println(polindrom(masF));
		// System.out.println("������ ����� " +
		// Arrays.toString(minAVG(masF)));// 3

		// System.out.println(longANDsmallDigits(masF));// 1
		// System.out.println("���������� �� ����������� :"

		// + Arrays.toString(maxlengthDigits(masF)));// 2
		// System.out.println("���������� �� �������� :"

		// + Arrays.toString(minlengthDigits(masF)));// 2
	}

	// 8. ����� ����� ����� �����-���������. ���� ����� ����� ������ ������,
	// ����� ������.
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
			// System.out.println("�� ��������� : " + tmp);
			// }
			// }
		}
		return result;
	}

	// 7. ����� �����, ��������� ������ �� ��������� ����. ���� ����� ����� ��-
	// �������, ����� ������ �� ���.
	public static int maxDigits(int[] mas) {
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

	// 4. ����� �����, � ������� ����� ��������� ���� ����������. ���� �����
	// ����� ���������, ����� ������ �� ���.
	public static int minDigits(int[] mas) {
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

	// 6. ����� �����, ����� � ������� ���� � ������� ������� �����������. ����
	// ����� ����� ���������, ����� ������ �� ���.
	public static int increaseDegits(int[] mas) {
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

	// 5. ����� ���������� �����, ���������� ������ ������ �����, � ����� ���
	// ���������� ����� � ������ ������ ������ � �������� ����.
	public static int evenNumbers(int[] mas) {
		int result = 0;
		int counter = 0;
		for (int a = 0; a < mas.length; a++) {// ���������� ������� �����
												// counter
			if (mas[a] % 2 == 0) {
				counter++;
			}
		}
		int newArr[] = new int[counter];// ���������� � ����� ������
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
				int j = Character.digit(number.charAt(i), 10); // ������� �����
																// ����������
																// �������
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

	// �3 ������� �� ������� �� �����, ����� ������� ������ (������) �������,�
	// ����� �����.
	public static String[] minAVG(String[] masF) {
		int m = masF.length;
		int s = 0;
		for (int i = 0; i < masF.length; i++) {
			s = s + masF[i].length();
		}
		for (int j = 0; j < masF.length; j++) {
			if (masF[j].length() <= s / m) {
				System.out.println("����� ������ AVG :");
				System.out.println(masF[j] + " ");
			}
		}
		return masF;
	}

	// �2 ����������� � ������� ����� � ������� ����������� (��������) ��������
	// �� �����.
	public static String[] maxlengthDigits(String[] masF) {
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

	// �2 ����������� � ������� ����� � ������� ����������� (��������) ��������
	// �� �����.
	public static String[] minlengthDigits(String[] masF) {
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

	// �1 ����� ����� �������� � ����� ������� �����. ������� ��������� ����� �
	// �� �����
	public static String longANDsmallDigits(String[] masF) {
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
		System.out.println("������ ����� : " + longDigit.length());
		System.out.println("����� ������� c���� : " + longDigit);
		System.out.println("����� ����� : " + smallDigit.length());
		System.out.println("����� �������� ����� : " + smallDigit);
		return "";
	}
}
