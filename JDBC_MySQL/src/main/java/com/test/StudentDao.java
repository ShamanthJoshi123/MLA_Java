package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
	public static Connection getCon() {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/mlafeb";
		String user = "root";
		String pas = "root@39";
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,pas);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	public void saveStudent(Student stud) {
		try {
			String sql="insert into student(usn,stud_name,college,branch)values(?,?,?,?)";
			Connection con = StudentDao.getCon();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, stud.getUsn());
			pst.setString(2, stud.getName());
			pst.setString(3, stud.getClg());
			pst.setString(4, stud.getBranch());
			pst.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public List<Student> getAllStudents(){
		List<Student> studList = new ArrayList<>();
		try {
			String sql = "select * from student";
			PreparedStatement pst = StudentDao.getCon().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Student stud = new Student();
				stud.setUsn(rs.getInt(1));
				stud.setName(rs.getString(2));
				stud.setClg(rs.getString(3));
				stud.setBranch(rs.getString(4));
				
				studList.add(stud);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return studList;
	}
	public void updateStudent(Student stud) {
		try {
			String sql = "update student set stud_name=?,college=?,branch=? where usn=?";
			PreparedStatement pst = StudentDao.getCon().prepareStatement(sql);
			pst.setString(1,stud.getName());
			pst.setString(2, stud.getClg());
			pst.setString(3, stud.getBranch());
			pst.setInt(4, stud.getUsn());
			pst.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public void deleteStudent(int usn) {
		try {
			String sql="delete from student where usn=?";
			PreparedStatement pst = StudentDao.getCon().prepareStatement(sql);
			pst.setInt(1, usn);
			pst.execute();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
