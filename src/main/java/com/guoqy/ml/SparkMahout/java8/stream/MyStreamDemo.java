package com.guoqy.ml.SparkMahout.java8.stream;

import java.util.ArrayList;
import java.util.List;

import com.guoqy.ml.SparkMahout.java8.dto.Student;

public class MyStreamDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Student> students = new ArrayList<Student>();
		
		Student student = new Student();
		student.age = 12;
		student.colour = "red";
		student.name = "Tom" ;
		student.realname = "Tomcat";
		students.add(student);
		
		student = new Student();
		student.age = 16;
		student.colour = "black";
		student.name = "Web" ;
		student.realname = "Weblogic";
		students.add(student);
		
		student = new Student();
		student.age = 20;
		student.colour = "blue";
		student.name = "Eclipse" ;
		student.realname = "MyEclipse";
		students.add(student);
		
		int totalAge = students.stream().filter(x -> x.age >14).mapToInt(x -> x.age).sum() ;
		System.out.println(totalAge);
		
		
		
	}

}
