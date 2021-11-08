package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseHandler {
	
	Connection conn = null;
	private static DatabaseHandler handler;
	
	private DatabaseHandler() {
		createConnection();
	}

	private void createConnection() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/FoodTracker?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "student" , "Student92");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static DatabaseHandler getInstance() {
		if(handler==null) {
			handler =  new DatabaseHandler();
		}
		return handler;
	}
	
	public boolean insertUser(String firstName, String lastName, String email, String password) {
		
		PreparedStatement  preparedStatement = null;
		
		try {
			ResultSet resultSet;
			
			String countEmails = "SELECT COUNT(*) FROM USERS WHERE email = ?";
			preparedStatement= conn.prepareStatement(countEmails);
			
			preparedStatement.setString(1, email);
			
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				
				if(resultSet.getInt(1)>0) {
					
					return false;
				}
				
			}
			
			String insertQuery = "INSERT INTO USERS (email, password, first_name, last_name) VALUES (?,?,?,?)";
			preparedStatement = conn.prepareStatement(insertQuery);
			
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, firstName);
			preparedStatement.setString(4, lastName);
			
			int result = preparedStatement.executeUpdate();
			
			return(result ==1);
			
		}catch(Exception e) {
			System.out.println("Insert User Error "+ e.getMessage());
		}
		return false;
	}

	public int validateUser(String email, String pwd) {
		
		
		PreparedStatement ps = null ;
		
		
		String querry =  "SELECT id FROM USERS WHERE email = ? AND password = ?";
		
		try {
			ps = conn.prepareStatement(querry);
			ps.setString(1, email);
			ps.setString(2, pwd);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return rs.getInt(1);
			}
			
		}catch(SQLException e) {
			System.out.println("User Validation Error "+ e.getMessage());
		}
		
		return -1;
		
	}
	
	public String getUserName(int id) {
		
		String userName = "";
		
		String querry = "SELECT first_name, last_name from USERS where id = ?";
		
		PreparedStatement ps =null;
		
		
		try {
			ps = conn.prepareStatement(querry);
			ps.setInt(1, id);
			//ps.setString(1, Integer.toString(id));
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				userName += rs.getString(1);
				userName += " "+rs.getString(2);
			}
			
			
			
		}catch(SQLException e) {
			
			System.out.println("User Name Error "+ e.getMessage());
			
		}
		
		return userName;
		
	}
	
	public ResultSet getFoodResultSet(String category, String name) {
		
		String query = "SELECT * FROM FOOD";
		String whereClause = " WHERE";
		boolean connectionWhere = false;
		
		ArrayList<String> list = new ArrayList<String> ();
		
		if(!name.isEmpty()) {
			list.add(name);
			connectionWhere= true;
			query+=whereClause;
			query+="name LIKE ?";
		}
		
		if(!category.isEmpty()) {
			list.add(category);
				if(!connectionWhere) {
					query+=whereClause;
					query+="category LIKE ?";
					
				}
				else {
					query+=" AND";
					query+="category LIKE ?";
			}
			
		}
		
		ResultSet rs = null;
		
		PreparedStatement ps =null;
		
		
		try {
			System.out.println(query);
			ps = conn.prepareStatement(query);
		
			for(int i =0; i< list.size(); i++) {
				System.out.println(list.get(i));
				ps.setString(i+1, "%"+list.get(i)+"%");
				
			}
			
			rs = ps.executeQuery();
			
			return rs;
			
			
			
		}catch(SQLException e) {
			
			System.out.println("getFoodResults() Error "+ e.getMessage());
			
		}
		
		return rs;
		
		
		
	}

}
