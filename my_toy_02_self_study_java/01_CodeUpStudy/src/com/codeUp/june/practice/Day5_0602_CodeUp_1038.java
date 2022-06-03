package com.codeUp.june.practice;

import java.util.Scanner;

public class Day5_0602_CodeUp_1038 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 그것도 보완
		System.out.println(sc.nextLong() + sc.nextLong());
		// int 자료형에서는 띄어쓰기시 자동으로 수로 인식하는가? > yes
		
		/* 처음 풀이 > 틀렸던 이유 : int 형에 담았는데 long 형에 담았어야 했다.
		String calcul = sc.nextLine();
		String[] calculArr = calcul.split("\\s");
		long [] numCalculArr = new long [calculArr.length];
		
		
		for(int i = 0; i<calculArr.length; i++) {
		numCalculArr[i] = Integer.parseInt(calculArr[i]);
		}
		
		System.out.println(numCalculArr[0] + numCalculArr[1]);
*/
	}

}

