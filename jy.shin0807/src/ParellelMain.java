import java.util.Arrays;
import java.util.stream.IntStream;

public class ParellelMain {

	//1초 대기하는 메소드
	public static void work(int a) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		int [] ar= {20,30,20,10,30,20,20,30,10,20};
			
		//일반 스트림으로 work작업을 수행
		IntStream str = Arrays.stream(ar);
		long start=System.currentTimeMillis();
		str.forEach(su->work(su));
		long end = System.currentTimeMillis();
		System.out.println(end-start);
		
		
		//병렬 스트림으로 work작업을 수행
		str = Arrays.stream(ar);
		start=System.currentTimeMillis();
		str.parallel().forEach(su->work(su));
		end = System.currentTimeMillis();
		System.out.println(end-start);
		
		}

	}


