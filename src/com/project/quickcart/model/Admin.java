package com.project.quickcart.model;

public class Admin extends User {
	 private String adminId;
	 public Admin(
		        String adminId,
		        String fullName,
		        String username,
		        String password,
		        String securityAnswer)
		{
		    super(
		            fullName,
		            username,
		            password,
		            "ADMIN",
		            securityAnswer
		    );

		    this.adminId = adminId;
		}
}
	
    
