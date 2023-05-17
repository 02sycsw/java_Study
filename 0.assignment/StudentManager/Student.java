public class Student {
    private String name;
    private String studentId;
    private String major;
    private int grade;
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

    public Student(String name, String studentId, String major, int grade) {
        this.name = name;
        this.studentId = studentId;
        this.major = major;
        this.grade = grade;
    }
    
    public String toString() {
    	 String info = "Name: " + this.name + ", studentId: " + this.studentId + ", Major:" + this.major +
    			 ", Grade: " + this.grade;
    	 return info;
    }
}