package com.baekJun.practice.june;

import java.util.Scanner;

public class Day0604_2438 {

	public static void main1(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int star = sc.nextInt();
		
		for(int i=0; i<star; i++) {
			System.out.print("*");
			for(int j=0; j<i; j++) {
				System.out.print("*");
			} System.out.println();
		}
	
		
		
				
	}
	
	public static void main2(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int star = sc.nextInt();
		
		for(int i=0; i<star; i++) {
			System.out.print("*");
			for(int j=star; j>0; j--) {
				System.out.print("*");
			} System.out.println();
		
		}
	}

}
