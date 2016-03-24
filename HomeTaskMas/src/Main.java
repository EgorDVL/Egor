public class Main {

	public static void main(String[] args) {
		MethodsMas method = new MethodsMas();
		int mas[] = { 1001, 3332, 1111, 1234, 1223 };
		System.out.println(method.maxDigits(mas));
		System.out.println(method.minDigits(mas));
		System.out.println(method.increaseDegits(mas));
		System.out.println(method.evenNumbers(mas));

		String masF[] = { "132111", "232", "1212", "34323", "75768", "23",
				"1331", "122" };
		System.out.println(method.polindrom(masF));
		System.out.println(method.minAVG(masF));
		method.longANDsmallDigits(masF);
		System.out.println(method.maxLengthDigits(masF));
	}

}
