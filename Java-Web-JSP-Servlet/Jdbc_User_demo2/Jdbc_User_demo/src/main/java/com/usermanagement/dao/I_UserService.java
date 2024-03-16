package com.usermanagement.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.usermanagement.model.User;


interface  I_UserService {
	
	void getDBConnection(); //to connect java servlet with Database

	List<User> showAll() throws SQLException ; //to show all the list
		
	boolean insert(User user); //to insert to Database
	
	void update(int id, User user); //to update by Id
	
	boolean delete(int id); //to delete by Id
	
	void findById(int id); //to fine someone by Id
	

}
