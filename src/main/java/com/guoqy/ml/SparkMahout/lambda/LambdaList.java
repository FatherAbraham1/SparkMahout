package com.guoqy.ml.SparkMahout.lambda;

import java.util.ArrayList;
import java.util.List;


public class LambdaList {
	
	
	
	public static void main(String[] args) {
		List<Integer> output = new ArrayList<Integer>();
		
		List<Integer> input = new ArrayList<Integer>();
		// TODO Auto-generated method stub
		for(int i=0 ; i<10 ; i ++) {
			output.add(i);
		}
		
		output.forEach(x -> input.add(x));
		
		input.forEach(x -> System.out.println("output list : " + x));
		
	}

}
