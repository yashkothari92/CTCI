package com.practice.leetcode;

public class StudentsDoingHW {
	public static void main(String[] args) {
		StudentsDoingHW s = new StudentsDoingHW();
		int[] startTime = {9,8,7,6,5,4,3,2,1};
		int[] endTime = {10,10,10,10,10,10,10,10,10};
		int queryTime = 5;
		
		int students = s.busyStudent(startTime, endTime, queryTime);
		System.out.println(students);
	}
	
	 public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
	        int counter = 0;
	        for(int k = 0; k<startTime.length; k++){
	            if(endTime[k] >= queryTime) {
	                if(startTime[k] <= queryTime){
	                    counter++;
	                }
	            }
	        }
	        
	        return counter;
	    }
}
