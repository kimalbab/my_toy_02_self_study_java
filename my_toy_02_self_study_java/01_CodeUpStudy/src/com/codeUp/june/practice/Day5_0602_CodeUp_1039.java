package com.codeUp.june.practice;

import java.util.Scanner;

public class Day5_0602_CodeUp_1039 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// ������ �Է¹ޱ�
		String calcul = sc.nextLine();
		String[] calculArr = calcul.split("\\s");
		long [] numCalculArr = new long [calculArr.length];
		
	
		
		// ���ڷ� ��ȯ�ϱ�
		for(int i = 0; i<calculArr.length; i++) {
		numCalculArr[i] = Integer.parseInt(calculArr[i]);
		}
		
		System.out.println(numCalculArr[0] + numCalculArr[1]);
		
	}

}