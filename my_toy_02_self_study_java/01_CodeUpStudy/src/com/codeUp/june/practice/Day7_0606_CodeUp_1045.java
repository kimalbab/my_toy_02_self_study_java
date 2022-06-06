package com.codeUp.june.practice;

import java.util.Scanner;

public class Day7_0606_CodeUp_1045 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		double aa = (double)a;
		double bb = (double)b;
		double cc = aa / bb;
		
		System.out.println(a + b);
		System.out.println(a - b);
		System.out.println(a * b);
		System.out.println(a / b);
		System.out.println(a % b);
		System.out.printf("%.2f", cc);
		
	}

}
