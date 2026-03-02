package com.test.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableMethodSecurity
public class UserController {

   
	@GetMapping("/")
	public String homePage() {
		return "index";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	@GetMapping("user/read")
  	@ResponseBody
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER', 'ROLE_HR', 'ROLE_EMPLOYEE')")
	public String userPage() {
		return "ALL THE USER CAN READ THE DATA";
	}
	
	@GetMapping("/delete")
	@ResponseBody
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public String adminPage() {
		return "ONLY ADMIN CAN DELETE THE DATA";
	}
	

	@GetMapping("user/hr/onboard")
	@ResponseBody
	@PreAuthorize("hasAnyRole('ROLE_HR', 'ROLE_ADMIN')")
	public String updateHR() {
		return "ONLY HR AND ADMIN CAN ASSIGN TASK";
	}
	
//	@GetMapping("/work")
//	@ResponseBody
//	@PreAuthorize("hasRole('ROLE_EMPLOYEE')")
//	public String empPage() {
//		return "ONLY EMPLOYEE CAN WORK";
//	}
	
	@GetMapping("/update")
	@ResponseBody
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public String updateUsers() {
		return "Details updated with ADMIN role";
	}
	
	
	
}
