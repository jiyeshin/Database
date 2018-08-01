package oracleuse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataSaveDto {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<Dept> list=new ArrayList<>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 데이터베이스 드라이버를 로드
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger"); // 데이터베이스에 접속
			pstmt = con.prepareStatement("select * from dept");
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				// 하나의 행을 저장할 DTO 객체 생성
				Dept dept = new Dept(); 
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDname(rs.getString("dname"));
				dept.setLoc(rs.getString("loc"));
			

				// 읽은 하나의 행을 리스트에 저장
				list.add(dept);

			}
			System.out.printf("%s", "DEPTNO");
			System.out.printf("%20s", "DNAME");
			System.out.printf("%30s", "LOC");
			System.out.println();
			for (Dept dept : list) {
				System.out.printf("%s", dept.getDeptno());
				System.out.printf("%20s", dept.getDname());
				System.out.printf("%30s", dept.getLoc());
				System.out.println();
			}
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
				if (pstmt != null)
					pstmt.close();
				if (rs != null)
					rs.close();
			} catch (Exception e) {
			}
		}

	}

}
