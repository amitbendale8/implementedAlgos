package com.algos;

import java.util.Scanner;

/**
 * Program to find longest common subsequence between two strings
 * @author amit.bendale
 *
 */
public class LongestCommonSubsequence {

	public static void main(String[] args) {
		String input1 = "ABCDEF";
		String input2 = "KSBSDFCWERF";
		Scanner sc = new Scanner(System.in);
		//int line1Size = sc.nextInt();
		//int line2Size = sc.nextInt();
		String line1 ="1 2 3 4 1"; //sc.nextLine();
		String line2 = "3 4 1 2 1 3";//sc.nextLine();
		line1 = line1.replaceAll(" ", "");
		line2 = line2.replaceAll(" ", "");
		
		System.out.println(LCS(line1,line2));

	}
	
	private static int LCS(String input1,String input2) {
		int[][] score = new int[input2.length()+1][input1.length()+1];
		//No of columns: lenght of input1 + 1 and No of Rows: length of inputt2+1;
	
		for(int j=0;j<=input1.length();j++){
			score[0][j] = 0;
		}
		for(int i=0;i<=input2.length();i++){
			score[i][0] = 0;
		}
		for(int i=1;i<=input2.length();i++){
			for(int j=1;j<=input1.length();j++){
				if(input2.charAt(i-1) == input1.charAt(j-1)){
					score[i][j] = getMax(score[i-1][j],score[i][j-1],score[i-1][j-1]+1);
				}else{
					score[i][j] = getMax(score[i-1][j],score[i][j-1],score[i-1][j-1]);
				}
			}
		}
		return score[input2.length()][input1.length()];
	}

	private static int getMax(int a, int b, int c) {
		int max = a;
		if(b > a){
			max = b;
		}
		if(c > b){
			max = c;
		}
		return max;
	}

}
