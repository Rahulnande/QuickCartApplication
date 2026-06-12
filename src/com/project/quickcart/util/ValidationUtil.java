package com.project.quickcart.util;

public class ValidationUtil {
	
	   public static boolean isValidUsername(String username) {

	        // Minimum 4 characters
	        if (username == null || username.length() < 4) {
	            return false;
	        }

	        return true;
	    }



	   public static boolean isValidPassword(String password) {

	        // At least 1 Uppercase, 1 Lowercase, 1 Number, 1 Special Character
	        String regex =
	                "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$";

	        return password.matches(regex);
	    }
}