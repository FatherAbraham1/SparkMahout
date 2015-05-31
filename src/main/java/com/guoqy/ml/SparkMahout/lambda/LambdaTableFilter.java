package com.guoqy.ml.SparkMahout.lambda;

import java.util.ArrayList;
import java.util.List;

import com.guoqy.ml.SparkMahout.lambda.tables.UserTable;

public class LambdaTableFilter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<UserTable> userList = new ArrayList<UserTable>();
		
		UserTable userTable = new UserTable();
		userTable.username = "xiaoguoguo" ;
		userTable.realname = "小郭郭" ;
		userTable.age = 25 ;
		
		userList.add(userTable);
		
		userTable = new UserTable();
		userTable.username = "xiaolulu" ;
		userTable.realname = "小露露" ;
		userTable.age = 24 ;
		
		userList.add(userTable);
		
		userTable = new UserTable();
		userTable.username = "xiaoxiaoguo" ;
		userTable.realname = "小小郭" ;
		userTable.age = 1 ;
		
		userList.add(userTable);
		
		//userList.stream().filter(w -> w.age > 2).iterator().forEachRemaining(x -> System.out.println(x.realname)) ;
		
		userList.stream().filter(w -> w.age > 2).forEach(x -> System.out.println(x.age));
	}
	

}
