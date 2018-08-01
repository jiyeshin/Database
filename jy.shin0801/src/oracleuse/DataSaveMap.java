package oracleuse;

import java.sql.*;
import java.util.*;

public class DataSaveMap {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<Map<String, Object>> list = new ArrayList<>();

		// HashMap<String, Object> map = new HashMap<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 데이터베이스 드라이버를 로드
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger"); // 데이터베이스에 접속

			pstmt = con.prepareStatement("select * from dept");
			rs = pstmt.executeQuery(); // select는 executeQuery()을 사용함.
			while (rs.next()) {
				// 행 단위로 읽기
				Map<String, Object> map = new HashMap<>(); // 하나의 행을 저장할 Map객체 생성
				map.put("deptno", rs.getInt("deptno"));
				map.put("dname", rs.getString("dname"));
				map.put("loc", rs.getString("loc"));

				// 읽은 하나의 행을 리스트에 저장
				list.add(map);

			}
			System.out.printf("%s", "DEPTNO");
			System.out.printf("%20s", "DNAME");
			System.out.printf("%30s", "LOC");
			System.out.println();
			for (Map map : list) {
				System.out.printf("%s", map.get("deptno"));
				System.out.printf("%20s", map.get("dname"));
				System.out.printf("%30s", map.get("loc"));
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
