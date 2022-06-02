package com.codeUp.june.practice;

import java.util.Scanner;

public class Day5_0602_CodeUp_1038 {

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

/* 인트 형 안에 넣어줘야함
- 총 7개 중 6번째 테스트 케이스 - 
점수 = 71 / 100

입력:
1073741824 1073741824
*/