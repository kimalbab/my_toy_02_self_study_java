package com.codeUp.javaStudy.practice;

import java.util.Scanner;

public class Day2_0530_CodeUp_1020 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);	
		// �ֹι�ȣ �Է¹ޱ�
		String [] ssnStr = sc.next().split("-");
		
		

		int fstSsn = Integer.parseInt(ssnStr[0]);
		int secSsn = Integer.parseInt(ssnStr[1]);
		
		System.out.printf("%06d%d", fstSsn, secSsn);
		// �� �׳� %d�� �ϸ� 0�� ����������� �𸣰���
	}

}
