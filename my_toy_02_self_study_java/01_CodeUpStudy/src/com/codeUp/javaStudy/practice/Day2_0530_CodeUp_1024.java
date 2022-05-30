package com.codeUp.javaStudy.practice;

import java.util.Scanner;

public class Day2_0530_CodeUp_1024 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String word = sc.nextLine();
		
		for(int i=0; i<word.length(); i++) {
			System.out.printf("'%s'\n",word.substring(i,i+1));
		}
		
	}
}
