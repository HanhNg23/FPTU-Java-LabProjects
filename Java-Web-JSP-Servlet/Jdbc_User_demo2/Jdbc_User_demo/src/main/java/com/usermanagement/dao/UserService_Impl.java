package com.usermanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.usermanagement.model.User;

public class UserService_Impl implements I_UserService {
	//Declare
	Connection connect = null;
	
	// Database inform login
	private String url = "jdbc:mysql://localhost:3306/demo";
	private String uname = "root";
	private String password = "hanh3533.";

	// Query string
	private static final String SELECT_ALL_USERS = "SELECT * FROM demo.user";
	private static final String INSERT_NEW_USER = "INSERT INTO demo.user(name, email, country) VALUES(?, ?, ?)";
	private static final String DELETE_BY_USER_ID = "DELETE FROM demo.user WHERE id= ?";

	public UserService_Impl() {
	}

	@Override
	public void getDBConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("FOUND !!!!");
			this.connect = DriverManager.getConnection(url, uname, password);
			System.out.println("Connected! " + this.connect);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<User> showAll()  {
		List<User> userList = new ArrayList<>();		
		try {
			this.getDBConnection();
			PreparedStatement preState = connect.prepareStatement(SELECT_ALL_USERS);
			ResultSet userTable = preState.executeQuery();
			while(userTable.next()){
				//get the value at each row at the column with label 'name'
				int id = userTable.getInt("id");
				String name = userTable.getString("name"); 
				String email = userTable.getString("email");
				String country = userTable.getString("country");
				System.out.println("name " + name + " email " + email + " country " + country);
				userList.add(new User(id, name, email, country));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("The size of userList " + userList.size());
		
		return userList;
	}

	@Override
	public boolean insert(User user) {
		boolean success = false;
		try {
		this.getDBConnection();
		PreparedStatement preState = connect.prepareStatement(INSERT_NEW_USER);
		preState.setString(1, user.getName());
		preState.setString(2, user.getEmail());
		preState.setString(3, user.getCountry());
		preState.executeUpdate();
		success = true;
		}catch (Exception e) {
			System.out.println("insert Fail");
			e.printStackTrace();
		}
		return success;

	}

	@Override
	public void update(int id, User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean delete(int id) {
		boolean success = false;
		try {
			this.getDBConnection();
			PreparedStatement preState = connect.prepareStatement(DELETE_BY_USER_ID);
			preState.setInt(1,id);
			preState.executeUpdate();
			success = true;
		}catch (Exception e) {
			System.out.println("Delete success");
			e.printStackTrace();
		}
		return success;
	}

	@Override
	public void findById(int id) {
		// TODO Auto-generated method stub

	}

}
