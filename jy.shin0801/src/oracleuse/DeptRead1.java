package oracleuse;

import java.sql.*;

public class DeptRead1 {

	public static void main(String[] args) {
		Connection con =null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			pstmt=con.prepareStatement("select * from dept"); //sql 실행 객체 생성
			rs=pstmt.executeQuery(); //select하는 sql 실행
			while(rs.next()) {
				System.out.print(rs.getInt("deptno")+": "); // System.out.print(rs.getInt(1)+": ");
				System.out.print(rs.getString("dname")+": "); // System.out.print(rs.getInt(2)+": ");
				System.out.print(rs.getString("loc")+"\n"); // System.out.print(rs.getInt(3)+"\n");
				
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			
		}finally {
			try {
				if(con!=null)con.close();
				if(pstmt!=null)pstmt.close();
				if(rs!=null)rs.close();
			}catch(Exception e) {}
		}

	}

}
