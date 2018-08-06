
import java.util.*;

interface T{
	public void method(int n);
}

interface V{
	public int add(int n1, int n2);
}


public class LambdaMain {

	public static void main(String[] args) {
		V ob=(n1,  n2)->{
			return n1+n2;
		};
		System.out.println(ob.add(100, 3000));
		
		int []ar= {10,30,20};
		for(int temp : ar) {
			System.out.println(temp);
		}
		System.out.println("============================");
		
		
		 List<Integer> list = new ArrayList<>();
		list.add(30);
		list.add(70);
		for(int temp : list) {
			System.out.println(temp);
		}
		

		
	}
}
