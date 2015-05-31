package com.guoqy.ml.SparkMahout.lambda;

public class LambdaThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LambdaThread.gaoDuanDaQiShangDangCi.run();
		
		LambdaThread.gaoDuanDaQiShangDangCi.run();
		
		LambdaThread.gaoDuanDaQiShangDangCi.run();
	}
	
	public static Thread gaoDuanDaQiShangDangCi = new Thread( () -> {
        System.out.println("This is from an anonymous method (lambda exp).");
    } );

}
