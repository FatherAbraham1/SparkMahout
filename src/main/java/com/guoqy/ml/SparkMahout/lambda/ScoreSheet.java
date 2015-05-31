package com.guoqy.ml.SparkMahout.lambda;

import java.util.ArrayList;
import java.util.List;

public class ScoreSheet {
    List<Score> scores = new ArrayList<Score>();

    public List<Score> filter() {
        List<Score> passed = new ArrayList<Score>();
        for (Score score : scores) {
            if (score.score >= 60) {
                passed.add(score);
            }
        }
        return passed;
    }
    
    public static void main (String args[]) {
    	ScoreSheet ss = new ScoreSheet();
    	for (int i =0 ; i< 100 ; i++) {
    		Score score = new Score();
    		score.score = 1 ;
    		ss.scores.add(score);
    	}
    	System.out.println("s.length :" + ss.scores.size());
    	ss.filter();
    	
    	System.out.println("s.length :" + ss.scores.size());
    }
}