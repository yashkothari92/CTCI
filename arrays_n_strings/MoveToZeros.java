package com.practice.leetcode;

import java.util.Arrays;

import sun.security.util.Length;

public class MoveToZeros {

	public static void main(String[] args) {
		int arr[] = {0,0,1};
		moveZeroes(arr);
		
		Arrays.stream(arr).forEach(System.out::println);
	}
	
    public static void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0) {
        	return;
        }
    	
    	int q = 0;
        for(int p=0; p<nums.length; p++){
            if(nums[p] != 0) {
               nums[q] = nums[p];
               q++;
            }
        }
        
        for(int m = q; m<nums.length; m++) {
        	nums[m] =0;
        }
    }

}
