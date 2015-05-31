package com.guoqy.ml.SparkMahout.readtxt;

import java.util.HashMap;
import java.util.Map;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

/**
 * Hello world!
 *
 */
public class SparkHadoopReadTxt 
{
	private static final String username = "hadoop";
	
    public static void main( String[] args )
    {      
    	System.setProperty("user.name", "hadoop");
    	System.setProperty("HADOOP_HOME_USER", username);
    	
    	Map envs = new HashMap();
    	
    	envs.put("HADOOP_HOME_USER", username);
    	
    	System.setProperty("spark.executor.memory", "2m");
    	
    	// 以下构造sc对象的构造方法各参数意义依次为：
		//   Spark Master的地址；
		//   App的名称；
		//   Spark Worker的部署位置；
		//   需要提供给本App的各个Executor程序下载的jar包的路径列表，这些jar包将出现在Executor程序的类路径中；
		//   传递给本App的各个Executor程序的环境信息。
    	
    	JavaSparkContext sc = new JavaSparkContext("spark://hadoop1:7077", "Spark App 0", "/home/hadoop/spark-1.2.1-bin-hadoop2.4", new String[0], envs);
    	
    	String file = "hdfs://hadoop1:9000/in/test1.txt";
		JavaRDD data = sc.textFile(file, 4).cache();
		System.out.println(data.count());
    	
    }
}
