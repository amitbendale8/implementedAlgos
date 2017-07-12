package codility;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class SingleSwap {

	public static void main(String[] args) {
		int input[] = {1,5,3,3,7};
		//boolean val= singleSwap(input);
		
		ArrayList<Integer> numList = new ArrayList();
		numList.add(0);
		numList.add(1);
		Collections.reverse(numList);
	
		
		int stop = 2;
		stop++;

	}

	private static boolean singleSwap(int[] input) {
		
		boolean flag=true;
		for(int i=input.length-1;i>0;i--){
			if(input[i] <= input[i-1]){
				int j = i-1;
				//Binary search for this.
	            while (j>=0 && input[i] <= input[j])
	                j--;
	            
	            int temp = 	input[i];
	            input[i] = input[j+1];
	            input[j+1] = temp;
	            break;
			}
			
		}
		
		
		for(int i=0;i<input.length-1;i++){
			if(input[i]>input[i+1]){
				flag =false;
			}
		}
		
		return flag;	
		
	}
	

}
