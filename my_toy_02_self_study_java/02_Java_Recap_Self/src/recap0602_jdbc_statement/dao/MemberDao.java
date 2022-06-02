package recap0602_jdbc_statement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import recap0602_jdbc_statement.vo.Member;

public class MemberDao {
	
	public int insertMember(Member m) {
		
		//insert 문 => 처리된 행수 (int) => 트랜젝션처리
		
		int result = 0; //처리된 행 수를 받아줄 변수
		Connection conn = null; //연결된 DB의 정보를 담는 객체
		Statement stmt = null; // sql 문(실제값이 다 채워진 상태로) 실행을 위한 객체
		
		
		// 실행할 sql 문(완성된 형태로 만들어두기 == 사용자가 입력한 값들로 다 채워서)
		// INSERT INTO MEMBER VALUES(SEQ_USERNO.NEXTVAL, 'XXXX', 'XXXX'. 'XXXX', 'X', XX, 'XXX', 'XXXXX'. 'XXXXX', SYSDATE)
		
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
			//1. jdbc driver 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. Connction 객체 생성 (DB에 연결 URL, 계정명, 비밀번호)
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			
			//3. Statement 객체 생성
			stmt = conn.createStatement();
			
			//4.5. sql문 실행 및 결과 받기
			result = stmt.executeUpdate(sql);
			
			//6. 트랜젝션처리 (dml 문만!)
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
		/* --> 출력문은 view 에서만 진행!
		if(result > 0) {
			System.out.println("성공적으로 추가되었습니다!");
		} else {
			System.out.println("추가하지 못했습니다.");
		}
		*/
		return result;
	}
	
	
	
	
	
	public Member selectByUserId(String userId) {
		Member m = null;
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM MEMBER WHERE USER_ID = '" + m.getUserId() +"'";
		
		try {
			//1. 드라이버 생성
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. 드라이버 연결
			conn = DriverManager.getConnection("jdbc:oracle:thin:@OracleManager:1521:xe", "JDBC", "JDBC");
			
			//3. 커넥트로 스테이트먼트 생성
			stmt = conn.createStatement();
			
			//RESULT SET은 SELECT 문을 실행할 때 사용, 하나하나 셋팅해줌
			rset = stmt.executeQuery(sql);
			
			
			//m이라는 멤버 객체 안에 스캐너로 받은 것드을 하나하나 sql 데이터 안으로 넣어줌
			if(rset.next()) {
				m = new Member (rset.getInt("USER_NO"),
								rset.getString("USER_ID"),
								rset.getString("USER_PWD"),
								rset.getString("USER_NAME"),
								rset.getString("GENDER"),
								rset.getInt("AGE"),
								rset.getString("EMAIL"),
								rset.getString("PHONE"),
								rset.getString("ADDRESS"),
								rset.getString("HOBBY"),
								rset.getDate("ENROLL_DATE"));
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
	
	public ArrayList<Member> selectByKeyword(String keyword) {
		
		ArrayList <Member> list = null;
				//new ArrayList<>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM MEMBER WHERE USERNAME LIKE '%" + keyword + "'";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			
			while(true) {
				list.add(new Member (rset.getInt("USER_NO"),
									 rset.getString("USER_ID"),
									 rset.getString("USER_PWD"),
									 rset.getString("USER_NAME"),
									 rset.getString("GENDER"),
									 rset.getInt("AGE"),
									 rset.getString("EMAIL"),
									 rset.getString("PHONE"),
									 rset.getString("ADDRESS"),
									 rset.getString("HOBBY"),
									 rset.getDate("ENROLL_DATE")));
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
		
		
		
		return list;
		
	}

}
