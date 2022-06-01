package com.codeUp.javaStudy.practice.may;

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
		
		
		
		//문자로 푼다면 0의 갯수만큼 for문을 돌려서 아예 문자로 출력할 수도 있을듯.
	
	}

}
