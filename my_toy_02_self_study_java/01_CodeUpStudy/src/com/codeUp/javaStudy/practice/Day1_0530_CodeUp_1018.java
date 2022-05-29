


package com.codeUp.javaStudy.practice;

import java.util.Scanner;

public class  Day1_0530_CodeUp_1018 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
	
		String [] time = sc.next().split(":");
		int hour = Integer.parseInt(time[0]);
		int min = Integer.parseInt(time[1]);
		
		System.out.printf("%d:%d", hour, min);
		
	}

}
