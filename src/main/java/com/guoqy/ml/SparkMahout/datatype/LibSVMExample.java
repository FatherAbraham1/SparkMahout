package com.guoqy.ml.SparkMahout.datatype;

import org.apache.spark.SparkConf;
import org.apache.spark.mllib.regression.LabeledPoint;
import org.apache.spark.mllib.util.MLUtils;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class LibSVMExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SparkConf sparkConf = new SparkConf()
		  .setAppName("Regression")
		  .setMaster("spark://hadoop1:7077")
		  .setSparkHome("/home/hadoop/spark-1.2.1-bin-hadoop2.4")
		  .setExecutorEnv("HAOOP_HOME_USER", "hadoop");
		JavaSparkContext sc = new JavaSparkContext(sparkConf);

		JavaRDD<LabeledPoint> examples = 
		  MLUtils.loadLibSVMFile(sc.sc(), "data/mllib/sample_libsvm_data.txt").toJavaRDD();
	}

}
