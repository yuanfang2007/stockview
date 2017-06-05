package com.rapidhelper.interview;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
	
	public static int findMaxRectrange(int[] hist){
		Stack<Integer> stack = new Stack<>();
		int maxArea = 0;
		int i=0;
		while(i< hist.length){
			if(stack.isEmpty() || hist[i] > hist[stack.peek()]){
				stack.push(i);
				i++;
			} else {
				int last = stack.peek();
				stack.pop();
				int prev = (stack.isEmpty() ? 0 : stack.peek());
				int tempArea = hist[last] * (i - 1 - prev);
				if (maxArea < tempArea) {
					maxArea = tempArea;
				}
			}

		}
		while(!stack.isEmpty()){
			int last = stack.peek();
			stack.pop();
			int prev = (stack.isEmpty()? 0 : stack.peek());
			int tempArea = hist[last]*(i-1-prev);
			if(maxArea < tempArea){
				maxArea = tempArea;
			}
		}
		return maxArea;
	}
	
	public static int findMaxSubArray(int[] array){
		int maxGlobal = 0;
		int maxCurrent = 0;
		for(int i=0; i< array.length; i++){
			maxCurrent = Math.max(array[i], maxCurrent + array[i]);
			if(maxCurrent > maxGlobal){
				maxGlobal = maxCurrent;
			}
		}
		
		return maxGlobal;
	}
	
	public static int longestCommonString(String str1, String str2){
		int [][] lcs = new int[str1.length()][str2.length()];
		for(int i=0; i< str1.length(); i++){
			for(int j=0; j< str2.length(); j++){
				if(str1.charAt(i) == str2.charAt(j)){
					if(i-1>=0 && j-1>=0){
						lcs[i][j] = lcs[i-1][j-1]+1;
					}else{
						lcs[i][j]=1;
					}
				}else{
					lcs[i][j]=0;
				}
			}
		}
		int max =0;
		for(int i=0; i<str1.length(); i++){
			for(int j=0; j<str2.length(); j++){
				if(lcs[i][j] > max){
					max = lcs[i][j];
				}
			}
		}
		return max;
	}
	
	

	static int getNumberZerosAndMoveZeroToRight(int[] numbers) {
		int j = 0;
		int countOfZero = 0;
		for (int i = 0; i < numbers.length; i++) {
			
			if (numbers[i] == 0) {
				if (j <= i) {
					j = i + 1;
					countOfZero++;
				}
				while (j < numbers.length && numbers[j] == 0) {
					j += 1;
					countOfZero++;
				}

				if (j >= numbers.length) {
					return countOfZero;
				}
				numbers[i] = numbers[j];
				numbers[j] = 0;
				j++;
				
			}
		}
		return countOfZero;
	}
	
	//leetcode 389
	static char findTheDifference(String s, String t){
		char[] sCharArray = s.toCharArray();
		char[] tCharArray = t.toCharArray();
		Arrays.sort(sCharArray);
		Arrays.sort(tCharArray);
		System.out.println(Arrays.toString(sCharArray));
		System.out.println(Arrays.toString(tCharArray));
		for(int i=0; i<sCharArray.length; i++){
			if(sCharArray[i] != tCharArray[i]){
				return tCharArray[i];
			}
		}
		return tCharArray[tCharArray.length-1];
	}
	
	 static int lengthLongestPath(String input) {
		 int maxLength = 0;
		 int[] lengthOfLevel = new int[input.lastIndexOf("\t") + 3];
		 for(String s: input.split("\n")){
			 int level = s.lastIndexOf("\t")+1;
			 lengthOfLevel[level+1] = lengthOfLevel[level] + s.length()-level+1;
			 if(s.contains(".")){
				 maxLength = Math.max(maxLength, lengthOfLevel[level+1] -1);
			 }
		 }
		 return maxLength;
	 }
	 
	 public static int firstUniqChar(String s) {
	        int[] countOfAscii = new int[26];
	        for(int i=0; i<s.length(); i++){
	            countOfAscii[s.charAt(i)-'a'] +=1;
	        }
	        for(int i=0; i<s.length(); i++){
	            if(countOfAscii[s.charAt(i)-'a'] ==1){
	                return i;
	            }
	        }
	        return -1;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(findMaxRectrange(new int[]{6,2,5,4,5,1,6,7,5,2,4,7,8,4,1,2}));
		//System.out.println(findMaxSubArray(new int[]{-2,3,2,-1}));
		//System.out.println(longestCommonString("abc", "bcde"));
		//int[] numbers = {0, 0, 4, 0, 0, 3,6, 1, 0,  0, 1, 1, 0, 2, 5, 0};
		//System.out.println(getNumberZerosAndMoveZeroToRight(numbers));
		//System.out.println(Arrays.toString((numbers)));
		String s = "abc\ndefa\ndadfa\n\tfadfadfa";
		System.out.println(s.lastIndexOf("\n"));
	}

}
