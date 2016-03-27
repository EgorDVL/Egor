package HomeTaskObjects6;

import java.util.Date;

public class Phone {
	private int id;
	private String name;
	private String surname;
	private String addres;
	private int numberCreditCard;
	private int debet;
	private int credit;
	private int timeCity;
	private int timeIntercity;

	public Phone(int id, String name, String surname, String addres,
			int numberCreditCard, int debet, int credit, int timeCity,
			int timeIntercity) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.addres = addres;
		this.numberCreditCard = numberCreditCard;
		this.debet = debet;
		this.credit = credit;
		this.timeCity = timeCity;
		this.timeIntercity = timeIntercity;
	}

	public Phone() {
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

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

	public int getNumberCreditCard() {
		return numberCreditCard;
	}

	public void setNumberCreditCard(int numberCreditCard) {
		this.numberCreditCard = numberCreditCard;
	}

	public int getDebet() {
		return debet;
	}

	public void setDebet(int debet) {
		this.debet = debet;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public int getTimeCity() {
		return timeCity;
	}

	public void setTimeCity(int timeCity) {
		this.timeCity = timeCity;
	}

	public int getTimeIntercity() {
		return timeIntercity;
	}

	public void setTimeIntercity(int timeIntercity) {
		this.timeIntercity = timeIntercity;
	}

	@Override
	public String toString() {
		return "Phone [id=" + id + ", name=" + name + ", surname=" + surname
				+ ", addres=" + addres + ", numberCreditCard="
				+ numberCreditCard + ", debet=" + debet + ", credit=" + credit
				+ ", timeCity=" + timeCity + ", timeIntercity=" + timeIntercity
				+ "]";
	}
}
