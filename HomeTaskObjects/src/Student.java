public class Student {
	private int id;
	private String name;
	private String surName;
	private long phone;
	private String address;
	private String faculty;
	private int course;
	private String group;

	public Student(int id, String name, String surName, long phone,
			String address, String faculty, int course, String group) {
		super();
		this.id = id;
		this.name = name;
		this.surName = surName;
		this.phone = phone;
		this.address = address;
		this.faculty = faculty;
		this.course = course;
		this.group = group;
	}

	public Student() {
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

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public int getCourse() {
		return course;
	}

	public void setCourse(int course) {
		this.course = course;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", surName=" + surName
				+ ", phone=" + phone + ", address=" + address + ", faculty="
				+ faculty + ", course=" + course + ", group=" + group + "]";
	}
}
