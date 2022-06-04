package com.baekJun.practice.addStudy.june;

public class Pro01_10871_StringBuilder {
	
	
	/*
	 * StringBuilder는 동기화가 안되어있음!
	 */
	public static void main(String [] args) {
		StringBuilder sb = new StringBuilder();
		
		//append => 추가 메소드
		sb.append("Java ");
		sb.append("Program Study");
		System.out.println(sb.toString());
		
		
		//insert => 삽입메소드
		sb.insert(4, "2");
		System.out.println(sb.toString());
		
		sb.setCharAt(4, '6');
		System.out.println(sb.toString());
		
		
		
		//replace => 교체 메소드
		sb.replace(6, 13, "Book");
		System.out.println(sb.toString());
		
		//delete => 삭제 메소드
		sb.delete(4, 5);
		System.out.println(sb.toString());
		
		
		//length => 몇 글자인지 알아내는 메소드
		int length = sb.length();
		System.out.println("총 문자 수 : " + length);
		
		System.out.println(sb.toString());
		
	}
}
