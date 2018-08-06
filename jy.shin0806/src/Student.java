
public class Student {
	private String name;
	private String gender;
	private int score;
	private String subject;
	private int age;
	

	public Student(String name, String gender, int score, String subject, int age) {
		super();
		this.name = name;
		this.gender = gender;
		this.score = score;
		this.subject = subject;
		this.age = age;
	}
	public Student() {
		// 상위 클래스의 생성자를 호출하는 구문: new Object()
		super();
	}
	
	
	
	
	
	
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", gender=" + gender + ", score=" + score + ", subject=" + subject + ", age="
				+ age + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
