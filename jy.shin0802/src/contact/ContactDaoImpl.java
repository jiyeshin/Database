package contact;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactDaoImpl implements ContactDao {
	// 모든 메소드에서 공통으로 사용할 변수 선언
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
		}

	}

	// 가장 큰 num을 찾아오는 메소드
	private int getMaxNum() {
		int result = 0;
		try {
			connect();

			// 가장 큰 글번호를 찾아오는 sql 을 실행하는 객체 생성
			pstmt = con.prepareStatement("select max(num) from contacttable");
			rs = pstmt.executeQuery(); // sql 실행. select는 resultset으로 받고, executeQuery()사용.
			while (rs.next()) {
				result = rs.getInt(1); // select절의 첫 번쨰 컬럼의 값을 정수로 읽어서 result에 저장.
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}

	@Override
	public boolean insertContactTable(ContactTable ct) {
		boolean result = false;
		try {
			int maxNum = getMaxNum();
			connect();
			String sql = "insert into Contacttable(num,name,phone,email,bday) values(?,?,?,?,?)";
			pstmt = con.prepareStatement(sql); // sql 실행 객체

			// 물음표에 값을 바인딩
			pstmt.setInt(1, maxNum + 1); // 가장 큰 번호+1로 설정 //pstmt.setInt(1, ct.getNum());
			// pstmt.setInt(1, ct.getMaxNum() + 1); <-이렇게 하면 안 됨. close() 때문에 먼저 닫혀버림.
			pstmt.setString(2, ct.getName());
			pstmt.setString(3, ct.getPhone());
			pstmt.setString(4, ct.getEmail());
			pstmt.setDate(5, ct.getBday());

			// select를 제외한 구문은 executeUpdate로 실행
			// 실행결과를 영향받은 행의 개수를 정수로 리턴
			int r = pstmt.executeUpdate();
			if (r == 1) {
				result = true;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			close();
		}

		return result;
	}

	@Override
	public boolean updateContactTable(ContactTable ct) {
		boolean result = false;
		try {
			connect();
			pstmt = con.prepareStatement
					("update contacttable set name=?,phone=?, email=?, bday=? where num=?");
			pstmt.setString(1, ct.getName());
			pstmt.setString(2, ct.getPhone());
			pstmt.setString(3, ct.getEmail());
			pstmt.setDate(4, ct.getBday());
			pstmt.setInt(5, ct.getNum()); 

			//sql 실행
			int r = pstmt.executeUpdate();
			if (r == 1) {
				result = true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	
	@Override
	public boolean deleteContactTable(int num) {
		boolean result=false;
		try {
			connect();
			pstmt=con.prepareStatement("delete from contacttable where num=?");
			pstmt.setInt(1, num);
			int r=pstmt.executeUpdate();
			if(r>0) {
				result=true;
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		close();
		return result;
	}

	@Override
	public List<ContactTable> allContactTable() {
		List<ContactTable> list = new ArrayList<ContactTable>();
		connect();
		try {
			//sql 실행 객체
			pstmt=con.prepareStatement
					("select num, phone, name, email, bday from contacttable");
			rs=pstmt.executeQuery();
			
			//반복문을 이용해서 읽은 데이터를 List에 저장
			while(rs.next()) {
				//하나의 행을 읽어서 DTO에 저장
				ContactTable ct=new ContactTable();
				ct.setNum(rs.getInt(1)); //ct.setNum(rs.getInt("num"));
				ct.setName(rs.getString("name"));
				ct.setPhone(rs.getString("phone"));
				ct.setEmail(rs.getString("email"));
				ct.setBday(rs.getDate("bday"));
				
				list.add(ct); //읽은 데이터를 리스트에 저장
			}	
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		close();
		return list;
	}

	@Override
	public List<ContactTable> nameContactTable(String name) {
		List<ContactTable> list = new ArrayList<ContactTable>();
		connect();
		try {
			//sql 실행 객체
			pstmt=con.prepareStatement
					("select num, phone, name, email, bday from contacttable where upper(name) like ?"); 
			//영문 검색은 반드시 대소문자를 생각해야 함!!!!
			pstmt.setString(1, "%"+name+"%"); //물음표에 데이터 바인딩
			rs=pstmt.executeQuery(); //sql 실행
			
			//반복문을 이용해서 읽은 데이터를 List에 저장
			while(rs.next()) {
				//하나의 행을 읽어서 DTO에 저장
				ContactTable ct=new ContactTable();
				ct.setNum(rs.getInt(1)); //ct.setNum(rs.getInt("num"));
				ct.setName(rs.getString("name"));
				ct.setPhone(rs.getString("phone"));
				ct.setEmail(rs.getString("email"));
				ct.setBday(rs.getDate("bday"));
				
				list.add(ct); //읽은 데이터를 리스트에 저장
			}	
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		close();
		return list;

	}
}
