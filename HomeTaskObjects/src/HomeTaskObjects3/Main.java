package HomeTaskObjects3;

public class Main {

	public static void main(String[] args) {
		Methods method = new Methods();
		method.addPatient(new Patient(1, "Egor", "Zhyzhko", "Dmitrievich",
				"Kharkiv, Lenina 23", 507070342, 1111, "Adiposity"));
		method.addPatient(new Patient(2, "Dima", "Zhyrba", "Sergeevich",
				"Slaviansk,Batyka 54", 505040025, 2222, "Stupid bitch"));
		method.addPatient(new Patient(3, "Vasua", "Pupok", "Piskovich",
				"Kiev,Svobody 2", 990002221, 3333, "Hemorrhoids"));
		method.addPatient(new Patient(4, "Trol", "Trololo", "Lolovich",
				"Kharkiv,Bakulina 12", 672135402, 4444, "ORZ"));
		// method.showAll();
		// method.diagnosis("ORZ");
		method.numberMedicalCardsInterval(1000, 2300);
	}
}
