package com.guoqy.ml.SparkMahout.datatype;

import org.apache.spark.mllib.linalg.Vector;
import org.apache.spark.mllib.linalg.Vectors;

public class DenseAndSparseVector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//create a dense vector (1.0 ,  0.0 , 3.0 )
		Vector denseVector = Vectors.dense(1.0, 0.0,3.0);
		
		// Create a sparse vector (1.0, 0.0, 3.0) by specifying its indices and values corresponding to nonzero entries.
		Vector sparseVector = Vectors.sparse(3, new int[] {0, 2}, new double[] {1.0, 3.0});
		
	
	}

}
