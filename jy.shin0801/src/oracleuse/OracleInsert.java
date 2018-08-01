package oracleuse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class OracleInsert {

	public static void main(String[] args) {
		Connection con = null; //데이터베이스 연결 변수
		PreparedStatement pstmt =null; //SQL 실행 변수
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 드라이버 클래스 로드
			con = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger"); // 데이터베이스 연결
			/*pstmt=con.prepareStatement
					("delete from dept where deptno=60"); //SQL 실행 객체 생성: sql이 매개변수
*/
			pstmt=con.prepareStatement("update dept set loc='만재도' where deptno=10");
			
			int r=pstmt.executeUpdate(); //SQL 실행: select를 제외한 구문 실행.
			//r에 저장되는 값은 영향받은 행의 개수
			
			if(r>0) {
				System.out.println("삽입 성공");
			} //성공여부 출력
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (con != null)con.close();
				if(pstmt!=null)pstmt.close();
			} catch (Exception e) {

			}
		}

	}

}
