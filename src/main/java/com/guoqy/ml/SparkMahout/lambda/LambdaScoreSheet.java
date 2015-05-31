package com.guoqy.ml.SparkMahout.lambda;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LambdaScoreSheet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LambdaScoreSheet ss = new LambdaScoreSheet();
    	for (int i =0 ; i< 100 ; i++) {
    		Score score = new Score();
    		score.score = 1 ;
    		ss.scores.add(score);
    	}
    	System.out.println("s.length :" + ss.scores.size());
    	ss.filter();
    	
    	System.out.println("s.length :" + ss.scores.size());
	}

	public List<Score> scores = new ArrayList();

    public List<Score> filter() {
    	List list = new ArrayList();

    	Iterator iter = scores.stream().filter(w -> w.score >= 60).iterator();
    	
    	
    	while(iter.hasNext()){
    		list.add((Score)iter.next());
    	}
    	return list;
    
    }
}
