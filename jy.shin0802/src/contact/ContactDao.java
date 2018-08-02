package contact;

import java.util.List;

public interface ContactDao {
	public boolean insertContactTable(ContactTable ct); //데이터를 삽입하는 메소드
	public boolean updateContactTable(ContactTable ct); //데이터를 수정하는 메소드
	public boolean deleteContactTable(int num); //데이터를 삭제하는 메소드
	
	
	public List<ContactTable> allContactTable(); //데이터를 전체를 읽어오는 메소드
	//데이터가 0개 이상이거나 List로 리턴하고
	//읽어올 컬럼들을 저장할 DTO 클래스나 Map으로 제너릭을 적용하면 됨. 
	
	
	public List<ContactTable> nameContactTable(String name); //이름으로 조회하는 메소드
	//public  void numContactTable(int num); //번호로 조회하는 메소드. 참고로 번호는 primary key.

}
	
