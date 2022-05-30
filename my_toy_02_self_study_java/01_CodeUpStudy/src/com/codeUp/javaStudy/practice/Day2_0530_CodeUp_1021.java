package com.codeUp.javaStudy.practice;

import java.util.Scanner;

public class Day2_0530_CodeUp_1021 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//단어를 입력하세요
		
		String date = sc.nextLine();
		
		char[] datechar = new char[51];
		
		for(int i=0; i<date.length(); i++) {
			datechar[i] = date.charAt(i);
		}
		
		
		for(int i=0; i<date.length(); i++) {
			System.out.print(datechar[i]);
		}
		
		
	}

}
