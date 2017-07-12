package com.techgig;

import java.util.Scanner;

public class AdevertiseCount {

	public static void main(String[] args) {
		long peopleAtStart = 5;
		long likesCount    = 0;
		long dislikesCount = 0;
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		for(int i=0;i<n;i++){
			likesCount = (likesCount + (long) Math.floor(peopleAtStart/2));
			//dislikesCount = dislikesCount +( peopleAtStart - (long) Math.floor(peopleAtStart/2));
			peopleAtStart = 3*(long) Math.floor(peopleAtStart/2);
		}
		System.out.println(likesCount);

	}

}
