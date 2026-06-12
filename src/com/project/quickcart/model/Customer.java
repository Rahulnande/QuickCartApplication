package com.project.quickcart.model;

public class Customer extends User {
	
	 private String customerId;
	  public Customer(
	            String customerId,
	            String fullName,
	            String username,
	            String password,
	            String securityAnswer)
	    {
	        super(
	                fullName,
	                username,
	                password,
	                "CUSTOMER",
	                securityAnswer
	        );

	        this.customerId =
	                customerId;
	    }

	    public String getCustomerId()
	    {
	        return customerId;
	    }

	    public void setCustomerId(
	            String customerId)
	    {
	        this.customerId =
	                customerId;
	    }
	
}