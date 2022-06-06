package recap0606_mvc_jdbc_company.com.br.view;

import java.util.ArrayList;
import java.util.Scanner;

import recap0606_mvc_jdbc_company.com.br.controller.CompanyController;
import recap0606_mvc_jdbc_company.com.br.vo.Department;
import recap0606_mvc_jdbc_company.com.br.vo.Employee;
import recap0606_mvc_jdbc_company.com.br.vo.Job;

public class CompanyMenu {
	
	
	Scanner sc = new Scanner(System.in);
	CompanyController cc = new CompanyController();
	
	
	public void mainMenu() {
		
		System.out.println("==== 회사 관리 프로그램 ====");
		
		while(true) {
			System.out.println("1. 전체 부서 조회");
			System.out.println("2. 전체 직급 조회");
			System.out.println("3. 새 부서 추가");
			System.out.println("4. 새 직급 추가");
			System.out.println("5. 전체 사원 조회");
			System.out.println("6. 특정 사원 부서변경");
			System.out.println("7. 특정 사원 직급변경");
			System.out.println("8. 특정 사원 퇴사");
			System.out.println("0. 프로그램 종료");
			
			System.out.println("원하는 메뉴 번호를 골라주세요.");
			
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1 : cc.selectDept(); break;
			case 2 : cc.selectJob(); break;
			case 3 : askDept(); break;
			case 4 : askJob(); break;
			case 5 : cc.selectEmployee(); break;
			case 6 : askDeptEmpName(); break;
			case 7 : askJobEmpName();break;
			case 8 : cc.end(endUpWho()); break;
			case 0 : System.out.println("이용해주셔서 감사합니다. \n프로그램을 종료합니다."); return;
			default : System.out.println("잘못 누르셨습니다. 다시 선택해주세요"); break;
			}
		}
		
	}
	
	public void askDept() {
		
		System.out.println("추가할 부서ID 입력 (D(n)) : ");
		String newDeptId = sc.nextLine();
		
		System.out.println("추가할 부서명을 입력해주세요 : ");
		String newDeptTitle = sc.nextLine();
		
		System.out.println("추가할 지역ID 입력 (L(n)) : ");
		String newLocationId = sc.nextLine();
		
		cc.insertDept(newDeptId, newDeptTitle, newLocationId);
		
	}
	
	public void askJob() {
		System.out.println("추가할 직급코드 (J(n)) : ");
		String newJobCode = sc.nextLine();
		
		System.out.println("추가할 직급명 : ");
		String newJobName = sc.nextLine();
		
		cc.insertJob(newJobCode, newJobName);
	}
	
	public void askDeptEmpName() {
		System.out.println("부서를 변경할 사원명 : ");
		String changeEmpName = sc.nextLine();
		
		System.out.println("변경할 부서코드(D0~D9) : ");
		String changeDeptCode = sc.nextLine();
		
		cc.changeDept(changeEmpName, changeDeptCode);
	}
	
	public void askJobEmpName() {
		System.out.println("직급을 변경할 사원명 : ");
		String changeEmpName = sc.nextLine();
		
		System.out.println("변경할 직급코드(J0~J9) : ");
		String changeJobCode = sc.nextLine();
		
		cc.changeJob(changeEmpName, changeJobCode);
	}
	
	public String endUpWho() {
		System.out.println("퇴사한 사원명 : ");
		String endName = sc.nextLine();
		
		return endName;
	}
	
	//----------------------------- 응답화면 목록 -------------------------------
	
	public void displaySuccess(String s) {
		System.out.println(s + " 정보는 안전하게 보호됩니다.");
	}
	
	public void displayFail(String s) {
		System.out.println(s + " 번호를 다시 선택해주세요.");
	}
	
	public void displayEmployee(Employee e) {
		System.out.println(e);
	}
	
	public void displayDepartment(Department d) {
		System.out.println(d);
	}
	
	public void displayJob(Job j) {
		System.out.println(j);
	}
	
	public void displayEmpList(ArrayList<Employee> empList) {
		for(Employee e : empList) {
			System.out.println(e);
		}
	}
	
	public void displayDeptList(ArrayList<Department> deptList) {
		for(Department d : deptList) {
			System.out.println(d);
		}
	}

	public void displayJobList(ArrayList<Job> jobList) {
		for(Job j : jobList) {
			System.out.println(j);
		}
	}
}
