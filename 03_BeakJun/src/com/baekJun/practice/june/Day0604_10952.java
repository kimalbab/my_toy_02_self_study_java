package com.baekJun.practice.june;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Day0604_10952 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		while (true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if(a == 0 && b == 0) {
				break;
			} 
			System.out.println(a + b);
		}
	}
	
	/*
	 * 스캐너를 쓰면 시간이 많이 걸려서 BufferedReader를 사용
	 * 
	 */
	
	public static void main2(String [] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			try {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(a == 0 && b == 0) {
					break;
				}
				
				sb.append(a + b).append(("\n"));
				
				
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			System.out.println(sb);
		}
	}

}
