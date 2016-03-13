public class Main {

	public static void main(String[] args) {
		Methods methods = new Methods();

		methods.addStudents(new Student(1, "Vasua", "Pupkin", 507070342,
				"Kharkiv,Lenina 4", "PMM", 4, "Inf-12-2"));
		methods.addStudents(new Student(2, "Egor", "Zhyzhko", 534232342,
				"Slavansk,Vasilevskogo 12", "PMM", 3, "Inf-13-2"));
		methods.addStudents(new Student(3, "Andrew", "Hodika", 556456456,
				"Kharkiv,Lenina 25", "RT", 5, "Rt-11-1"));
		methods.addStudents(new Student(4, "Dima", "Zhyrba", 522223344,
				"Slavansk,Batuka 5", "EC", 1, "IEc-09-2"));
		methods.addStudents(new Student(5, "Petya", "Pupok", 557645773,
				"Kharkiv,Lenina 1", "PMM", 4, "Inf-12-2"));
		 methods.showAll();
		// methods.studentsArrayFaculty("PMM");
		// methods.arraysStudentAfterYear(3);
		// methods.studentsArrayGroup("Inf-12-2");

	}
}
