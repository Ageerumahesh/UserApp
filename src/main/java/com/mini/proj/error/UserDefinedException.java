package com.mini.proj.error;

import java.sql.SQLException;

public class UserDefinedException  extends SQLException{

	private static final long serialVersionUID = 1L;
	
	public  UserDefinedException(String msg) {
		super(msg);
		System.out.println("UserDefinedException.UserDefinedException()");
	}

}
