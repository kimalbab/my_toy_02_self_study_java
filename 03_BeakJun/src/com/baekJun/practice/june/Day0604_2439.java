package com.baekJun.practice.june;

import java.util.Scanner;

public class Day0604_2439 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
 
		int star = in.nextInt();
		in.close();
 
		for (int i = 1; i <= star; i++) {
			for (int j = 1; j <= star - i; j++) {
				System.out.print(" ");
			}
			for (int k = 0; k < i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
