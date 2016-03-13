import java.util.ArrayList;

public class Methods{
	ArrayList<Student> students = new ArrayList<>();

	public void addStudents(Student t) {
		students.add(t);
	}

	public void showAll() {
		for (Student st : students) {
			System.out.println(st);
		}
	}

	public void studentsArrayFaculty(String faculty) {
		for (Student st : students) {
			if (st.getFaculty().equals(faculty)) {
				System.out.println(st);
			}
		}
	}

	public void arraysStudentAfterYear(int course) {
		for (Student st : students) {
			if (st.getCourse() > course) {
				System.out.println(st);
			}
		}
	}

	public void studentsArrayGroup(String group) {
		for (Student st : students) {
			if (st.getGroup().equals(group)) {
				System.out.println(st);
			}
		}
	}
}
