package com.codeUp.javaStudy.run;

import com.codeUp.javaStudy.vo.Book;

public class BookTest {

	public static void main(String[] args) {
		Book bk1 = new Book();
		Book bk2 = new Book("�ڹ�������", 20000, 0.2, "����");
		
		System.out.println(bk1.information());
		System.out.println(bk2.information());
		
		bk1.setTitle("C���");
		bk1.setPrice(27000);
		bk1.setDiscountRate(0.1);
		bk1.setAuthor("ȫ�浿");
		
		System.out.println(bk1.getTitle());
		System.out.println(bk1.discountPrice());
		
		System.out.println(bk2.getTitle());
		System.out.println(bk2.discountPrice());
		
		
	}
	
}
