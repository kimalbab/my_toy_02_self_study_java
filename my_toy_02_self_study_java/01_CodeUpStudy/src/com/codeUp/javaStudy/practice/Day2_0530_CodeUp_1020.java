package com.codeUp.javaStudy.practice;

import java.util.Scanner;

public class Day2_0530_CodeUp_1020 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);	
		// 주민번호 입력받기
		String [] ssnStr = sc.next().split("-");
		
		

		int fstSsn = Integer.parseInt(ssnStr[0]);
		int secSsn = Integer.parseInt(ssnStr[1]);
		
		System.out.printf("%06d%d", fstSsn, secSsn);
		// 왜 그냥 %d를 하면 0이 사라지는지는 모르겠음
	}

}
