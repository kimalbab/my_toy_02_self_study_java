package recap0602_jdbc_statement.view;

import java.util.ArrayList;
import java.util.Scanner;

import recap0602_jdbc_statement.controller.MemberController;
import recap0602_jdbc_statement.vo.Member;

public class MemberMenu {
	
	private Scanner sc = new Scanner(System.in);
	MemberController mc = new MemberController();
	
	
	public void mainMenu() {
		while(true) {
			System.out.println("\n=== 회원관리 프로그램 ===");
			System.out.println("1. 회원추가");
			System.out.println("2. 전체 회원 조회");
			System.out.println("3. 회원 아이디 검색");
			System.out.println("4. 회원 이름으로 키워드 검색");
			System.out.println("5. 회원 정보 변경");
			System.out.println("6. 회원 탈퇴");
			System.out.println("0. 프로그램 종료");
			
			System.out.print(">> 메뉴 선택");
			int menu = sc.nextInt();
			
			sc.nextLine();
			
			switch(menu) {
			case  1 :  insertMember(); break;
			case  2 :  mc.selectList(); break;
			case  3 :  String userId = inputMemberId();
			           mc.selectByUserId(userId);
			           break;
			case  4 :  String keyword = inputMemberName();
					   mc.selectByKeyword(keyword);
					   break;
			case  5 :  break;
			case  6 :  break;
			case  0 :  System.out.println("이용해 주셔서 감사합니다."); return;
			default : System.out.println("메뉴를 잘못 입력했습니다. 다시 입력해주세요.");;
			}
		}
	}
	
	public void insertMember() {
		System.out.println("=== 회원 추가 ===");
		
		System.out.print("아이디 : ");
		String userId = sc.nextLine();
		
		System.out.print("비밀번호 : ");
		String userPwd = sc.nextLine();

		System.out.print("이름 : ");
		String userName = sc.nextLine();

		System.out.print("성별 : ");
		String gender = sc.nextLine().toUpperCase();
		
		System.out.print("나이 : ");
		String age = sc.nextLine();

		System.out.print("이메일 : ");
		String email = sc.nextLine();
		
		System.out.print("번호 : ");
		String phone = sc.nextLine();
		
		System.out.print("주소 : ");
		String address = sc.nextLine();
		
		System.out.print("취미 : ");
		String hobby = sc.nextLine();
		
		mc.insertMember(userId, userPwd, userName, gender, age, email, phone, address, hobby);
	}
	
	
	public String inputMemberId() {
		System.out.println("\n아이디를 입력하세요 : ");
		return sc.nextLine();
		// 리턴 : userId
	}
	
	public String inputMemberName() {
		System.out.println("\n검색할 이름 키워드 : ");
		return sc.nextLine();
	}
	
	
	//------------------------------------- 응답 전용 메뉴 ---------------------------------------
	
	//서비스 요청 처리가 성공했을 때
	public void displaySuccess(String message) {
		System.out.println("\n 서비스 요청 성공 : " + message);
	}
	
	
	//서비스 요청 처리가 성공했을 때
	public void displayFail(String message) {
		System.out.println("\n 서비스 요청 실패 : " + message);
	}
	
	//리스트에 데이터가 없을 때 
	public void displayNoData(String message) {
		System.out.println("\n 비어있는 데이터 입니다" + message);
	}
	
	public void displayData (ArrayList<Member> list) {
		System.out.println("\n조회된 데이터는 다음과 같습니다.\n");
		for(Member m : list) {
			System.out.println(m);
		}
	}
	
	public void displayMember(Member m) {
		System.out.println("\n조회된 데이터는 다음과 같습니다.\n");
		System.out.println(m);
	}
}
