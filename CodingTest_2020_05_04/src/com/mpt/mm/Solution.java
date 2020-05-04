/*
 * 【The test that I submitted on 2020.05.04】
 * There are three int type inputs as A, B, C;
 * int A represents number of "a" 
 * int B represents number of "b"
 * int C represents number of "c"
 * 
 * You have to execute to get the largest string that does not have three consecutive word like "aaa","bbb","ccc"
 * 
 * e.g 1 
 * input -> int A = 6, B = 1, C = 1;
 * output -> aabaacaa
 * e.g 2
 * input -> int A = 1, B = 3, C = 1;
 * output -> abbcb or bbabc or bbcba or bbacb or bbcab or cbbab (you can print only one output)
 */



package com.mpt.mm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maw Paing Thu
 * The solution of the test that I cannot get on time.
 * Please read the question at above comment.
 */
public class Solution {
	
	static List<String> inputA = new ArrayList<String>();

	static List<String> inputB = new ArrayList<String>();

	static List<String> inputC = new ArrayList<String>();

	static String tmpResult = "";

	public static void main(String[] args) {
		//Input data
		int A = 6, B = 3, C = 2;
		//To get output data
		String result = getResult(A, B, C);
		//Print out the output data
		System.out.println(result);
	}

	/**
	 * To execute output data
	 * @param A
	 *   	input A that represents for number of "a"
	 * @param B
	 * 		input B that represents for number of "b"
	 * @param C
	 * 		input C that represents for number of "c"
	 * @return
	 * 		output data
	 */
	private static String getResult(int A, int B, int C) {
		
		int maxSize = 0;
		//getting "a" as list upon the number of int A
		for (int i = 1; i <= A; i++) {
			if (i % 2 == 0)
				inputA.add("aa");
		}
		if (A % 2 != 0)
			inputA.add("a");
		
		//getting "b" as list upon the number of int B
		for (int i = 1; i <= B; i++) {
			if (i % 2 == 0)
				inputB.add("bb");
		}
		if (B % 2 != 0)
			inputB.add("b");
		maxSize = Math.max(inputA.size(), inputB.size());

		//getting "c" as list upon the number of int C
		for (int i = 1; i <= C; i++) {
			if (i % 2 == 0)
				inputC.add("cc");
		}
		if (C % 2 != 0)
			inputC.add("c");
		maxSize = Math.max(maxSize, inputC.size());

		//looping upon the maxSize that compared from size of "a"list, "b"list and c"list"
		for (int i = 0; i < maxSize; i++) {
			if (inputA.size() > 0) {
				getValueOfA();
			}
			if (inputB.size() > 0) {
				getValueOfB();
			}
			if (inputC.size() > 0) {
				getValueOfC();
				if (inputA.size() > 0) {
					tmpResult = tmpResult + inputA.get(0);
					inputA.remove(0);
				}
				if (inputB.size() > 0) {
					tmpResult = tmpResult + inputB.get(0);
					inputB.remove(0);
				}
			}
		}

		return tmpResult;
	}
	
	/**
	 * getting the value from "a"list
	 */
	private static void getValueOfA() {
		tmpResult = tmpResult + inputA.get(0);
		inputA.remove(0);
	}
	

	/**
	 * getting the value from "b"list
	 */
	private static void getValueOfB() {
		tmpResult = tmpResult + inputB.get(0);
		inputB.remove(0);
		if (inputA.size() > 0) {
			getValueOfA();
		}
	}
	
	/**
	 * getting the value from "c"list
	 */
	private static void getValueOfC() {
		tmpResult = tmpResult + inputC.get(0);
		inputC.remove(0);
		if (inputA.size() > 0) {
			getValueOfA();
		}
		if (inputB.size() > 0) {
			getValueOfB();
		}

	}

}
