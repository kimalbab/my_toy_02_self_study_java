package com.baekJun.practice.addStudy.june;

public class Pro01_10952_StringBuffer {

	public static void main(String[] args) {
		
		/*
		 * StringBuffer도 Builder 처럼 추가 변경 가능한 내부적 배열이 있는 String
		 * - 배열은 길이 변경이 불가하고 공간이 부족하면 새 배열 생성
		 * 		=> StringBuffer는 저장할 문자열 길이를 고려해서 적절한 크기로 생성해야함
		 * - String은 내용변경이 불가하다
		 * 		=> StringBuffer는 문자열을 추가, 삽입, 삭제가 가능
		 * - StringBuffer는 equals가 오버라이딩 되지 않아서 주소비교함!
		 * 		=> 내용이 같아도 false => String으로 변환해서 equals로 내용비교
		 */
		
		StringBuffer sb = new StringBuffer("01");
		StringBuffer sb2 = sb.append(23);
		sb.append('4').append(56);
		
		StringBuffer sb3 = sb.append(78);
		sb3.append(9.0);
		
		System.out.println("sb : " + sb.deleteCharAt(10));
		System.out.println("sb : " + sb.delete(3, 6));
		System.out.println("sb : " + sb.insert(3, "abc"));
		System.out.println("sb : " + sb.replace(6, sb.length(), "end"));
		
		System.out.println("capacity : " + sb.capacity());
		System.out.println("length : " + sb.length());
		

	}

}
