package recap0604_mvc_jdbc_statement.com.br.view;

import java.util.ArrayList;
import java.util.Scanner;

import recap0604_mvc_jdbc_statement.com.br.controller.MemberController;
import recap0604_mvc_jdbc_statement.com.br.vo.Member;

public class MemberMenu {
	
	Scanner sc = new Scanner(System.in);
	MemberController mc = new MemberController();
	
	public void mainMenu() {
			
		while(true) {
			System.out.println("=== 메뉴선택 ===");
			System.out.println("1. 회원 가입");
			System.out.println("2. 전체 회원 조회");
			System.out.println("3. 회원 아이디 찾기");
			System.out.println("4. 회원명 키워드 검색");
			System.out.println("5. 회원 정보 변경");
			System.out.println("6. 회원 탈퇴");
			System.out.println("7. 로그인");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("원하시는 메뉴를 골라주세요 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			switch(menu) {
			case 1 : enroll(); break; 
			case 2 : mc.viewEveryInfo(); break; 
			case 3 : mc.searchId(askId()); break; 
			case 4 : mc.searchUserName(askUserName()); break; 
			case 5 : update(); break; 
			case 6 : mc.deleteUser(askId()); break; 
			case 7 : login(); break; 
			case 0: System.out.println("프로그램을 종료합니다."); return; 
			default : System.out.println("잘못 고르셨습니다. 다시 골라주세요."); break;
			}
		}
		
	}
	
	//------------------------------------------------------------------------------------------------------------------//
	
	public void enroll() {
		System.out.println("ID : ");
		String userId = sc.nextLine();
		
		System.out.println("PWD : ");
		String userPwd = sc.nextLine();
		
		System.out.println("성명 : ");
		String userName = sc.nextLine();
		
		System.out.println("성별(M/F) : ");
		String gender = sc.nextLine();
		
		System.out.println("나이 : ");
		String age = sc.nextLine();
		
		System.out.println("EMAIL : ");
		String email = sc.nextLine();
		
		System.out.println("PHONE : ");
		String phone = sc.nextLine();
		
		System.out.println("주소 : ");
		String address = sc.nextLine();
		
		System.out.println("취미(,로 구분) : ");
		String hobby = sc.nextLine();
		
		mc.enroll(userId, userPwd, userName, gender, Integer.parseInt(age), email, phone, address, hobby);
	}
	
	public String askId() {
		System.out.println("검색할 아이디 : ");
		String askUserId = sc.nextLine();
		return askUserId;
	}
	
	public String askUserName() {
		System.out.println("검색할 회원명 키워드 : ");
		String keyword = sc.nextLine();
		return keyword;
	}
	
	public void update() {
		
		
		System.out.println("업데이트 할 회원 아이디 : ");
		String userId = sc.nextLine();
		
		System.out.println("수정 할 회원 비밀번호 : ");
		String userPwd = sc.nextLine();
		
		System.out.println("수정 할 회원명 : ");
		String userName = sc.nextLine();
		
		System.out.println("수정 할 회원 전화번호 : ");
		String phone = sc.nextLine();
		
		System.out.println("수정 할 회원 주소 : ");
		String address = sc.nextLine();
		
		mc.updateMember(userId, userPwd, userName, phone, address);
		
	}
	
	public void login () {
		System.out.println("ID : ");
		String userId = sc.nextLine();
		
		System.out.println("PWD : ");
		String userPwd = sc.nextLine();
		
		mc.login(userId, userPwd);
	}
	//--------------------------------------------------------------------------------------------
	
	//응답화면
	
	public void displaySuccess(String messege) {
		System.out.println(messege + " 정보는 안전하게 보호됩니다.");
	}
	
	public void displayFail(String messege) {
		System.out.println(messege + " 다시 시도해주세요.");
	}
	
	public void displayList(ArrayList<Member> list) {
		for(Member m : list) {
			System.out.println(m);
		}
	}
	
	public void displayMember(Member m) {
		System.out.println(m);
	}
}
