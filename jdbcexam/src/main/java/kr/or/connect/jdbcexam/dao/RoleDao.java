package kr.or.connect.jdbcexam.dao;

import java.sql.*;
import java.util.*;

import kr.or.connect.jdbcexam.dto.Role;

public class RoleDao {
	private static String dbUrl = "jdbc:mysql://localhost:3306/connectdb?useSSL=false";
	private static String dbUser = "connectuser";
	private static String dbPasswd = "connect123!@#";
	
	//Exam1
	//id조건이 일치하는 값 조회
	public Role getRole(Integer roleId) {
		Role role = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		String sql = "SELECT role_id, description FROM role WHERE role_id = ?";
		
		try(Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPasswd);
			PreparedStatement ps = conn.prepareStatement(sql)){
			
			ps.setInt(1, roleId);
			
			try(ResultSet rs = ps.executeQuery()){
				if(rs.next()) {
					//rs.getInt(1);
					int id = rs.getInt("role_id");
					//rs.getString(2);
					String description = rs.getString("description");
					
					role = new Role(id, description);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return role;
	}
	
	//Exam2
	//삽입
	public int addRole(Role role) {
		int insertCount = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");	
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		String sql = "INSERT INTO role(role_id, description) VALUES (?, ?) ";
		
		try(Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPasswd);
			PreparedStatement ps = conn.prepareStatement(sql)){
			
			ps.setInt(1, role.getRoleId());
			ps.setString(2, role.getDescription());
			
			insertCount = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return insertCount;
	}
	
	//Exam3
	//id조건이 일치하는 값 수정
		public int updateRole(Role role) {
			int updateCount = 0;
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
			}catch (Exception e){
				e.printStackTrace();
			}
			
			String sql = "UPDATE role SET description = ? where role_id = ?";
			
			try(Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPasswd);
				PreparedStatement ps = conn.prepareStatement(sql)){
				
				ps.setString(1, role.getDescription());
				ps.setInt(2, role.getRoleId());
				
				updateCount = ps.executeUpdate();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return updateCount;
		}
	
	//Exam4
	//id조건이 일치하는 값 삭제
	public int deleteRole(Integer roleId) {
		int deleteCount = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		String sql = "DELETE FROM role WHERE role_id = ?";
		
		try(Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPasswd);
			PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setInt(1, roleId);
			
			deleteCount = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	
		return deleteCount;
	}
	
	//Exam5
	//모든 DB값 조회
	public List<Role> getRoles(){
		List<Role> list = new ArrayList<>();
			
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		String sql = "SELECT role_id, description FROM role ORDER BY role_id DESC";
			
		try(Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPasswd);
			PreparedStatement ps = conn.prepareStatement(sql)){
				
			try(ResultSet rs = ps.executeQuery()){
				while(rs.next()) {
					int roleId = rs.getInt(1);
					String description = rs.getString(2);
						
					Role role = new Role(roleId, description);
					list.add(role);
				}	
			}catch(Exception e){
				e.printStackTrace();
			}		
		}catch(Exception e) {
			e.printStackTrace();
		}
			
		return list;
	}
}
