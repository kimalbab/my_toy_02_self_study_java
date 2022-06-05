package recap0604_mvc_jdbc_statement.com.br.controller;

import java.util.ArrayList;

import recap0604_mvc_jdbc_statement.com.br.dao.MemberDao;
import recap0604_mvc_jdbc_statement.com.br.view.MemberMenu;
import recap0604_mvc_jdbc_statement.com.br.vo.Member;

public class MemberController {
	
	public void enroll(String userId, String userPwd, String userName, String gender,
						int age, String email, String phone, String address, String hobby) {
		Member m = new Member(userId, userPwd, userName, gender, age, email, phone, address, hobby);
		
		int result = new MemberDao().enroll(m);
		
		if(result > 0) {
			new MemberMenu().displaySuccess("회원가입을 축하합니다.");
		} else {
			new MemberMenu().displayFail("회원가입에 실패했습니다.");
		}
	}
	
	
	public void viewEveryInfo() {
		ArrayList<Member> list = new MemberDao().viewEveryInfo();
		
		if(list.isEmpty()) {
			new MemberMenu().displayFail("조회에 실패했습니다.");
		} else {
			new MemberMenu().displayList(list);
		}
	}
	
	public void searchId(String askUserId) {
		Member m = new MemberDao().searchId(askUserId);
		
		if(m == null) {
			new MemberMenu().displayFail("조회된 아이디가 없습니다.");
		} else {
			new MemberMenu().displayMember(m);
		}
	}
	
	public void searchUserName(String keyword) {
		ArrayList <Member> searchList = new MemberDao().searchUserName(keyword);
		
		if(searchList.isEmpty()) {
			new MemberMenu().displayFail("검색되는 회원명이 없습니다.");
		} else {
			new MemberMenu().displayList(searchList);
		}
	}
	
	public void updateMember(String userId, String userPwd, String userName, String phone, String address) {
		int result = new MemberDao().updateMember(userId, userPwd, userName, phone, address);
		
		if(result > 0) {
			new MemberMenu().displaySuccess("회원정보 업데이트.");
		} else {
			new MemberMenu().displayFail("업데이트에 실패했습니다.");
		}
	}
	
	public void deleteUser(String askUserId) {
		int result = new MemberDao().deleteUser(askUserId);
		
		if(result > 0) {
			new MemberMenu().displaySuccess(askUserId + "회원님이 탈퇴되었습니다.");
		} else {
			new MemberMenu().displayFail("탈퇴에 실패했습니다.");
		}
	}
	
	public void login(String userId, String userPwd) {
		
		Member m = new MemberDao().login(userId, userPwd);
		if(m == null) {
			new MemberMenu().displayFail("로그인 실패");
		} else {
			new MemberMenu().displaySuccess(m.getUserName() + "님 환영합니다!");
		}
	}

}

