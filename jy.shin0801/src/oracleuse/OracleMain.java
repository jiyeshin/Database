package oracleuse;

import java.sql.Connection;
import java.sql.DriverManager;

public class OracleMain {

	public static void main(String[] args) {
		Connection con = null;
		try {
			// 사용하는 데이터베이스마다 로드하는 클래스 이름은 결정되어 있음
			Class.forName("oracle.jdbc.driver.OracleDriver");

			System.out.println("오라클 드라이버 로드 성공"); // 확인용.
			// 위 코드가 출력이 안 되면 드라이버 이름을 확인해보고
			// 드라이버 이름이 틀리지 않았다면 ojdbc6.jar이 Referenced Libraries에 있는지 확인

			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost", "scott", "tiger");
			System.out.println("데이터베이스 연결 성공");
			//위 코드가 출력되지 않으면 데이터베이스 연결상태 확인
			//url, 계정, 비번 제대로 입력했는지 확인

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {

			}
		}

	}

}
