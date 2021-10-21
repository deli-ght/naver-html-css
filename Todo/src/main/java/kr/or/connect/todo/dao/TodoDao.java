package kr.or.connect.todo.dao;

import kr.or.connect.todo.dto.Todo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;


public class TodoDao {
	private static String dburl = "jdbc:mysql://localhost:3300/connectdb";
	private static String dbUser = "connectuser";
	private static String dbpasswd = "connect123!@#";

	
	public List<Todo> getTodos(){
		List<Todo> list = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException e) {
			System.out.println("e");
		}
		
		String sql = "SELECT * FROM todo order by id";
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)) {

			try (ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {
					long id = rs.getLong("id");
					String name = rs.getString("name");
					String regDate = rs.getString("regDate");
					int sequence = rs.getInt("sequence");
					String title = rs.getString("title");
					String type = rs.getString("type");
					
					Todo todo = new Todo(id, name, regDate, sequence, title, type);
					list.add(todo); 
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
		
	}
	
	public void updateTodo(long id, String type) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			
			String sql = "update todo set type = ? where id = ?";
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, type);
			ps.setLong(2, id);
			
			ps.executeUpdate();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(ps != null) {
				try {
					ps.close();
				}catch(Exception ex) {
					
				}
			}
			if (conn != null) {
				try {
					conn.close();
				}catch(Exception ex) {
				}
			}
		}
	}
	
	public void insertTodo(String title, String name, int sequence ) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			
			String sql = "insert into todo(title, name, sequence) value(?,?,?)";
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, title);
			ps.setString(2, name);
			ps.setInt(3, sequence);
			
			ps.executeUpdate();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(ps != null) {
				try {
					ps.close();
				}catch(Exception ex) {
					
				}
			}
			if (conn != null) {
				try {
					conn.close();
				}catch(Exception ex) {
				}
			}
		}
		
	}
		
	public void removeAll() {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			
			String sql = "delete from todo";
			
			ps = conn.prepareStatement(sql);
			
			ps.executeUpdate();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(ps != null) {
				try {
					ps.close();
				}catch(Exception ex) {
					
				}
			}
			if (conn != null) {
				try {
					conn.close();
				}catch(Exception ex) {
				}
			}
		}
	}
}
