package com.codeUp.javaStudy.practice.may;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Day3_0531_CodeUp_1027 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	
		//년월일 입력받기
		String[] strDate = sc.next().split("\\.");
		
		int[] intDate = new int[strDate.length];
		
		for(int i=0; i<strDate.length; i++) {
			intDate[i] = Integer.parseInt(strDate[i]);
		}
		

		int year = intDate[0];
		int month = intDate[1];
		int date = intDate[2];
		
		System.out.printf("%02d-%02d-%d",date, month, year);
	
		/* --> 틀림! => Wed Jan 15 00:07:00 KST 2014로 나옴
		String strDate = sc.nextLine();
		DateFormat dateFormat = new SimpleDateFormat ("yyyy.mm.dd");
		
		Date date = null;
		
		try {
			date = dateFormat.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		System.out.println(date);
		*/
		
		
		
		
		
	}

}
