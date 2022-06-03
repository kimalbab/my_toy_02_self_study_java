package com.baekJun.practice.june;

import java.util.Scanner;

public class Day0603_2588 {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		int num1 = sc.nextInt();		
		int num2 = sc.nextInt();
		
		int num3 = (num1 * (num2 % 10) * 1);
		int num4 = (num1 * ((num2 / 10) % 10));
		int num5 = (num1 * (num2 / 100) );
		int num6 = num3 + (num4 * 10) + (num5 * 100);
		
		System.out.printf("%d\n%d\n%d\n%d\n", num3, num4, num5, num6);
		
		
	}

}
