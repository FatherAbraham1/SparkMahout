package com.guoqy.ml.SparkMahout.datatype;

import org.apache.spark.mllib.linalg.Matrices;
import org.apache.spark.mllib.linalg.Matrix;

public class DenseMartix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Create a dense matrix ((1.0, 2.0), (3.0, 4.0), (5.0, 6.0))
		Matrix dm = Matrices.dense(3, 2, new double[] {1.0, 3.0, 5.0, 2.0, 4.0, 6.0});
	}

}
