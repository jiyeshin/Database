package contact;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

public class ContactMain {

	public static void main(String[] args) {
		//인터페이스나 클래스를 상속한 경우에는 
		//상위 인터페이스나 클래스 이름으로 변수를 만들고
		//하위 클래스의 인스턴스를 생성해서 대입
		ContactDao dao=new ContactDaoImpl();
		
		/*ContactTable contact=new ContactTable();
		contact.setNum(1);
		contact.setName("아메리");
		contact.setPhone("010-9876-5432");
		contact.setEmail("aaaa@naver.com");
		Calendar cal=Calendar.getInstance();
		cal.set(Calendar.YEAR, 1995);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.DAY_OF_MONTH, 10);
		Date birthday= new Date(cal.getTimeInMillis());
		contact.setBday(birthday);
		
		boolean result=dao.deleteContactTable(6);
		if(result==true) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}*/

	/*	List<ContactTable> list = dao.nameContactTable("아");
		for(ContactTable contact:list) {
			System.out.println(contact);
		}*/
		
		new ContactView();
		
		

	}

}
