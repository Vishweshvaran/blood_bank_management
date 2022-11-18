package DAO;
import java.sql.*;
import java.util.*;


public class DAOController{
	
	public DAOController() throws SQLException {
		this.createDatabase();
		this.createDonorTable();
		this.createSeekerTable();
	}
	
	private Connection con;
	private ResultSet res;
	private Statement stmt;
	private PreparedStatement pStmt;
	private boolean flag;
	
	public Connection getConnetion() throws SQLException {
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","admin");
		return con;
	}
	
	
	public void closeConnection() throws SQLException {
		con.close();
	}
	
	public void createDatabase() throws SQLException {
		Connection con = this.getConnetion();
		Statement stmt = con.createStatement(); 		
		String str = "show databases";
		ResultSet res = stmt.executeQuery(str);
		flag = true;
		while(res.next()) {
			if(res.getString("Database").equalsIgnoreCase("bloodBank")) {
				flag = false;
				break;
			}
		}
		if(flag) {
			stmt.executeUpdate("create database bloodBank");
		}
		stmt.executeUpdate("use bloodBank");
		
	}
	
	public void createDonorTable() throws SQLException {
		con = this.getConnetion();
		this.createDatabase();
		stmt = con.createStatement();
		res = stmt.executeQuery("show tables");
		flag = true;
		while(res.next()) {
			if(res.getString("Tables_in_bloodBank").equalsIgnoreCase("donor")) {
				flag = false;
				break;
			}
		}
		if(flag) {
			stmt.executeUpdate("create table donor( first_name varchar(10), last_name varchar(10), gender varchar(10), city varchar(10), email varchar(20), phone_no varchar(20), blood_group varchar(5))");
		}
		
	}
	
	public void createSeekerTable() throws SQLException {
		con = this.getConnetion();
		this.createDatabase();
		stmt = con.createStatement();
		res = stmt.executeQuery("show tables");
		flag = true;
		while(res.next()) {
			if(res.getString("Tables_in_bloodBank").equalsIgnoreCase("seeker")) {
				flag = false;
				break;
			}
		}
		if(flag) {                                                               
			stmt.executeUpdate("create table seeker(first_name varchar(10), last_name varchar(10), gender varchar(10), city varchar(10), email varchar(20), phone_no varchar(20), blood_group varchar(5))");
		}
		
	}
	
	public void donorRegistration(String firstName, String lastName, String gender, String city, String email, String phone_no, String blood_group) throws SQLException {
		con = this.getConnetion();
		this.createDatabase();
		pStmt = con.prepareStatement("insert into donor values(?,?,?,?,?,?,?)");
		pStmt.setString(1, firstName);
		pStmt.setString(2, lastName);
		pStmt.setString(3, gender);
		pStmt.setString(4, city);
		pStmt.setString(5, email);
		pStmt.setString(6, phone_no);
		pStmt.setString(7, blood_group);
		pStmt.executeUpdate();		
					
	}
	
	public void seekerRegistration(String firstName, String lastName, String gender, String city, String email, String phone_no, String blood_group) throws SQLException {
		con = this.getConnetion();
		this.createDatabase();
		pStmt = con.prepareStatement("insert into seeker values(?,?,?,?,?,?,?)");
		pStmt.setString(1, firstName);
		pStmt.setString(2, lastName);
		pStmt.setString(3, gender);
		pStmt.setString(4, city);
		pStmt.setString(5, email);
		pStmt.setString(6, phone_no);
		pStmt.setString(7, blood_group);
		pStmt.executeUpdate();
		
	}
	
	public ArrayList<ArrayList<String>> donorDetails() throws SQLException {
		con = this.getConnetion();
		this.createDatabase();
		stmt = con.createStatement();
		res = stmt.executeQuery("select * from donor");
		ArrayList<ArrayList<String>> ans = new ArrayList<>();
		int index = 0;
		while(res.next()) {
			ans.add(new ArrayList<String>());
			ans.get(index).add(res.getString(1));
			ans.get(index).add(res.getString(2));
			ans.get(index).add(res.getString(3));
			ans.get(index).add(res.getString(4));
			ans.get(index).add(res.getString(5));
			ans.get(index).add(res.getString(6));
			ans.get(index).add(res.getString(7));
			index++;
		}
		
		return ans;
	}
	
	public ArrayList<ArrayList<String>> seekerDetails() throws SQLException {
		con = this.getConnetion();
		this.createDatabase();
		stmt = con.createStatement();
		res = stmt.executeQuery("select * from seeker");
		ArrayList<ArrayList<String>> ans = new ArrayList<>();
		int index = 0;
		while(res.next()) {
			ans.add(new ArrayList<String>());
			ans.get(index).add(res.getString(1));
			ans.get(index).add(res.getString(2));
			ans.get(index).add(res.getString(3));
			ans.get(index).add(res.getString(4));
			ans.get(index).add(res.getString(5));
			ans.get(index).add(res.getString(6));
			ans.get(index).add(res.getString(7));
			index++;
		}
		
		return ans;
	}
	
	
	
	public ArrayList<ArrayList<String>> bloodDetails(String bloodGroup, String city) throws SQLException {
		con = this.getConnetion();
		this.createDatabase();
		stmt = con.createStatement();
		ResultSet res = stmt.executeQuery("select first_name, last_name, phone_no from donor where blood_group = " + bloodGroup + " and city = " + city);
		ArrayList<ArrayList<String>> ans = new ArrayList<>();
		int index = 0;
		while(res.next()) {
			ans.add(new ArrayList<String>());
			ans.get(index).add(res.getString("first_name") + res.getString("last_name"));
			ans.get(index).add(res.getString("phone_no"));
		}
		return ans;
	}  
	
//	public static void main(String args[]) throws SQLException {
//		DAOController d = new DAOController();
//		d.donorDetails();
//		d.seekerDetails();
//		d.donorRegistration(null, null, null, null, null, null, null);
//		d.seekerRegistration(null, null, null, null, null, null, null);
//		d.bloodDetails(null, null);
//	}
}  