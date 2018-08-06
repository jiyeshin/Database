import java.util.*;
import java.util.stream.Stream;

public class StreamMain2 {

	public static void main(String[] args) {
		List <String> list = new ArrayList<>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		list.add("ddd");
		list.add("eee");
		list.add("fff");
		list.add("ggg");
		list.add("hhh");
		list.add("iii");
		list.add("jjj");
		list.add("aaa");
		
		
		
		
		Stream <String >st=list.stream(); //스트림 변환
		/*
		//st.forEach(name->{System.out.println(name);}); //모든 데이터 출력
	
		st.distinct().skip(2).limit(3).forEach(name->{System.out.println(name);}); // 중복 제거
		
*/
		//a로 시작하는 데이터만 찾아서 출력
		//return 문장 하나밖에 없을 때는 return이라는 단어를 생략가능
		//수행되는 코드가 한 줄일 때는 {} 생략 가능
		//st.filter(name->name.startsWith("a")).forEach(name->System.out.println(name));
		st.filter(name->name.length()!=3).forEach(name->System.out.println(name));
	}

}
