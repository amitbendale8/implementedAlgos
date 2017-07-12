package com.techgig;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class DetectFraud {
	PriorityQueue<Integer> minHeap;
	PriorityQueue<Integer> maxHeap;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String primaryInput = in.nextLine();
		int n = Integer.parseInt(primaryInput.split(" ")[0]);
		int d = Integer.parseInt(primaryInput.split(" ")[1]);
		int alertCounter = 0;
		String expenditureStr = in.nextLine();
		String[] expenditureArr = expenditureStr.split(" ");
		int[] expenditureNumArr = new int[expenditureArr.length];
		for(int i=0;i<expenditureArr.length;i++){
			expenditureNumArr[i] = Integer.parseInt(expenditureArr[i]);
		}
		DetectFraud dFraud = new DetectFraud();
		ArrayList<Double> medians = dFraud.medianSlidingWindow(expenditureNumArr,d);
		int medianCounter=1;
		for(int i=d;i<expenditureArr.length;i++){
			if (expenditureNumArr[i] >= (2*medians.get(medianCounter))){
				alertCounter++;
				medianCounter++;
			}
		}
		
		
	}
	
	
	
	public  ArrayList<Double> medianSlidingWindow(int[] nums, int k) {
    	ArrayList<Double> rst = new ArrayList<Double>();
    	if (nums == null || nums.length == 0 || k <= 0) {
    		return rst;
    	}
    	minHeap = new PriorityQueue<Integer>();
    	maxHeap = new PriorityQueue<Integer>(10, new Comparator<Integer>(){
    		public int compare(Integer x, Integer y){
    			return y - x;
    		}
    	});
    	maxHeap.offer(nums[0]);

    	for (int i = 1; i < k; i++) {
    		add(nums[i]);
    	}
    	if(maxHeap.size() == minHeap.size()){
    		rst.add((new Double(maxHeap.peek())+new Double(minHeap.peek()))/2);
    	}else if(maxHeap.size() > minHeap.size()){
    		rst.add(new Double(maxHeap.peek()));
    	}else{
    		rst.add(new Double(minHeap.peek()));
    	}
    	
    	for (int i = k; i < nums.length; i++) {
    		add(nums[i]);
    		remove(nums[i - k]);
    		if(maxHeap.size() == minHeap.size()){
        		rst.add(new Double((new Double(maxHeap.peek())+new Double(minHeap.peek()))/2));
        	}else if(maxHeap.size() > minHeap.size()){
        		rst.add(new Double(maxHeap.peek()));
        	}else{
        		rst.add(new Double(minHeap.peek()));
        	}
    	}
    	return rst;
    }

    public void add(int val) {
    	int preMedian = maxHeap.peek();
		if (val > preMedian) {
			minHeap.offer(val);
		} else {
			maxHeap.offer(val);
		}
		balance();
    }

    public void remove(int val) {
        int preMedian = maxHeap.peek();
        if (val > preMedian) {
            minHeap.remove(val);
        } else {
            maxHeap.remove(val);
        }
    	balance();
    }

    public void balance() {
    	if (maxHeap.size() > minHeap.size() + 1) {
			minHeap.offer(maxHeap.poll());
		} else if (maxHeap.size() < minHeap.size()) {
			maxHeap.offer(minHeap.poll());
		}
    }

}

