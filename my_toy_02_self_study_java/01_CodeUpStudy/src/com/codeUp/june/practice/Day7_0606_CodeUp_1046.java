package com.codeUp.june.practice;

import java.util.Scanner;

public class Day7_0606_CodeUp_1046 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		double avg = (a + b + c) / 3.0;
		
		System.out.println(a + b + c);
		System.out.printf("%.1f", avg);

	}

}
