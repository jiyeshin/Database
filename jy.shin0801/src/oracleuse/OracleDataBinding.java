package oracleuse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class OracleDataBinding {

	public static void main(String[] args) {
		Connection con = null; // 데이터베이스 연결 변수
		PreparedStatement pstmt = null; // SQL 실행 변수
		Scanner sc = new Scanner(System.in);
		System.out.print("부서번호: ");
		int deptno = sc.nextInt();

		System.out.print("부서이름: ");
		sc.nextLine(); // 이 전에 남아 있던 엔터를 제거하기 위함
		String dname = sc.nextLine();

		System.out.print("지역: ");
		String loc = sc.nextLine();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 드라이버 클래스 로드
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger"); // 데이터베이스 연결
			String sql = "insert into dept(deptno, dname, loc) values(?,?,?)";
			pstmt = con.prepareStatement(sql);
			
			//데이터 바인딩
			pstmt.setInt(1, deptno);
			pstmt.setString(2, dname);
			pstmt.setString(3, loc);
			
			int r = pstmt.executeUpdate();
			if (r > 0) {
				System.out.println("삽입 성공");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (con != null)
					con.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {

			}
		}

	}

}
