package com.codeUp.javaStudy.run;

import com.codeUp.javaStudy.vo.Book;

public class BookTest {

	public static void main(String[] args) {
		Book bk1 = new Book();
		Book bk2 = new Book("ÀÚ¹ÙÀÇÁ¤¼®", 20000, 0.2, "À±»ó¼·");
		
		System.out.println(bk1.information());
		System.out.println(bk2.information());
		
		bk1.setTitle("C¾ð¾î");
		bk1.setPrice(27000);
		bk1.setDiscountRate(0.1);
		bk1.setAuthor("È«±æµ¿");
		
		System.out.println(bk1.getTitle());
		System.out.println(bk1.discountPrice());
		
		System.out.println(bk2.getTitle());
		System.out.println(bk2.discountPrice());
		
		
	}
	
}
