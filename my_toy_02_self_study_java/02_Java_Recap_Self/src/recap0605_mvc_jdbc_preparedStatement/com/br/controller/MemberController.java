package recap0605_mvc_jdbc_preparedStatement.com.br.controller;

import java.util.ArrayList;

import recap0605_mvc_jdbc_preparedStatement.com.br.dao.MemberDao;
import recap0605_mvc_jdbc_preparedStatement.com.br.view.MemberMenu;
import recap0605_mvc_jdbc_preparedStatement.com.br.vo.Member;

public class MemberController {
	
	public void enroll(String userId, String userPwd, String userName, String gender,
				String age, String email, String phone, String address, String hobby) {
		
		Member m = new Member();
		 
		m.setUserId(userId);
		m.setUserPwd(userPwd);
		m.setUserName(userName);
		m.setGender(gender);
		m.setAge(Integer.parseInt(age));
		m.setEmail(email);
		m.setPhone(phone);
		m.setAddress(address);
		m.setHobby(hobby);
		
		
		int result = new MemberDao().enroll(m);
		
		if(result > 0) {
			new MemberMenu().displaySuccess(m.getUserName() + "님 환영합니다.");
		} else {
			new MemberMenu().displayFail("회원 가입 실패!");
		}
	}
	
	public void update(String userId, String userPwd, String phone) {
		
		Member m = new Member();
		
		m.setUserId(userId);
		m.setUserPwd(userPwd);
		m.setPhone(phone);
		
		int result = new MemberDao().update(m);
		
		if(result > 0) {
			new MemberMenu().displaySuccess("회원정보 수정 완료!");	
		} else {
			new MemberMenu().displayFail("수정 실패!");
		}
	}
	
	public void delete(String searchId) {
		
		int result = new MemberDao().delete(searchId);
		
		if(result > 0) {
			new MemberMenu().displaySuccess("회원 탈퇴 완료!");	
		} else {
			new MemberMenu().displayFail("탈퇴 실패!");
		}
		
	}
	
	public void login(String userId, String userPwd) {
		Member m = new MemberDao().login(userId, userPwd);
		
		if(m == null) {
			new MemberMenu().displayFail("로그인 실패!");
		} else {
			new MemberMenu().displaySuccess(m.getUserName() + "님 환영합니다!");
		}
	}
	
	public void allList() {
		ArrayList<Member> allList = new MemberDao().allList();
		
		if(allList.isEmpty()) {
			new MemberMenu().displayFail("회원 조회 실패!");
		} else {
			new MemberMenu().displayList(allList);
		}
	}
	
	public void idSearch(String searchId) {
		Member m = new MemberDao().idSearch(searchId);
		
		if(m == null) {
			new MemberMenu().displayFail("검색되는 회원이 없습니다!");
		} else {
			new MemberMenu().displayMember(m);
		}
	}
	
	public void searchName(String keyword) {
		ArrayList<Member> searchList = new MemberDao().searchName(keyword);
		if(searchList.isEmpty()) {
			new MemberMenu().displayFail("회원 조회 실패!");
		} else {
			new MemberMenu().displayList(searchList);
		}
	
	}

}
