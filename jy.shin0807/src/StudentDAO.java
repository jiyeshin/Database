import java.sql.*;
import java.util.*;

public class StudentDAO {
//StudentDAO 클래스에서 모든 데이터를 가져오는 메소드
	public List<StudentVO> fetch(){ //StudentDAO 클래스에서 모든 데이터를 가져오는 메소드
		//리턴할 리스트를 생성
		//List를 리턴해야 하는 경우에는 null을 리턴하지 않는것이 좋음.
		//List는 특별한 경우가 아니면 빠른 열거를 이용해서 접근하는데, 
		//null이면 NullPointerException 이 발생함.
		//null을 안 만들기 위해서 인스턴스를 생성해서 리턴함. 
		List<StudentVO> list = new ArrayList<>();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //드라이버 클래스 로드
			con=DriverManager.getConnection //DB 연결
					("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			
			pstmt=con.prepareStatement //sql 실행 객체 생성
			("select num, name, subject, score, age, gender from student");
			
			rs=pstmt.executeQuery(); //sql 실행
			
			while(rs.next()) {
				StudentVO vo=new StudentVO
						(rs.getString("num"), rs.getString("name"),rs.getString("subject"), 
								rs.getInt("score"),rs.getInt("age"), rs.getString("gender"));
				list.add(vo);
			}
			

		}catch(Exception e) {
			System.out.println("읽기 오류: "+e.getMessage()); //예외 내용을 확인하기 위해서
			e.printStackTrace(); //예외 위치를 알기 위해서
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(Exception e) {}
		}
		
		
		
	return list;
	
	}
	
	
	
	
}
