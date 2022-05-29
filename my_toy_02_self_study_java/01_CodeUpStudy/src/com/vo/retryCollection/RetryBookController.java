package com.vo.retryCollection;

import java.util.ArrayList;
import com.vo.retryCollection.*;

public class RetryBookController {
	
		//도서들을 담고있는 booklist
		private ArrayList<RetryBook> reBookList = new ArrayList<RetryBook>();
		{
			reBookList.add(new RetryBook("자바의정석", "홍길동", "기타", 20000));
			reBookList.add(new RetryBook("C언어", "김말똥", "기타", 15000));
			reBookList.add(new RetryBook("도움이 되었나요", "강보람", "인문", 17500));
			reBookList.add(new RetryBook("여러분", "KH", "의료", 10000));
		}
		
		
	public void insertBook (String title, String author, int category, int price) {
		/*
		 * 1. 전달받은 값들을 가지고 매개변수 생성자를 이용하여 Book 객체 생성 
		 *    (단, 객체 생성 시  유의사항 :장르 번호별로 조건식 이용해서 장르번호가 아닌 장르명을 전달하면서 생성!)
		 * 2. bookList에 1번과정에서 생성된 Book객체 추가
		 */
		
		//1.
		String categoryStr = "";
		
		switch(category) {
		case 1 : categoryStr = "인문"; break;
		case 2 : categoryStr = "자연과학"; break;
		case 3 : categoryStr = "의료"; break;
		case 4 : categoryStr = "기타"; break;
		}
		
		RetryBook rbk = new RetryBook(title, author, categoryStr, price);
		
		//2. book 객체 추가
		reBookList.add(rbk);
		
	}
	
	public ArrayList<RetryBook> selectBook () {
		return reBookList;
	}
	
	
	public ArrayList <RetryBook> searchBook(String keyword) {
		
		ArrayList <RetryBook> searchList = new ArrayList <> ();
		
		for(int i = 0; i<reBookList.size(); i ++) {
			if(reBookList.get(i).getTitle().contains(keyword)) {
				searchList.add(reBookList.get(i));
				
			}
		}
		return searchList;
		
	}
	
	public int deleteBook (String title, String author) {
		
		int result = 0;
		
		for(int i = 0; i<reBookList.size(); i++) {
			if(reBookList.get(i).getTitle().contains(title)
					&& (reBookList.get(i).getAuthor().contains(author))) {
				reBookList.remove(i);
				result = 1;
			}
		}
		
		return result;
		
	}

}
