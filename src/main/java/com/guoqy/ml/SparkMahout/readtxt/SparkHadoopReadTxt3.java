package com.guoqy.ml.SparkMahout.readtxt;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;

/**
 * Hello world!
 *
 */
public class SparkHadoopReadTxt3 
{
	private static final String username = "hadoop";
	
    public static void main( String[] args )
    {      
    	System.setProperty("spark.executor.memory", "2m");
		SparkConf sparkConf = new SparkConf()
		  .setAppName("Regression")
		  .setMaster("spark://hadoop1:7077")
		  .setSparkHome("/home/hadoop/spark-1.2.1-bin-hadoop2.4")
		  .setExecutorEnv("HAOOP_HOME_USER", "hadoop");
		JavaSparkContext sc = new JavaSparkContext(sparkConf);
		JavaRDD<String> data = sc.textFile("hdfs://hadoop1:9000/in/test1.txt");
		System.out.println(data.count());
    }
}
