package oracleuse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class OraclePractice {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("부서번호: ");
		int deptno = sc.nextInt();
		System.out.println("부서번호: "+deptno);
		sc.close();
		Connection con= null;
		PreparedStatement pstmt=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //드라이버 클래스를 로드
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger"); //데이터베이스 연결
			System.out.println("접속성공");
			
			con.setAutoCommit(false); //오토커밋 해제
			
			String sql="delete from dept where deptno=?";
			pstmt=con.prepareStatement(sql); //sql 실행 객체 생성
			pstmt.setInt(1, deptno); //?가 있으면 데이터를 바인딩
			
			int r=pstmt.executeUpdate(); //sql실행
			if(r>0) {System.out.println("삭제성공");
			con.commit();}
			else
				System.out.println("조건에 맞는 데이터가 없습니다.");
			//실행하고 나면 영향받은 행의 개수를 리턴함.
			//조건에 맞는 데이터가 없으면 실패하는게 아니라 삭제하는 행의 개수가 0임.
			//실패하면 예외가 발생하여 catch로 감.

		}catch(Exception e) {
			try {
				con.rollback();
			}catch(Exception e1){}
			System.out.println(e.getMessage()); //예외의 내용을 출력
			e.printStackTrace(); //예외가 발생한 지점을 역추적
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(Exception e){}
			
		}

	}

}
