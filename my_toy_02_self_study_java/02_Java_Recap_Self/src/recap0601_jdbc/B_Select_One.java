package recap0601_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class B_Select_One {
	public static void main(String[] args) {
		
	Test t = null;
			
	Connection conn = null;
	Statement stmt = null;
	ResultSet rset = null;
			
	
	
	Scanner sc = new Scanner(System.in);
	System.out.print("조회하고자 하는 번호 입력 : ");
	int no = sc.nextInt();
	String sql = "SELECT TNO, TNAME, TDATE FROM TEST WHERE TNO =" + no;
	
	
	
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
		
		stmt = conn.createStatement();
		
		rset = stmt.executeQuery(sql);
		
		if(rset.next()) {
			t = new Test(rset.getInt("TNO"), rset.getString("TNAME"), rset.getDate("TDATE"));
		}
		
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		
		try {
			rset.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	if (t == null) {
		System.out.println("조회 결과가 없습니다.");
	} else {
		System.out.println(t);
	}
	
	
	
}
}