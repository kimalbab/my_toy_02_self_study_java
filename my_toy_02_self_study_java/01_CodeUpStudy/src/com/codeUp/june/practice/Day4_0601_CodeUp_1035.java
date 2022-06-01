package com.codeUp.june.practice;

import java.util.Scanner;

public class Day4_0601_CodeUp_1035 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//수 입력받기
		char cnum = sc.next().charAt(0);
		int num = cnum;
		System.out.println(num);
		//String numStr = num + "";
		//String hxNumStr = Integer.toHexString(num);
		
		//System.out.println(hxNumStr);
		String hxNum = Integer.toHexString(num);
		System.out.println(hxNum);
	}

}
