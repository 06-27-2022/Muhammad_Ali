package com.revature;

public class SummingNumbers {
	int getSum(int[] arr) {
		int sum = 0;
		
		for(int num: arr) {
			sum += num;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		int[] myArr = {3,7,4};
		SummingNumbers calculator = new SummingNumbers();
		
		System.out.println("Sum: " + calculator.getSum(myArr));
	}
}
