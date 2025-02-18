package maxTotalNoAdjacent;

import java.util.Scanner;

public class MaximumSum {
	/*Function to return max sum such that no two elements 
	      are adjacent */
	int findMaximumSum(int arr[], int n) 
	{ 
		int includingVar = arr[0]; 
		int excludingVar = 0; 
		int excludingTemp; 
		int i; 

		for (i = 1; i < n; i++) 
		{ 
			/* current max excluding i */
			if(includingVar > excludingVar) { 
				excludingTemp =  includingVar;
			}
			else {
				excludingTemp =  excludingVar; 
			}
			/* current max including i */
			includingVar = excludingVar + arr[i]; 
			excludingVar = excludingTemp; 
		} 

		/* return max of includingVar and excludingVar */
		if(includingVar > excludingVar) 
			
			return includingVar; 
		else 
			return excludingVar;
	} 

	// Driver program to test above functions 
	public static void main(String[] args) 
	{ 
		MaximumSum sum = new MaximumSum();
		Scanner input = new Scanner(System.in);
		System.out.println("How many Stores do you need?  ");
		int storeCount = input.nextInt();
		int storeArray[] = new int[storeCount];
		for (int i = 0; i<storeCount; i++ ) {
			System.out.print("\nPlease Input coupon for Store "+(i+1) + ": ");
			storeArray[i] = input.nextInt();
		}

		System.out.print("\nMaximum Sum = "+sum.findMaximumSum(storeArray, storeCount)); 
	} 
} 


