package com.baekJun.practice.june;

import java.util.Scanner;

public class Day0603_2884 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int h = sc.nextInt();		
		int m = sc.nextInt();
		
		if(h == 0) {
			if(m>=45) {
				System.out.printf("%d %d", h, m-45);
			} else {
				System.out.printf("23 %d", 60-Math.abs(m-45));
			}
		} else {
			if(m>=45) {
				System.out.printf("%d %d", h, m-45);
			} else {
				System.out.printf("%d %d", h, 60-Math.abs(m-45));
			}
		}
	}
}
