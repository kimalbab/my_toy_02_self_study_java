package com.baekJun.practice.june;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Day0604_10951 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		while(sc.hasNextInt()) {
			
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(a + b);
			
		}

	}
	
	public static void main2(String [] args) {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		String str;
		
		try {
			while((str = br.readLine()) != null ) {
				
				st = new StringTokenizer(str," ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				sb.append(a+b).append("\n");
				
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println(sb);
		
	}

}
