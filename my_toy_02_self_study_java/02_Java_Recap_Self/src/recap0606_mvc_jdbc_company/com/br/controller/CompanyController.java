package recap0606_mvc_jdbc_company.com.br.controller;

import java.util.ArrayList;

import recap0606_mvc_jdbc_company.com.br.dao.CompanyDao;
import recap0606_mvc_jdbc_company.com.br.view.CompanyMenu;
import recap0606_mvc_jdbc_company.com.br.vo.Department;
import recap0606_mvc_jdbc_company.com.br.vo.Employee;
import recap0606_mvc_jdbc_company.com.br.vo.Job;

public class CompanyController {
	
	public void selectDept() {
		ArrayList<Department> deptList = new CompanyDao().selectDept();
		
		if(deptList.isEmpty()) {
			new CompanyMenu().displayFail("부서조회 실패");
		} else {
			new CompanyMenu().displayDeptList(deptList);
		}
	}
	
	public void selectJob() {
		ArrayList<Job> jobList = new CompanyDao().selectJob();
		

		if(jobList.isEmpty()) {
			new CompanyMenu().displayFail("부서조회 실패");
		} else {
			new CompanyMenu().displayJobList(jobList);
		}
	}
	
	public void insertDept(String newDeptId, String newDeptTitle, String newLocationId) {
		
		int result = new CompanyDao().insertDept(newDeptId, newDeptTitle, newLocationId);
		if(result > 0) {
			new CompanyMenu().displaySuccess("부서가 추가되었습니다.");
		} else {
			new CompanyMenu().displayFail("부서 추가 실패.");
		}
	}
	
	public void insertJob(String newJobCode, String newJobName) {
		int result = new CompanyDao().insertJob(newJobCode, newJobName);
		
		if(result > 0) {
			new CompanyMenu().displaySuccess("부서가 추가되었습니다.");
		} else {
			new CompanyMenu().displayFail("부서 추가 실패.");
		}
	} 
	
	public void selectEmployee() {
		ArrayList<Employee> empList = new CompanyDao().selectEmployee();
		
		if(empList.isEmpty()) {
			new CompanyMenu().displayFail("직원 조회 실패.");
		} else {
			new CompanyMenu().displayEmpList(empList);
		}
	}
	
	public void changeDept(String changeEmpName, String changeDeptCode) {
		int result = new CompanyDao().changeDept(changeEmpName, changeDeptCode);
		if(result > 0) {
			new CompanyMenu().displaySuccess(changeEmpName + "님의 부서가 변경되었습니다.");
		} else {
			new CompanyMenu().displayFail("부서 변경 실패.");
		}
	}

	public void changeJob(String changeEmpName, String changeJobCode) {
		int result = new CompanyDao().changeJob(changeEmpName, changeJobCode);
		if(result > 0) {
			new CompanyMenu().displaySuccess(changeEmpName + "님의 직급이 변경되었습니다.");
		} else {
			new CompanyMenu().displayFail("직급 변경 실패.");
		}
	}
	
	public void end(String endName) {
		int result = new CompanyDao().end(endName);
		
		if(result > 0) {
			new CompanyMenu().displaySuccess(endName + "님의 퇴사처리 완료.");
		} else {
			new CompanyMenu().displayFail("퇴사 처리 실패.");
		}
	}
}






