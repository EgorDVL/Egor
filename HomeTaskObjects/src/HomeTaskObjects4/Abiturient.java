package HomeTaskObjects4;

import java.util.ArrayList;

public class Abiturient {
	private int id;
	private String name;
	private String surname;
	private String addres;
	private int phone;
	ArrayList<Integer> marks;

	public Abiturient(int id, String name, String surname, String addres,
			int phone, ArrayList<Integer> marks) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.addres = addres;
		this.phone = phone;
		this.marks = marks;
	}

	public Abiturient() {
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

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public ArrayList<Integer> getMarks() {
		return marks;
	}

	public void setMarks(ArrayList<Integer> marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Abiturient [id=" + id + ", name=" + name + ", surname="
				+ surname + ", addres=" + addres + ", phone=" + phone
				+ ", marks=" + marks + "]";
	}
}
