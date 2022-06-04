package com.baekJun.practice.addStudy.june;

public class Pro01_10952_StringBuffer {

	public static void main(String[] args) {
		
		/*
		 * StringBuffer�� Builder ó�� �߰� ���� ������ ������ �迭�� �ִ� String
		 * - �迭�� ���� ������ �Ұ��ϰ� ������ �����ϸ� �� �迭 ����
		 * 		=> StringBuffer�� ������ ���ڿ� ���̸� ����ؼ� ������ ũ��� �����ؾ���
		 * - String�� ���뺯���� �Ұ��ϴ�
		 * 		=> StringBuffer�� ���ڿ��� �߰�, ����, ������ ����
		 * - StringBuffer�� equals�� �������̵� ���� �ʾƼ� �ּҺ���!
		 * 		=> ������ ���Ƶ� false => String���� ��ȯ�ؼ� equals�� �����
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
