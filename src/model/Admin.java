package model;

public class Admin extends User {

    // Constructor
	public Admin(
	        String adminId,
	        String fullName,
	        String username,
	        String password)
	{
	    super(
	            adminId,
	            fullName,
	            username,
	            password,
	            "ADMIN"
	    );
	
    }
}