package com.baekJun.practice.june;

import java.util.Scanner;

public class Day0604_2480 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();
		
		int [] numArr = { num1, num2, num3 }; 
		int max = numArr[0];
		for(int i=0; i<numArr.length; i++){
			if(numArr[i] > max) {
				max = numArr[i];
			}
		}
		
		if(num1 == num2) {
			if(num2 == num3) {
				System.out.println(10000 + (num1 * 1000));
			} else {
				System.out.println(1000 + (num1 * 100));
			}
		} else if (num1 == num3) {
				System.out.println(1000 + (num1 * 100));
			}
		 else if (num2 == num3) {
			 	System.out.println(1000 + (num2 * 100));
		 } else {
			 System.out.println(max * 100);
		 }
	}
	

}
