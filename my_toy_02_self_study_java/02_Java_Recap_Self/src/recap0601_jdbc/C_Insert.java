package recap0601_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class C_Insert {

	public static void main(String[] args) {
		
		int result = 0;
		
		Connection conn = null;
		Statement stmt = null;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("추가할 이름 : ");
		String name = sc.nextLine();
		String sql = "INSERT INTO TEST VALUES (SEQ_TESTNO.NEXTVAL, " + name + " , SYSDATE)";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			
			stmt = conn.createStatement();
			
			result = stmt.executeUpdate(sql);
			
			if(result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(result > 0) {
			System.out.println("성공적으로 추가되었습니다.");
		} else {
			System.out.println("추가 실패.");
		}
		
		
	}

}
