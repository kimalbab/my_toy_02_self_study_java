package com.vo.retryCollection;

import java.util.ArrayList;
import java.util.Scanner;

public class RetryBookMenu {

	private RetryBookController rbc = new RetryBookController();
	private Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		System.out.println("----------welcome---------");
		
		while (true) {
			System.out.println("----------main menu---------");
			System.out.println("1. 새 도서 추가");
			System.out.println("2. 도서 전체 조회");
			System.out.println("3. 도서 검색 조회");
			System.out.println("4. 도서 삭제하기");
			
			System.out.println("0. 프로그램 종료하기");
			
			System.out.print("메뉴 선택 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1 : insertBook(); break;
			case 2 : selectBook(); break;
			case 3 : searchBook(); break;
			case 4 : deleteBook(); break;
			case 0 : System.out.println("프로그램을 종료합니다."); return;
			default : System.out.println("잘못입력했습니다. 다시 입력해주세요."); break;
			}
		}
	}
	
	// 1. 새 도서 추가용 view 메소드
	public void insertBook() {
		
		System.out.print("책 이름을 입력하세요");
		String title = sc.nextLine();
		
		System.out.println("저자명을 입력하세요");
		String author = sc.nextLine();
		
		System.out.println("장르명 번호를 입력하세요 (1.인문 / 2.자연과학 / 3.의료 / 4.기타)0");
		int category = sc.nextInt();
		
		sc.nextLine();
		
		System.out.println("가격을 입력하세요");
		int price = sc.nextInt();
		
		rbc.insertBook(title, author, category, price);
		System.out.println("정상적으로 책이 추가되었습니다.");
		
	}
	
	
	
	public void selectBook() {
		ArrayList<RetryBook> bookList = rbc.selectBook();
		
		if(bookList.isEmpty()) {
			System.out.println("책 리스트가 비어 있습니다.");
		} else  {
			for(int i = 0; i<bookList.size(); i++) {
				System.out.println(bookList.get(i));
			}
		}
	}
	
	

	public void searchBook() {
		System.out.print("검색하고자 하는 도서명 : ");
		String keyword = sc.nextLine();
		ArrayList <RetryBook> searchList = new ArrayList <> ();
		searchList= rbc.searchBook(keyword);
		
		if(searchList.isEmpty()) {
			System.out.println("책 리스트가 비어 있습니다.");
		} else  {
			for(int i = 0; i<searchList.size(); i++) {
				System.out.println(searchList.get(i));
			}
		}
	}
	
	
	
	public void deleteBook() {
		/*
		 * 1. 사용자가 입력한 도서명과 저자명이 일치할 경우 성공적으로 삭제 될 것이고, 그게 아닐 경우 삭제할 도서를 찾지 못한 경우이다.
		 *    그래서 이를 처리하기 위한 result 변수를 0으로 초기화 한 채로 만들어 두자.
		 * 2. 반복문을 통해 bookList의 책들 중 책명이 전달받은 title과 동일하고, 저자명이 전달받은 author와 동일한 경우 
		 *    해당 인덱스의 도서 "삭제"하고 result 1로 변경 후 빠져나가기(더이상 반복문을 돌릴 필요없으니깐 break!)
		 * 
		 * 3. result 값 반환
		 */
		
		System.out.print("도서명 : ");
		String title = sc.nextLine();
		
		System.out.print("저자명 : ");
		String author = sc.nextLine();
		
		int result = rbc.deleteBook(title, author);
		
		if(result == 1 ) {
			selectBook();
			System.out.println("선택한 책이 삭제외었습니다.");
			} else {
				System.out.println("삭제된 책이 없습니다.");
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
