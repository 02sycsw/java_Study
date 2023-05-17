import java.util.Scanner;

public class StudentManager {
	
    private static final int MAX_STUDENTS = 30;
    private static Student[] students = new Student[MAX_STUDENTS];
    private static int studentCount;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    searchStudent();
                    break;
                case 3:
                    modifyStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    displayAllStudents();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nStudent Management System:");
        System.out.println("1. Add Student");
        System.out.println("2. Search Student");
        System.out.println("3. Modify Student");
        System.out.println("4. Delete Student");
        System.out.println("5. Display All Students");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addStudent() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter major: ");
        String major = scanner.nextLine();
        System.out.print("Enter grade: ");
        int grade = scanner.nextInt();
        scanner.nextLine(); // Clear the buffer

        students[studentCount++] = new Student(name, studentId, major, grade);
        System.out.println("Student added successfully!");
    }

    private static void searchStudent() {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();

        for (Student student : students) {
        	try {
        		if(studentId.equals(student.getStudentId())) {
        			//단순 비교연산자로는 false가 나오기 때문에 equals 메소드 사용
             	   System.out.println(student);
             	   return;
        		}
        	}catch(NullPointerException e) {continue;}
        }
        System.out.println("Student not found.");
    }

	private static void modifyStudent() {
		System.out.print("Enter student ID: ");
		String studentId = scanner.nextLine();

		for (Student student : students) {
			try {
        		if(studentId.equals(student.getStudentId())) {
             	  System.out.println("before Modifiying | " + student);
             	               	  
             	  System.out.print("Enter new name: ");
            	  student.setName(scanner.nextLine());
             	  System.out.print("Enter new student ID: ");
             	  student.setStudentId(scanner.nextLine());
             	  System.out.print("Enter new major: ");
            	  student.setMajor(scanner.nextLine());
            	  System.out.print("Enter new grade: ");
            	  student.setGrade(scanner.nextInt());
             	  
             	  System.out.println("After Modifiying | " + student);
             	  return;
        		}
        	}catch(NullPointerException e) {continue;}
		}
		System.out.println("Student not found.");
	}

	private static void deleteStudent() {
		System.out.print("Enter student ID: ");
		String studentId = scanner.nextLine();

		for (int i = 0; i < studentCount; i++) {
			if(studentId.equals(students[i].getStudentId())) {				
				int j;
				for(j = i + 1; students[j] != null; j++) {
					students[j - 1] = students[j];
				}//지우려는 대상 이후에 있는 데이터를 한 칸씩 앞으로 옮겨준다. 
				
				students[j - 1] = null; //마지막 배열 null로 비워주기
				studentCount--; //학생 수 1명 줄이기
				System.out.println("The student's information has been deleted.");
				return;
			}
		}	
		System.out.println("Student not found.");
	}

	private static void displayAllStudents() {
		System.out.println("Student List:");
		for (int i = 0; i < studentCount; i++) {
			System.out.println((i + 1) + ". " + students[i].toString());
		}
	}
}
