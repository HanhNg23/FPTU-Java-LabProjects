package usermanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import usermanagement.model.User;

//This DAO Class provides CRUID database operations
//for the table users in the database
public class UserDAO {
	private String url = "jdbc:mysql://localhost:3306/demo";
	private String uname = "root";
	private String password = "hanh3533.";
	
	private static final String INSERT_USERS_SQL = "INSERT INTO user" + "(name, email, country)" + "VALUES " + "(?, ?, ?);";
	private static final String SELECT_USERS_BY_ID = "SELECT id, name , email, country FROM user WHERE id=?;";
	private static final String SELECT_ALL_USERS = "SELECT * FROM user";
	private static final String DELETE_USERS_SQL = "DELETE * FROM user WHERE id=?;";
	private static final String UPDATE_USERS_SQL = "UPDATE user SET name =?, email=?, country=? WHERE id=?;";
	
	
	protected Connection getConnection() throws ClassNotFoundException{
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, uname, password);
			
		}catch(SQLException e) {
			//1000 Auto generated catch block
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	//Create or insert user
	public void insertUser(User user) throws SQLException {
		try{ 
			Connection connection = getConnection();
		//Use PreparedStatement to execute multiple times
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
			preparedStatement.setString(1, user.getName()); //Set value for the column 1 
			preparedStatement.setString(2, user.getEmail()); ////Set value for the column 2
			preparedStatement.setString(3, user.getCountry());
		    //execute and add one row to the table
			preparedStatement.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	//update user
	public boolean updateUser(User user) throws SQLException {
		boolean rowUpdated = false;
		try{ Connection connection = getConnection();
		//Use PreparedStatement to execute multiple times
			PreparedStatement  statement = connection.prepareStatement(UPDATE_USERS_SQL);
			statement.setString(1, user.getName()); //Set value for the column 1 
			statement.setString(2, user.getEmail()); ////Set value for the column 2
			statement.setString(3, user.getCountry());
			statement.setInt(4, user.getId());
			
		    //execute and add one row to the table
			rowUpdated = statement.executeUpdate() > 0;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return rowUpdated;
		
	}
	//select user by id
	public User selectUser(int id) {
		User user = null;
		//Step 1: Establishing a connection
		try{ Connection connection = getConnection();
		//Step 2 : Create Statement using connection object
		//Use PreparedStatement to execute multiple times
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERS_BY_ID);
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			//Step 3: Execute the query 
			ResultSet rs = 	preparedStatement.executeQuery();
			//Step 4: Process the ResultSet object
			while(rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				String country = rs.getString("country");
				user = new User(name, email, country);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return user;
		
	}
	//select users
	public List<User> selectALLUser() {
		//List type User
		List<User> userList = new ArrayList<>();
		//Step 1: Establishing a connection
		try{ Connection connection = getConnection();
		//Step 2 : Create Statement using connection object
		//Use PreparedStatement to execute multiple times
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);
			System.out.println(preparedStatement);
			//Step 3: Execute the query 
			ResultSet rs = 	preparedStatement.executeQuery();
			//Step 4: Process the ResultSet object
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String country = rs.getString("country");
				userList.add(new User(id, name, email, country));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
		
	}
	//delete user
	//select user by id
	public boolean deleteUser(int id) {
		boolean rowDelete = false ;
		//Step 1: Establishing a connection
		try{ Connection connection = getConnection();
		//Step 2 : Create Statement using connection object
		//Use PreparedStatement to execute multiple times
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERS_BY_ID);
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			rowDelete = preparedStatement.executeUpdate() > 0;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return rowDelete;	
	}
	

}
