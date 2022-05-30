package com.codeUp.javaStudy.practice;

import java.util.Scanner;

public class Day2_0530_CodeUp_1025 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String nums = sc.nextLine();
		
		int[] numArr = new int[nums.length()];
		
		for(int i=0; i<nums.length(); i++) {
			numArr[i] = nums.charAt(i);
		}
		
		
		
		for(int i=0; i<numArr.length; i++) {
			System.out.println(numArr[i]);
		}
		
	}

}
