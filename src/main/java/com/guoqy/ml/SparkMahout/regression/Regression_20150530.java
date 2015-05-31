package com.guoqy.ml.SparkMahout.regression;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.mllib.linalg.Vector;
import org.apache.spark.mllib.linalg.Vectors;
import org.apache.spark.mllib.regression.GeneralizedLinearModel;
import org.apache.spark.mllib.regression.LabeledPoint;
import org.apache.spark.mllib.regression.LassoModel;
import org.apache.spark.mllib.regression.LassoWithSGD;
import org.apache.spark.mllib.regression.LinearRegressionModel;
import org.apache.spark.mllib.regression.LinearRegressionWithSGD;
import org.apache.spark.mllib.regression.RidgeRegressionModel;
import org.apache.spark.mllib.regression.RidgeRegressionWithSGD;

import scala.Tuple2;

public class Regression_20150530 {
	public static void main(String[] args) {
		
		SparkConf sparkConf = new SparkConf()
			  .setAppName("Regression")
			  .setMaster("spark://hadoop1:7077")
			  .setSparkHome("/home/hadoop/spark-1.2.1-bin-hadoop2.4")
			  .setExecutorEnv("HAOOP_HOME_USER", "hadoop");
		JavaSparkContext sc = new JavaSparkContext(sparkConf);
		JavaRDD<String> data = sc.textFile("hdfs://hadoop1:9000/in/test1.txt");
		JavaRDD parsedData = data.flatMap(
				new FlatMapFunction<String,String>() {
					public Iterable<String> call(String line) {
					      return Arrays.asList(line.split(" "));
					    }
				});
//		JavaRDD<LabeledPoint> parsedData = data.map(line -> {
//			String[] parts = line.split(",");
//			double[] ds = Arrays.stream(parts[1].split(" "))
//				  .mapToDouble(Double::parseDouble)
//				  .toArray();
//			return new LabeledPoint(Double.parseDouble(parts[0]), Vectors.dense(ds));
//		}).cache();

		int numIterations = 100; //迭代次数
		LinearRegressionModel model = LinearRegressionWithSGD.train(parsedData.rdd(), numIterations);
		RidgeRegressionModel model1 = RidgeRegressionWithSGD.train(parsedData.rdd(), numIterations);
		LassoModel model2 = LassoWithSGD.train(parsedData.rdd(), numIterations);

		print(parsedData, model);
		print(parsedData, model1);
		print(parsedData, model2);

		//预测一条新数据方法
		double[] d = new double[]{1.0, 1.0, 2.0, 1.0, 3.0, -1.0, 1.0, -2.0};
		Vector v = Vectors.dense(d);
		System.out.println(model.predict(v));
		System.out.println(model1.predict(v));
		System.out.println(model2.predict(v));
	}

	public static void print(JavaRDD<LabeledPoint> parsedData, GeneralizedLinearModel model) {
//		JavaPairRDD<Double, Double> valuesAndPreds = parsedData.mapToPair(point -> {
//			double prediction = model.predict(point.features()); //用模型预测训练数据
//			return new Tuple2<>(point.label(), prediction);
//		});
//
//		Double MSE = valuesAndPreds.mapToDouble((Tuple2<Double, Double> t) -> Math.pow(t._1() - t._2(), 2)).mean(); //计算预测值与实际值差值的平方值的均值
//		System.out.println(model.getClass().getName() + " training Mean Squared Error = " + MSE);
	}
}
