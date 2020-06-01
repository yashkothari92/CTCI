package com.practice.leetcode;

public class StepsToZero {
	public static void main(String[] args) {
		StepsToZero s = new StepsToZero();
		int num = 14;

		int steps = s.numberOfSteps(num);
		System.out.println(steps);
	}

	public int numberOfSteps(int num) {
		int counter = 0;
		while (num > 0) {
			if (num % 2 == 0) {
				num /= 2;
			} else {
				num -= 1;
			}
			counter++;
		}
		return counter;
	}
}
