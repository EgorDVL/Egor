package HomeTaskObjects3;

import java.util.ArrayList;

public class Methods {
	ArrayList<Patient> patient = new ArrayList<Patient>();

	public void addPatient(Patient p) {
		patient.add(p);
	}

	public void showAll() {
		for (Patient pat : patient) {
			System.out.println(pat);
		}
	}

	public void diagnosis(String diagnosis) {
		for (Patient pat : patient) {
			if (pat.getDiagnosis().equals(diagnosis)) {
				System.out.println(pat);
			}
		}
	}

	public void numberMedicalCardsInterval(int from, int to) {
		for (Patient pat : patient) {
			if (pat.getNumberMecalCard() >= from
					&& pat.getNumberMecalCard() <= to) {
				System.out.println(pat);
			}
		}
	}
}
