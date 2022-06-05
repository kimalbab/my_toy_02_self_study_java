package recap0604_mvc_jdbc_statement.com.br.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import recap0604_mvc_jdbc_statement.com.br.vo.Member;

public class MemberDao {

	
	public int enroll(Member m) {
		int result = 0;
		
		Connection conn = null;
		Statement stmt = null;
		//ResultSet rest = null;
		
		String sql = "INSERT INTO MEMBER VALUES(SEQ_USERNO.NEXTVAL, '" + m.getUserId()   + "', " 
                + "'" + m.getUserPwd()  + "', "
                + "'" + m.getUserName() + "', " 
                + "'" + m.getGender()   + "', " 
                + "'" + m.getAge()      + "', " 
                + "'" + m.getEmail()    + "', "
                + "'" + m.getPhone()    + "', "
                + "'" + m.getAddress()  + "', "
                + "'" + m.getHobby()    + "', SYSDATE)";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "TEST", "TEST");
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
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
		return result;
	}

	
	public ArrayList<Member> viewEveryInfo() {
		
		ArrayList<Member> list = new ArrayList<>();
		//Member m = null;
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM MEMBER";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "TEST", "TEST");
			// 여기까지 jdbc 커넥션 연결
			
			//상태 = 커넥션에 상태를 생성함
			stmt = conn.createStatement();
			
			//결과를 세팅하겠다 <= 상태에 있는 쿼리문을 이용해서
			rset = stmt.executeQuery(sql);
			
			
			// 이게 지금 뭘 한거냐..
			// 만약 결과조회에서 다음 값들이 계속 존재한다면
			while(rset.next()) {
				// 계속 리스트에 추가하자, 조회되는 새로운 멤버 객체를 => 유저넘버, 가입일은 제외한 새로운 객체로 조회 
				list.add(new Member (
								rset.getString("USER_ID"),
								rset.getString("USER_PWD"),
								rset.getString("USER_NAME"),
								rset.getString("GENDER"),
								rset.getInt("AGE"),
								rset.getString("EMAIL"),
								rset.getString("PHONE"),
								rset.getString("ADDRESS"),
								rset.getString("HOBBY")
								));
			}
			
			// 그냥 셀렉문이므로 트랜젝션 문구는 필요없음
			
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
		return list;
	}
	
	public Member searchId(String askUserId) {
		Member m = null;
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM MEMBER WHERE USER_ID = '" + askUserId + "'";
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "TEST","TEST");
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			
			while(rset.next()) {
				m = new Member(rset.getString("USER_ID"),
							   rset.getString("USER_PWD"),
							   rset.getString("USER_NAME"),
							   rset.getString("GENDER"),
							   rset.getInt("AGE"),
							   rset.getString("EMAIL"),
							   rset.getString("PHONE"),
							   rset.getString("ADDRESS"),
							   rset.getString("HOBBY")
								);
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
		
		return m;
	}
	
	public ArrayList<Member> searchUserName(String keyword) {
		ArrayList<Member> searchList = new ArrayList<>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM MEMBER WHERE USER_NAME LIKE '%" + keyword + "%'";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "TEST", "TEST");
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			
			while(rset.next()) {
				searchList.add(new Member(rset.getString("USER_ID"),
							   rset.getString("USER_PWD"),
							   rset.getString("USER_NAME"),
							   rset.getString("GENDER"),
							   rset.getInt("AGE"),
							   rset.getString("EMAIL"),
							   rset.getString("PHONE"),
							   rset.getString("ADDRESS"),
							   rset.getString("HOBBY")
							   ));
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
		
		return searchList;
	}
	
	
	public int updateMember(String userId, String userPwd, String userName, String phone, String address) {
		int result = 0;
		
		Connection conn = null;
		Statement stmt = null;
		
		String sql = "UPDATE MEMBER "
				   + "SET USER_PWD = '" + userPwd + "',"
				   + "USER_NAME = '" + userName + "',"
				   + "PHONE = '" + phone + "',"
				   + "ADDRESS = '" + address + "' "
				   + "WHERE USER_ID = '" + userId + "'";
				   
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "TEST", "TEST");
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
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
		
		return result;
	}
	
	
	public int deleteUser(String askUserId) {
		int result = 0;
		
			Connection conn = null;
			Statement stmt = null;
			
			String sql = "DELETE FROM MEMBER WHERE USER_ID = '" + askUserId + "'";
			
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","TEST","TEST");
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
					stmt.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
		
		return result;
	}
	
	
	public Member login(String userId, String userPwd) {
		Member m = null;
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM MEMBER WHERE USER_ID = '" + userId + "' AND USER_PWD = '" + userPwd + "'";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "TEST", "TEST");
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			
			while(rset.next()) {
			
					m = new Member(rset.getString("USER_ID"),
							   rset.getString("USER_PWD"),
							   rset.getString("USER_NAME"),
							   rset.getString("GENDER"),
							   rset.getInt("AGE"),
							   rset.getString("EMAIL"),
							   rset.getString("PHONE"),
							   rset.getString("ADDRESS"),
							   rset.getString("HOBBY")
								);
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
		return m;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
