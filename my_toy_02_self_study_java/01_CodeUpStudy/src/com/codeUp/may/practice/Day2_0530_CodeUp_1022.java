package com.codeUp.javaStudy.practice.may;

import java.util.Scanner;

public class Day2_0530_CodeUp_1022 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//������ �ִ� ���� �Է¹ޱ�
		String dataStr = sc.nextLine();
		
		char[] dataChar = new char[dataStr.length()];
		
		for(int i = 0; i<dataStr.length(); i++) {
			dataChar[i] = dataStr.charAt(i);
		}
		
		
		for(int i = 0; i<dataChar.length; i++) {
			System.out.print(dataChar[i]);
		}
	}

}
