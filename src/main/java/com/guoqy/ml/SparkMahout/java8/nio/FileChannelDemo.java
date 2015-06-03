package com.guoqy.ml.SparkMahout.java8.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;

public class FileChannelDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        RandomAccessFile aFile =new RandomAccessFile("/home/sec/workspace/SparkMahout/src/main/java/resource/data_temp.txt","rw");
        FileChannel inChannel = aFile.getChannel();
        
        //读缓冲
        ByteBuffer readbuf = ByteBuffer.allocate(1024);
//        CharBuffer readbuf = CharBuffer.allocate(1024);
        
        int bytesRead = inChannel.read(readbuf);
        while(bytesRead != -1) {
        	
	        System.out.println("\nRead "+ bytesRead);
	        readbuf.flip();
	        
	        while(readbuf.hasRemaining()){
	        	System.out.print((char) readbuf.get());
	        }
	        
	        readbuf.clear();
	        bytesRead = inChannel.read(readbuf);
        }
        aFile.close(); 

		
	}

}
