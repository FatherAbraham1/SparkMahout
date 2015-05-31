package com.guoqy.ml.SparkMahout.readtxt;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;

/**
 * 客户端调用含有匿名类的RDD模型
 * 需要把子类打成jar包通过JavaSparkContext的addJar方法，传送到集群上
 *
 */
public class SparkHadoopReadTxt2 
{
	
    public static void main( String[] args )
    {      
    	System.setProperty("spark.executor.memory", "2m");
		SparkConf sparkConf = new SparkConf()
		  .setAppName("Regression")
		  .setMaster("spark://hadoop1:7077")
		  .setSparkHome("/home/hadoop/spark-1.2.1-bin-hadoop2.4")
		  .setExecutorEnv("HAOOP_HOME_USER", "hadoop");
		JavaSparkContext sc = new JavaSparkContext(sparkConf);
		
		sc.addJar("/home/sec/src/sparkJar/spark.jar");
		
		JavaRDD<String> data = sc.textFile("hdfs://hadoop1:9000/in/wordCount.txt");
		JavaRDD<String> parsedData = data.flatMap(
				new FlatMapFunction<String,String>() {
					public Iterable<String> call(String line) {
						System.out.println(line);
						return Arrays.asList(line.split(" "));
					}
				});
		
		List wordList = parsedData.collect();
		Iterator<String> iter = wordList.iterator();
		while(iter.hasNext()) {
			String word = iter.next();
			System.out.println(word);
		}
		System.out.print(wordList.size());
    }
}
