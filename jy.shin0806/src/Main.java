import java.sql.*;
import java.sql.DriverManager;

public class Main {
	public static void main(String[] args) {
		Connection con=null;
		CallableStatement call=null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
			
			/*call=con.prepareCall("{call insertDeptProc(?,?,?)}");
			call.setInt(1, 12);
			call.setString(2, "영업");
			call.setString(3, "용인");
			*/
			
			call=con.prepareCall("{call deleteDeptProc(12)}");
			
			
			
			int r= call.executeUpdate();
			if(r>0) { 
				System.out.println("성공");
				}
			else {
				System.out.println("실패");
			}
			
			
		}catch(Exception e) {
			
		}finally {
			try {
			if(con!=null)con.close();
			}catch(Exception e) {}
			
		}
	}
}
