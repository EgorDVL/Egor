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

	// список пациентов, имеющих данный диагноз;
	public ArrayList<Patient> diagnosis(String diagnosis) {
		ArrayList<Patient> p = new ArrayList<Patient>();
		for (Patient pat : patient) {
			if (pat.getDiagnosis().equals(diagnosis)) {
				p.add(pat);
			}
		}
		return p;
	}

	// список пациентов, номер медицинской карты которых находится в заданном
	// интервале.
	public ArrayList<Patient> numberMedicalCardsInterval(int from, int to) {
		ArrayList<Patient> p = new ArrayList<Patient>();
		for (Patient pat : patient) {
			if (pat.getNumberMecalCard() >= from
					&& pat.getNumberMecalCard() <= to) {
				p.add(pat);
			}
		}
		return p;
	}
}
