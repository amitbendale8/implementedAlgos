package com.algos;

import java.util.Scanner;

/**
 * 
 * @author amit.bendale
 *
 */
public class EditDistance {

	public static void main(String[] args) {
		String input1 = "ABCDE";
		String input2 = "ABDE";
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int size = Integer.parseInt(sc.nextLine());
		
		int[] input = new int[size];
		for(int i=0;i<size;i++){
			input1 = sc.nextLine();
			input2= sc.nextLine();
			sb.append(editDistance(input1, input2)+"\n");
		}
		
		System.out.println(sb.toString());
		
	}

	private static int editDistance(String input1, String input2) {
		int[][] score = new int[input2.length()+1][input1.length()+1];
		//No of columns: lenght of input1 + 1 and No of Rows: length of inputt2+1;
	
		for(int j=0;j<=input1.length();j++){
			score[0][j] = j;
		}
		for(int i=0;i<=input2.length();i++){
			score[i][0] = i;
		}
		for(int i=1;i<=input2.length();i++){
			for(int j=1;j<=input1.length();j++){
				if(input2.charAt(i-1) == input1.charAt(j-1)){
					score[i][j] = getMin(score[i-1][j]+1,score[i][j-1]+1,score[i-1][j-1]);
				}else{
					score[i][j] = getMin(score[i-1][j]+1,score[i][j-1]+1,score[i-1][j-1]+1);
				}
			}
		}
		return score[input2.length()][input1.length()];
	}

	private static int getMin(int a, int b, int c) {
		int smallest = a;
		if(b<smallest) 
			smallest = b;
		if(c<smallest) 
			smallest = c;
		
		return smallest;
	}

}
