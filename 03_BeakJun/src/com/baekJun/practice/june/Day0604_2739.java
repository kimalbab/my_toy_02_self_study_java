package com.baekJun.practice.june;

import java.util.Scanner;

public class Day0604_2739 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		
		int i = sc.nextInt();
		
		for(int j = 1; j <= 9; j++) {
			System.out.println(i + " * " + j + " = " + (i*j));
		}
	}

}
