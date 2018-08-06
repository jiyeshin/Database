import java.util.*;
import java.util.stream.Stream;

public class StreamMain1 {

	public static void main(String[] args) {
		// 문자열 배열을 생성
		String[] ar = { "aaa", "bbb", "ccc" };

		// 문자열 리스트를 생성
		List<String> list = new ArrayList<>();
		list.add("ddd");
		list.add("eee");
		list.add("fff");
		list.add("ggg");
		
		//문자열 배열을 가지고 스트림 만들기
		Stream<String> str = Arrays.stream(ar);
		str.forEach(name->{System.out.println(name);}); //작업 수행
		System.out.println("==================");
		
		//List를 가지고 스트림 만들기
		str=list.stream();
		str.forEach(name->{System.out.println(name);}); 
		
	}

}
