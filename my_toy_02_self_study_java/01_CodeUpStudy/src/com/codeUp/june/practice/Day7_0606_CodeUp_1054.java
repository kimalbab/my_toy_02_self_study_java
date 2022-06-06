package com.codeUp.june.practice;

import java.util.Scanner;

public class Day7_0606_CodeUp_1054 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		if(a == b && b == 1) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

}
