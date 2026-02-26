package com.test;

import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class HelloService {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/text")
	public String simplePlainTextResponse() {
		return "This is simple Restful web service Plain text Response";
	}
	@GET
	@Produces
	@Path("/html/{debit}")
	public String htmlResponse(@PathParam("debit") String card) {
		return "<html><body><h1> Simple RestAPI HTML Response card no : "+card+" </h1></body></html>";
	}
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String greetUserResponse(@QueryParam("msg") String msg) {
		return msg;
	}
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserDetails> listAllUsersData(){
		UserDetails u1 = new UserDetails(1,"Rohit","Sharma","java@dev.com",2345234);
		UserDetails u2 = new UserDetails(2,"Virat","Kohli","anushka@dev.com",425234);
		UserDetails u3 = new UserDetails(3,"Surya","Kumar","kumar@dev.com",7245234);
		return List.of(u1,u2,u3);
	}
	
}
