package recap0605_mvc_jdbc_preparedStatement.com.br.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import recap0605_mvc_jdbc_preparedStatement.com.br.vo.Member;

public class MemberDao {
	
	public int enroll(Member m) {
		
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO MEMBER "
				   + "VALUES(SEQ_USERNO.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "TEST", "TEST");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getGender());
			pstmt.setInt(5, m.getAge());
			pstmt.setString(6, m.getEmail());
			pstmt.setString(7, m.getPhone());
			pstmt.setString(8, m.getAddress());
			pstmt.setString(9, m.getHobby());
			
			result = pstmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	
	public int update(Member m) {
		
		
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE MEMBER SET USER_PWD =  ?, PHONE = ? WHERE USER_ID = ?";
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "TEST","TEST");
			pstmt= conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getUserPwd());
			pstmt.setString(2, m.getPhone());
			pstmt.setString(3, m.getUserId());
			
			result = pstmt.executeUpdate();
			
					
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public int delete(String searchId) {
		
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM MEMBER WHERE USER_ID = ?";
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "TEST","TEST");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, searchId);
			
			result = pstmt.executeUpdate();
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public Member login(String userId, String userPwd) {
		
		Member m = new Member();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM MEMBER WHERE USER_ID = ? AND USER_PWD = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "TEST", "TEST");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) { 
				m = new Member( rset.getInt("user_no"),
								 rset.getString("user_id"),
								 rset.getString("user_pwd"),
								 rset.getString("user_name"),
								 rset.getString("gender"),
								 rset.getInt("age"),
								 rset.getString("email"),
								 rset.getString("phone"),
								 rset.getString("address"),
								 rset.getString("hobby"),
								 rset.getDate("enroll_date"));
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} return m;
	}
	
	
	public ArrayList<Member> allList() {
		// select 문 진행(여러행) -> ResultSset 객체 => ArrayList에 추가
		ArrayList<Member> allList = new ArrayList<>(); //일단 텅 빈 리스트
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM MEMBER"; //애초에 완성된 SQL 문
		
		try {
			//1) jdbc 등록구문
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2) connection 객체 생성
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "TEST", "TEST");
			
			//3) preparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql); // 애초에 완성된 sql 문 담았음 => 곧바로 실행
			
			//4, 5) sql 문 실행 및 결과받기 
			rset = pstmt.executeQuery();
			while(rset.next()) {
				
					
						allList.add(new Member(rset.getInt("USER_NO"),
											  rset.getString("USER_ID"),
											  rset.getString("USER_PWD"),
											  rset.getString("USER_NAME"),
											  rset.getString("GENDER"),
											  rset.getInt("AGE"),
											  rset.getString("EMAIL"),
											  rset.getString("PHONE"),
											  rset.getString("ADDRESS"),
											  rset.getString("HOBBY"),
											  rset.getDate("ENROLL_DATE")
											  ));
					
				
				}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return allList; // 텅 빈 리스트 | 조회 결과가 담겨있는 리스트
	
	}
	
	
	public Member idSearch(String searchId) {
		Member m = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM MEMBER WHERE USER_ID = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","TEST","TEST");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, searchId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				m = new Member(rset.getInt("USER_NO"),
							   rset.getString("USER_ID"),
							   rset.getString("USER_PWD"),
							   rset.getString("USER_NAME"),
							   rset.getString("GENDER"),
							   rset.getInt("AGE"),
							   rset.getString("EMAIL"),
							   rset.getString("PHONE"),
							   rset.getString("ADDRESS"),
							   rset.getString("HOBBY"),
							   rset.getDate("ENROLL_DATE")
							   );
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return m;
	}
	
	
	public ArrayList<Member> searchName(String keyword) {
		ArrayList <Member> searchList = new ArrayList<> ();
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM MEMBER WHERE USER_NAME LIKE ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "TEST", "TEST");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,"%" + keyword + "%");
			rset = pstmt.executeQuery();
			while(rset.next()) {
				
					
					searchList.add(new Member(rset.getInt("USER_NO"),
											  rset.getString("USER_ID"),
											  rset.getString("USER_PWD"),
											  rset.getString("USER_NAME"),
											  rset.getString("GENDER"),
											  rset.getInt("AGE"),
											  rset.getString("EMAIL"),
											  rset.getString("PHONE"),
											  rset.getString("ADDRESS"),
											  rset.getString("HOBBY"),
											  rset.getDate("ENROLL_DATE")
											  ));
					
				
				}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return searchList;
	}
	
	
	
	
	
	
	
	
}
