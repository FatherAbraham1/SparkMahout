package com.guoqy.ml.SparkMahout.datatype;

import org.apache.spark.mllib.linalg.Vector;
import org.apache.spark.mllib.linalg.Vectors;

public class MyVector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//dense Vector 
		Vector denseVector = Vectors.dense(1.0, 2.0 , 4.0 , 2.3 , 3.5);
		System.out.println("dense vector size : " + denseVector.size());
		System.out.println("value: ") ;
		System.out.println(denseVector.toString());
		
		
		//a sparse vector
		Vector sparseVector = Vectors.sparse(4, new int[]{1,3,5,7} , new double[]{1.2,2.4,3.4,4.5});
		System.out.println("sparse vector size : " + sparseVector.size());
		System.out.println("value: ") ;
		System.out.println(sparseVector.toString());
		
	}

}
