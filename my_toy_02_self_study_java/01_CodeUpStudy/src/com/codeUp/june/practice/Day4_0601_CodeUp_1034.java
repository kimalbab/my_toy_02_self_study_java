package com.codeUp.june.practice;

import java.util.Scanner;

public class Day4_0601_CodeUp_1034 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//수 입력받기
		
		String NumStr = sc.nextLine();
		int num = Integer.parseInt(NumStr);
		//String ocNum = Integer.toOctalString(num);
		//String ocNum = Integer.toString(num,8);
		int ocNum = Integer.valueOf(NumStr, 8);
		
		String ocNumStr = ocNum + "";
		//System.out.println(ocNumStr);
		
		int tenNum = Integer.parseInt(ocNumStr,10);
		System.out.println(tenNum);
	}

}
