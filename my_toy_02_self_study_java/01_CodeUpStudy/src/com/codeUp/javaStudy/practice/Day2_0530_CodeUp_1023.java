package com.codeUp.javaStudy.practice;

import java.util.Scanner;

public class Day2_0530_CodeUp_1023 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//  실수 1개 입력받기
		
		String[] fnum = sc.next().split("\\.");
		
		int dd = Integer.parseInt(fnum[0]);
		int ff = Integer.parseInt(fnum[1]);
		
		System.out.println(dd);
		System.out.println(ff);
	
		
	}

}
