package com.codeUp.may.practice;

import java.util.Scanner;

public class Day2_0530_CodeUp_1025 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String nums = sc.nextLine();
		
		char[] charArr = new char [nums.length()];
		
		for(int i=0; i<nums.length(); i++) {
			charArr[i] = nums.charAt(i);
		}
		
		
		int [] intArr = new int [charArr.length];
		
		for(int i=0; i<intArr.length; i++) {
			intArr[i] = Character.getNumericValue(charArr[i]);
		}
		
		
		int man = intArr[0] * 10000;
		int thou = intArr[1] * 1000;
		int hund = intArr[2] * 100;
		int tenx = intArr[3] * 10;
		int one = intArr[4] * 1;
		
		System.out.printf("[%d]\n[%d]\n[%d]\n[%d]\n[%d]", man, thou, hund, tenx, one);
		
		
		
		//���ڷ� Ǭ�ٸ� 0�� ������ŭ for���� ������ �ƿ� ���ڷ� ����� ���� ������.
	
	}

}
