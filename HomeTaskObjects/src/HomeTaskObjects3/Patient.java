package HomeTaskObjects3;

public class Patient {
	private int id;
	private String name;
	private String surname;
	private String patronymic;
	private String addres;
	private int phone;
	private int numberMecalCard;
	private String diagnosis;

	public Patient(int id, String name, String surname, String patronymic,
			String addres, int phone, int numberMecalCard, String diagnosis) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.patronymic = patronymic;
		this.addres = addres;
		this.phone = phone;
		this.numberMecalCard = numberMecalCard;
		this.diagnosis = diagnosis;
	}

	public Patient() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPatronymic() {
		return patronymic;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public int getNumberMecalCard() {
		return numberMecalCard;
	}

	public void setNumberMecalCard(int numberMecalCard) {
		this.numberMecalCard = numberMecalCard;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", surname=" + surname
				+ ", patronymic=" + patronymic + ", addres=" + addres
				+ ", phone=" + phone + ", numberMecalCard=" + numberMecalCard
				+ ", diagnosis=" + diagnosis + "]";
	}
}
