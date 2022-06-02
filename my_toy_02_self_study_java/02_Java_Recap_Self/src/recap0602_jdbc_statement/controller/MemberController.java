package recap0602_jdbc_statement.controller;

import java.util.ArrayList;

import recap0602_jdbc_statement.dao.MemberDao;
import recap0602_jdbc_statement.view.MemberMenu;
import recap0602_jdbc_statement.vo.Member;

public class MemberController {
	
	public void insertMember(String userId, String userPwd, String userName
						   , String gender, String age,String email
						   , String phone, String address, String hobby) {
		// 전달받은 값들을 dao 에 전달하기 위해 어딘가에 주섬주섬 담기 => Member 객체!
		Member m = new Member(userId, userPwd, userName, gender, Integer.parseInt(age), email, phone, address, hobby);
		
		int result = new MemberDao().insertMember(m);
		
		// 서비스가 성공인지 실패인지 판단 후 사용자가 보게 될 응답화면 지정
		if(result > 0) { // 성공
			new MemberMenu().displaySuccess("성공적으로 회원이 추가되었습니다.");
		} else { // 실패
			new MemberMenu().displayFail("회원 추가를 실패했습니다.");
		}
	}

	
	public void selectList() {
		ArrayList<Member> list = new ArrayList<>();
		
		if(list.isEmpty()) {
			new MemberMenu().displayNoData("조회 결과가 없습니다.");
		} else {
			new MemberMenu().displayData(list);
		}
		
		//return list;
	}
	
	public void selectByUserId(String userId) {
		Member m = new MemberDao().selectByUserId(userId);
		if(m == null ) {
			new MemberMenu().displayNoData(userId + "에  대한 검색결과가 없습니다.");
		} else {
			new MemberMenu().displayMember(m);
		}
	}
	
	public void selectByKeyword(String keyword) {
		ArrayList <Member> list = new MemberDao().selectByKeyword(keyword);
		
		if(list.isEmpty()) {
			new MemberMenu().displayNoData(keyword + "에 해당하는 검색 결과가 없습니다.");
		} else {
			new MemberMenu().displayData(list);
		}
		
		
	}
}


















