package com.guoqy.ml.SparkMahout.java8.stream;

import java.util.ArrayList;
import java.util.List;

import com.guoqy.ml.SparkMahout.java8.dto.Student;
import com.guoqy.ml.SparkMahout.java8.dto.Student2;

public class MyStreamDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Student2> students = new ArrayList<Student2>();
		
		Student2 student = new Student2();
		student.setAge(2);
		student.setColour("Red");
		student.setName("Tom");
		student.setRealname("Tomcat");
		
		students.add(student);
		
		student = new Student2();
		student.setAge(16);
		student.setColour("Black");
		student.setName("Web");
		student.setRealname("Weblogic");
		students.add(student);
		
		student = new Student2();
		student.setAge(20);
		student.setColour("Blue");
		student.setName("Eclipse");
		student.setRealname("MyEclipse");
		students.add(student);
		
		long totalAge = students.stream().filter(x -> x.getAge() >14)
				.filter(x -> x.getColour() == "Black").mapToInt(x -> x.getAge()).count() ;
		System.out.println(totalAge);
		
		
		
	}

}
