package com.algos;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ShortestDistance {
	public static int[] distance;
	public static int numNodes;
	public static int[][] adjacencyMatrix;
	
	public static Set<Integer> settled = new HashSet();
	public static Set<Integer> unsettled = new HashSet();
	

	public static void main(String[] args) {
		System.out.println("Enter Number of Nodes: ");
		Scanner sc = new Scanner(System.in);
		
		numNodes = sc.nextInt();
		
		adjacencyMatrix = new int[numNodes][numNodes];
		System.out.println("Enter Matrix");
		for(int i=0;i<numNodes;i++){
			for(int j=0;j<numNodes;j++){
				adjacencyMatrix[i][j] = sc.nextInt();
			}
		}
		
		System.out.println("Enter Source Node: ");
		int sourceNode = sc.nextInt();
		initialize(sourceNode);
		shortesPath(sourceNode);
		System.out.println("Done");

	}
	
	private static void initialize(int sourceNode) {
		distance = new int[adjacencyMatrix[0].length];
		distance[sourceNode] = 0;
		for(int i=0;i<distance.length;i++){
			distance[i] = i==sourceNode ? 0 : Integer.MAX_VALUE;
			unsettled.add(i);
		}
		
	}

	public static int[] shortesPath(int source){
		int nearestNode = -1;
		int currentNode = -1;
		while(!unsettled.isEmpty()){
			currentNode = getMin();
			for(int i:unsettled){
				if(distance[currentNode] + adjacencyMatrix[currentNode][i] < distance[i] ){
					distance[i] = distance[currentNode] + adjacencyMatrix[currentNode][i];
				}
			}
		}
		
		return distance;
	}

	private static int getMin() {
		int min = Integer.MAX_VALUE;
		int index = -1;
		for(int i:unsettled){
			if(distance[i] < min){
				min = distance[i];
				index = i;
			}
		}
		unsettled.remove(index);
		return index;
	}

}
