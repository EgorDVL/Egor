package HomeTaskObjects2;

public class Customer {
	private int id;
	private String name;
	private String surname;
	private String patronymic;
	private String addres;
	private int creditCardNumber;

	public Customer(int id, String name, String surname, String patronymic,
			String addres, int creditCardNumber) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.patronymic = patronymic;
		this.addres = addres;
		this.creditCardNumber = creditCardNumber;
	}

	public Customer() {
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

	public int getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(int creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", surname=" + surname
				+ ", patronymic=" + patronymic + ", addres=" + addres
				+ ", creditCardNumber=" + creditCardNumber + "]";
	}
}
