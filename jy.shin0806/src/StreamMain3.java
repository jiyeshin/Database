import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamMain3 {

	public static void main(String[] args) {
		/*Student std = new Student();
		std.setName("가나다");
		std.setGender("남자");
		std.setAge(24);
		std.setSubject("유아교육과");
		std.setScore(100);
		
		Student student1=new Student("라마바사", "여자",22,"컴퓨터공학과",100);*/
		
		Student [] ar= new Student[5]; //Student 클래스의 인스턴스의 배열
		ar[0]=new Student("라마바사", "여자",100,"컴퓨터공학과",22);
		ar[1]=new Student("아자차", "남자",98,"컴퓨터공학과",45);
		ar[2]=new Student("타카파", "여자",80,"컴퓨터공학과",36);
		ar[3]=new Student("아바라", "여자",97,"산업디자인과",31);
		ar[4]=new Student("아아메", "남자",85,"국어교육과",19);
		
	/*	//성별이 남자인 데이터만 출력
		Stream <Student> str = Arrays.stream(ar);
		str.filter(student->student.getGender().equals("남자")).forEach(sss -> System.out.println(sss));
		
		
		//성별이 여자이고 나이가 30이상인 데이터만 출력
		Stream <Student> str = Arrays.stream(ar);
		str.filter(student->student.getGender().equals("여자") && student.getAge()>=30).forEach(sss -> System.out.println(sss));
		
		
		//Student를 score로 변경
		Stream<Student> stream = Arrays.stream(ar);
		stream.mapToInt(Student::getScore).forEach(student->System.out.println(student));
		*/
		
		int [] array= {30,20,35,100,70};
		IntStream  stream = Arrays.stream(array);
		stream.sorted().forEach(su->System.out.println(su));
		
		
		String [] insa = {"Morning", "Afternoon", "Evening", "Night"};
		Stream <String> s=Arrays.stream(insa);
		s.sorted((n1, n2)->n2.compareTo(n1)).forEach(su->System.out.println(su));
		
		//이름순으로 정렬(내림차순)
		Stream<Student> str = Arrays.stream(ar);
		str.sorted((n1,n2)->-(n1.getName().compareTo(n2.getName())))
		.forEach(student->System.out.println(student));

		
	}

}
