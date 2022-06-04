package com.baekJun.practice.addStudy.june;

public class Pro01_10871_StringBuilder {
	
	
	/*
	 * StringBuilder�� ����ȭ�� �ȵǾ�����!
	 */
	public static void main(String [] args) {
		StringBuilder sb = new StringBuilder();
		
		//append => �߰� �޼ҵ�
		sb.append("Java ");
		sb.append("Program Study");
		System.out.println(sb.toString());
		
		
		//insert => ���Ը޼ҵ�
		sb.insert(4, "2");
		System.out.println(sb.toString());
		
		sb.setCharAt(4, '6');
		System.out.println(sb.toString());
		
		
		
		//replace => ��ü �޼ҵ�
		sb.replace(6, 13, "Book");
		System.out.println(sb.toString());
		
		//delete => ���� �޼ҵ�
		sb.delete(4, 5);
		System.out.println(sb.toString());
		
		
		//length => �� �������� �˾Ƴ��� �޼ҵ�
		int length = sb.length();
		System.out.println("�� ���� �� : " + length);
		
		System.out.println(sb.toString());
		
	}
}
