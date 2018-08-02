package singleton;

public class T {
	//외부에서 객체를 생성하지 못하도록 생성자를 private로 변경 
	//main에서 T obj2=new T(); 는 에러가 됨.
	private T() {}
	
	//1개만 만들어서 리턴해주기 위한 static변수 선언
	private static T obj;
	
	//객체가 없으면 만들어서 리턴하고, 있으면 그냥 리턴하는 static 메소드를 생성
	public static T getInstance() {
		if(obj==null) {
			obj=new T();
		}
		return obj;
	}
	
	
}
