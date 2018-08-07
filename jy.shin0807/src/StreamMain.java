import java.util.*;
import java.util.stream.*;

public class StreamMain {

	public static void main(String[] args) {
		StudentDAO dao=new StudentDAO();
		List<StudentVO> list=dao.fetch();
		/*
		//System.out.println(list);
		//출력하는 메소드에 인스턴스 이름을 대입하면 toString의 결과가 나옴.
		for(StudentVO aaa : list) {
			System.out.println(aaa);
		}
*/
	//Stream 생성
		Stream<StudentVO> str = list.stream();
		//데이터를 2개 건너뛰고 3개 출력
		//str.skip(2).limit(3).forEach(data->System.out.println(data));
		
		//남자인 데이터만 출력
		//str.filter(data->data.getGender().equals("남자")).forEach(data->System.out.println(data));
		
		//score 순으로 데이터 정렬하기 (오름차순)
		//str.sorted((d1, d2)->d1.getScore()-d2.getScore()).forEach(data->System.out.println(data));
		
		//name 순으로 데이터 정렬하기 (오름차순)
		//str.sorted((d1, d2)->d1.getName().compareTo(d2.getName())).forEach(data->System.out.println(data));
		
		/*long cnt=str.count();
		System.out.println(cnt);*/
		
	/*	//Optional로 리턴되는 데이터는 한번 더 가공을 해야 함.
		StudentVO vo=str.findFirst().get();
		System.out.println(vo);
		*/
		
/*		
		//score의 합계 구하기
		//숫자 데이터가 아니면 바로 함꼐를 구할 수 없기 때문에 map메소드를 이용해서 숫자 데이터로 변경 후 합계를 구해야 함.
		int sum=str.mapToInt(StudentVO::getScore).sum();
		System.out.println("합계: "+sum);
		*/
		
		/*
		 * //age의 평균 구하기
		double age = str.mapToInt(StudentVO::getAge).average().getAsDouble();
		System.out.println("평균: "+age);
		*/
		
	/*	//성별이 남자인 데이터의 평균 점수를 구하는데 소수 1번째 자리에서 반올림해서 정수 부분만 출력.
		double avg = str.filter(data->data.getGender().equals("남자")).mapToInt(StudentVO::getScore).average().getAsDouble();
		int score = (int)(avg+0.5);
		System.out.println("남자 평균: "+score);
		*/
		
		/*
		 //성별이 여자인 데이터만 가지고 list 생성
		List<StudentVO>result = str.filter(data->data.getGender().equals("여자")).collect(Collectors.toList());
		for(StudentVO vo: result) {
		System.out.println(vo);}
		*/
		
		//이름과 점수만을 갖는 Map생성
		/*Map<String, Integer> map = str.collect(Collectors.toMap(StudentVO::getName, StudentVO::getScore));
		System.out.println(map);*/
		
		/*Map<String, Integer> map = str.collect(Collectors.toMap(StudentVO::getName, data->data.getScore()));
		System.out.println(map);*/
		
	/*
		//성별이 남자이고 score가 80 이상인 데이터의 list를 생성해서 출력
		List<StudentVO> result 
		= str.filter(data->data.getGender().equals("남자")&&data.getScore()>=80).collect(Collectors.toList());
		for(StudentVO vo: result) {
			System.out.println(vo);}*/
		
		//groupingBy에 작성한 함수의 결과를 key로 하고, 원래 데이터의 List를 값으로 해서 map으로 리턴
		/*Map<String, List<StudentVO>> map 
		= str.collect(Collectors.groupingBy(StudentVO::getGender));
		System.out.println(map);*/
		
		/*Map<String, IntSummaryStatistics> map
		=str.collect(Collectors.groupingBy(StudentVO::getGender, Collectors.summarizingInt(StudentVO::getScore)));
		System.out.println(map);*/
		
		//gender별로 score의 합계를 정수로 출력
		Map<String, Integer> map 
		= str.collect(Collectors.groupingBy(StudentVO::getGender, Collectors.summingInt(StudentVO::getScore)));
		System.out.println(map);
		
		//Map의 데이터 전부 출력하기
		Set<String> keySet = map.keySet();
		for(String key: keySet) {
			System.out.println(key+": "+map.get(key));
		}
	}

}
