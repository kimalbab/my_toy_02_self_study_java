package recap0606_mvc_jdbc_company.com.br.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import recap0606_mvc_jdbc_company.com.br.vo.Department;
import recap0606_mvc_jdbc_company.com.br.vo.Employee;
import recap0606_mvc_jdbc_company.com.br.vo.Job;

public class CompanyDao {
	
	public ArrayList<Department> selectDept() {
		 ArrayList<Department> deptList = new ArrayList<>();
		 
		 Connection conn = null;
		 PreparedStatement pstmt = null;
		 ResultSet rset = null;
		 
		 String sql = "SELECT DEPT_ID,DEPT_TITLE FROM DEPARTMENT";
		 
		 try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","BR", "BR");
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				deptList.add(new Department(rset.getString("DEPT_ID"),
											rset.getString("DEPT_TITLE")));
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
		 
		 
		 return deptList;
		
	}
	
	public ArrayList<Job> selectJob() {
		ArrayList<Job> jobList = new ArrayList<> ();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM JOB";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "BR", "BR");
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				jobList.add(new Job (rset.getString("JOB_CODE"),
									 rset.getString("JOB_NAME")));
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
		return jobList;
	}
	
	
	public int insertDept(String newDeptId, String newDeptTitle, String newLocationId) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO DEPARTMENT VALUES(?, ?, ?)";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "BR", "BR");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, newDeptId);
			pstmt.setString(2, newDeptTitle);
			pstmt.setString(3, newLocationId);
			
			result = pstmt.executeUpdate();
			
			if(result > 1) {
				conn.commit();
			} else {
				conn.rollback();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int insertJob(String newJobCode, String newJobName) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO JOB  VALUES(?, ?)";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "BR", "BR");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, newJobCode);
			pstmt.setString(2, newJobName);
			
			result = pstmt.executeUpdate();
			
			if(result>0) {
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
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return result;
	}
	
	public ArrayList<Employee> selectEmployee() {
		ArrayList<Employee> empList = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM EMPLOYEE";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "BR", "BR");
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				empList.add(new Employee (rset.getInt("EMP_ID"),
										  rset.getString("EMP_NAME"),
										  rset.getString("EMP_NO"),
										  rset.getString("EMAIL"),
										  rset.getString("PHONE"),
										  rset.getString("DEPT_CODE"),
										  rset.getString("JOB_CODE"),
										  rset.getInt("SALARY"),
										  rset.getInt("BONUS"),
										  rset.getString("MANAGER_ID"),
										  rset.getDate("HIRE_DATE"),
										  rset.getDate("ENT_DATE"),
										  rset.getString("ENT_YN")
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
		return empList;
	}
	
	public int changeDept(String changeEmpName, String changeDeptCode) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE EMPLOYEE SET DEPT_CODE = ? WHERE EMP_NAME = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","BR","BR");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, changeDeptCode);
			pstmt.setString(2, changeEmpName);
			
			
			result = pstmt.executeUpdate();
			
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
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
	
	public int changeJob(String changeEmpName, String changeJobCode) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE EMPLOYEE SET JOB_CODE = ? WHERE EMP_NAME = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","BR","BR");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, changeJobCode);
			pstmt.setString(2, changeEmpName);
			
			result = pstmt.executeUpdate();
			
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
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	
	public int end(String endName) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE EMPLOYEE SET ENT_DATE = SYSDATE, ENT_YN = 'Y' WHERE EMP_NAME = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","BR","BR");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, endName);
			
			result = pstmt.executeUpdate();
			
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
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
		return result;
	}
}





