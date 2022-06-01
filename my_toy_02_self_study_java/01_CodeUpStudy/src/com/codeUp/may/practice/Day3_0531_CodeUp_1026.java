package com.codeUp.javaStudy.practice.may;

import java.util.Scanner;

public class Day3_0531_CodeUp_1026 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//시간을 입력하세요.
		String [] strTime = sc.next().split(":");
		
		int [] arr = new int[strTime.length];
		
		for(int i = 0; i<strTime.length; i++) {
			arr[i] = Integer.parseInt(strTime[i]);
		}
		
		int h = arr[0];
		int m = arr[1];
		int s = arr[2];
		
		System.out.println(m);
		
	}

}
