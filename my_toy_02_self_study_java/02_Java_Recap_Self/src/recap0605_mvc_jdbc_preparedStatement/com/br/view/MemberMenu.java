package recap0605_mvc_jdbc_preparedStatement.com.br.view;

import java.util.ArrayList;
import java.util.Scanner;

import recap0605_mvc_jdbc_preparedStatement.com.br.controller.MemberController;
import recap0605_mvc_jdbc_preparedStatement.com.br.vo.Member;

public class MemberMenu {

	Scanner sc = new Scanner(System.in);
	MemberController mc = new MemberController();
	
	public void mainMenu() {
	 
		System.out.println("==== 회원 관리 메뉴 ===");
		
		System.out.println("1. 회원 가입");
		System.out.println("2. 회원 정보 수정");
		System.out.println("3. 회원 탈퇴");
		System.out.println("4. 로그인");
		System.out.println("5. 전체 회원 조회");
		System.out.println("6. 아이디검색");
		System.out.println("7. 회원이름 검색");
		System.out.println("0. 프로그램 종료");

		System.out.println("메뉴 선택 >>");
		int menu = sc.nextInt();
		
		sc.nextLine();
		
		while(true) {
			
			switch(menu) {
			case 1 : enroll(); break;
			case 2 : update(); break;
			case 3 : mc.delete(searchId()); break;
			case 4 : login(); break;
			case 5 : mc.allList(); break;
			case 6 : mc.idSearch(searchId()); break;
			case 7 : searchName(); break;
			case 0 : System.out.println("프로그램이 종료됩니다. 감사합니다."); return;
			default : System.out.println("잘못 누르셨습니다. 다시 선택해주세요"); break;
			}
		}
		
	}
	
	
	public void enroll() {
		
		System.out.println("ID : ");
		String userId = sc.nextLine();
		
		System.out.println("PWD : ");
		String userPwd = sc.nextLine();
		
		System.out.println("이름 : ");
		String userName = sc.nextLine();
		
		System.out.println("성별(M/F) : ");
		String gender = sc.nextLine().toUpperCase();
		
		System.out.println("나이 : ");
		String age = sc.nextLine();
		
		System.out.println("EMAIL : ");
		String email = sc.nextLine();
		
		System.out.println("PHONE : ");
		String phone = sc.nextLine();
		
		System.out.println("주소 : ");
		String address = sc.nextLine();
		
		System.out.println("취미 : ");
		String hobby = sc.nextLine();
		
		mc.enroll(userId, userPwd, userName, gender, age, email, phone, address, hobby);
	}
	
	public void update() {
		System.out.println("아이디 검색 : ");
		String userId = sc.nextLine();
		
		System.out.println("수정될 비밀번호 : ");
		String userPwd = sc.nextLine();
		
		System.out.println("수정될 폰번호 : ");
		String phone = sc.nextLine();
		
		mc.update(userId, userPwd, phone);
	}
	
	public String searchId() {
		System.out.println("아이디 검색 : ");
		String searchId = sc.nextLine();
		return searchId;
	}
	
	public void searchName() {
		System.out.println("회원명 키워드 검색 : ");
		String keyword = sc.nextLine();
		mc.searchName(keyword);
	}
	
	public void login() {

		System.out.println("ID : ");
		String userId = sc.nextLine();
		
		System.out.println("PWD : ");
		String userPwd = sc.nextLine();
		
		mc.login(userId, userPwd);
	}
	
	
	
	//----------------------
	
	public void displaySuccess(String messege) {
		System.out.println(messege + " 정보는 안전하게 보호됩니다.");
	}
	
	public void displayFail(String messege) {
		System.out.println(messege + " 다시 시도해주세요.");
	}
	
	public void displayMember(Member m) {
		System.out.println(m);
	} 
	
	public void displayList(ArrayList<Member> list) {
		for(Member m : list) {
			System.out.println(m);
		}
	}
}
