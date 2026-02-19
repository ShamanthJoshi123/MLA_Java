package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.annotation.WebServlet;


@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name=request.getParameter("fname");
		String user=request.getParameter("user");
		String pas=request.getParameter("pwd");
		
		Customer cst=new Customer();
		cst.setFullName(name);
		cst.setUserName(user);
		cst.setPassword(pas);
		String sql="insert into customer values('"+cst.getFullName()+"','"+cst.getUserName()+"', '"+cst.getPassword()+"')";
		int dt=0;
		try {
			Connection con=DBConnect.getCon();
			Statement stmt=con.createStatement();
			dt = stmt.executeUpdate(sql);
			if(dt>0) {
				response.sendRedirect("login.html");
//	OR
				RequestDispatcher rd=request.getRequestDispatcher("login.html");
//				rd.forward(request, response);
			}else {
				out.println("<center><font color='red'>Registration failed.</font></center>");
				RequestDispatcher rd=request.getRequestDispatcher("register.html");
				rd.include(request, response);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
