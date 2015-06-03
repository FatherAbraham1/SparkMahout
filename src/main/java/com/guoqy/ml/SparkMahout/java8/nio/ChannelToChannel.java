package com.guoqy.ml.SparkMahout.java8.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class ChannelToChannel {

	public static void main(String[] args) throws Exception {
		//效率反差明显
//		ChannelToChannel.nioCopy();
//		ChannelToChannel.ioCopy();
	}
	
	public static void nioCopy() {
		// TODO Auto-generated method stub
		try{
			RandomAccessFile fromFile =new RandomAccessFile("/home/sec/workspace/SparkMahout/src/main/java/resource/data_temp2.txt","rw"); 

			FileChannel fromChannel = fromFile.getChannel();

			RandomAccessFile toFile =new RandomAccessFile("/home/sec/workspace/SparkMahout/src/main/java/resource/data_temp.txt","rw");
			FileChannel toChannel = toFile.getChannel();

			long position =0;
			long count = fromChannel.size();
			toChannel.transferFrom( fromChannel,position, count); 
			
			
			fromChannel.close();
			fromFile.close();
			
			toChannel.close();
			toFile.close();
			
		} catch (Exception e) {
			
		} finally {
			
		}
		
	}
	
	public static void ioCopy() {
		try {
			FileInputStream fis = new FileInputStream("/home/sec/workspace/SparkMahout/src/main/java/resource/data_temp2.txt");
			
			FileOutputStream fos = new FileOutputStream("/home/sec/workspace/SparkMahout/src/main/java/resource/data_temp.txt");
			int x ;
			x = fis.read();
			while(x != -1) {
				fos.write(x);
				x = fis.read();
			}
			
			fis.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}

}
