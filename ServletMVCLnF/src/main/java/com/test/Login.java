package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String user=request.getParameter("user");
		String pas=request.getParameter("pwd");
		Customer cst=new Customer();
		String sql="select username,password from customer where username='"+user+"' and password='"+pas+"' ";
		try {
			Connection con = DBConnect.getCon();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				cst.setUserName(rs.getString(1));
				cst.setPassword(rs.getString(2));
			}
			if(user.equals(cst.getUserName()) && pas.equals(cst.getPassword())) {
				RequestDispatcher rd=request.getRequestDispatcher("home.html");
				rd.forward(request, response); 
				// OR response.sendRedirect("home.html");
			}else {
				out.println("<center><font color='red'>Invalid Credentials</font></center>");
				RequestDispatcher rd=request.getRequestDispatcher("login.html");
				rd.include(request, response);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
