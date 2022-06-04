package com.baekJun.practice.june;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Day0604_15552 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //¼±¾ð
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		try {
			int t = Integer.parseInt(br.readLine());
			for(int i=0; i < t; i++) {
				st = new StringTokenizer(br.readLine());
				bw.write((Integer.parseInt(st.nextToken()) + (Integer.parseInt(st.nextToken()) + "\n")));
			}
			
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}  finally {
			try {
				br.close();
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
