package com.codeUp.june.practice;

import java.util.Scanner;

public class Day5_0602_CodeUp_1039 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 정수식 입력받기
		String calcul = sc.nextLine();
		String[] calculArr = calcul.split("\\s");
		long [] numCalculArr = new long [calculArr.length];
		
	
		
		// 숫자로 변환하기
		for(int i = 0; i<calculArr.length; i++) {
		numCalculArr[i] = Integer.parseInt(calculArr[i]);
		}
		
		System.out.println(numCalculArr[0] + numCalculArr[1]);
		
	}

}