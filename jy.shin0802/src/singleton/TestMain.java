package singleton;

public class TestMain {

	public static void main(String[] args) {
		/*T obj1=new T();
		T obj2=new T();*/
		
		//싱글톤 패턴을 적용할 클래스의 객체 만들기
		T obj1=T.getInstance();
		T obj2=T.getInstance();
		
		//System.out.println(obj1.hashCode()); 이거 말로 아래처럼 하는 것을 권장
		System.out.println(System.identityHashCode(obj1));
		System.out.println(System.identityHashCode(obj2));

		
		//아래 둘의 저장 공간은 같음(해시코드 같음). 상수는 한 번 만들어지면 계속 재사용
		int a=10;
		int b=10;
		System.out.println(System.identityHashCode(a));
		System.out.println(System.identityHashCode(b));
		
		
		
	}

}
