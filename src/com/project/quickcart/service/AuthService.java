package com.project.quickcart.service;

import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;

import com.project.quickcart.model.Admin;
import com.project.quickcart.model.Customer;
import com.project.quickcart.model.User;
import com.project.quickcart.util.PasswordUtil;
import com.project.quickcart.util.ValidationUtil;
import com.project.quickcart.util.PasswordUtil;

public class AuthService {

    private Scanner sc;

    public AuthService(Scanner sc)
    {
        this.sc = sc;
    }

    ArrayList<User> userList =
            new ArrayList<User>();

    private final String ADMIN_SECRET_KEY =
            "ADMIN@123";


    // ================= PASSWORD INPUT =================

    public String readPassword()
    {
        Console console =
                System.console();

        // CMD / Terminal
        if(console != null)
        {
            char[] passwordArray =
                    console.readPassword(
                            "Enter Password : "
                    );

            return new String(
                    passwordArray
            );
        }

        // Eclipse fallback
        System.out.print(
                "Enter Password : "
        );

        return sc.nextLine();
    }


    // ================= REGISTER =================

   public void register() throws Exception
{
System.out.println(
"\n========= REGISTER ========="
);


System.out.println(
        "Register As:"
);

System.out.println(
        "1. Customer"
);

System.out.println(
        "2. Admin"
);

System.out.print(
        "Enter Choice : "
);

int choice =
        Integer.parseInt(
                sc.nextLine()
        );

System.out.print(
        "Enter Full Name : "
);

String fullName =
        sc.nextLine();

// ================= USERNAME =================

String username = "";

while(true)
{
    System.out.print(
            "Enter Username : "
    );

    username =
            sc.nextLine();

    // Lowercase validation
    if(!username.equals(
            username.toLowerCase()))
    {
        System.out.println(
                "Username Must Be In Lowercase Only"
        );

        continue;
    }

    if(!ValidationUtil
            .isValidUsername(
                    username))
    {
        System.out.println(
                "Invalid Username"
        );

        System.out.println(
                "Minimum 4 letters"
        );

        System.out.println(
                "Only letters, numbers, _ allowed"
        );

        continue;
    }

    boolean exists =
            false;

    for(User user : userList)
    {
        if(user.getUsername()
                .equalsIgnoreCase(
                        username))
        {
            exists =
                    true;

            break;
        }
    }

    if(exists)
    {
        System.out.println(
                "Username Already Exists"
        );

        continue;
    }

    break;
}

// ================= PASSWORD =================

String password =
        "";

while(true)
{
    password =
            readPassword();

    if(!ValidationUtil
            .isValidPassword(
                    password))
    {
        System.out.println(
                "\nInvalid Password!"
        );

        System.out.println(
                "Password must contain:"
        );

        System.out.println(
                "1 Uppercase Letter"
        );

        System.out.println(
                "1 Lowercase Letter"
        );

        System.out.println(
                "1 Number"
        );

        System.out.println(
                "1 Special Character"
        );

        System.out.println(
                "Minimum 8 Characters"
        );

        continue;
    }

    System.out.print(
            "Confirm Password : "
    );

    String confirmPassword =
            sc.nextLine();

    if(!password.equals(
            confirmPassword))
    {
        System.out.println(
                "Password Not Matched"
        );

        continue;
    }

    break;
}

// ================= PASSWORD ENCRYPT =================

String encryptedPassword =
        PasswordUtil
        .encryptPassword(
                password
        );

System.out.println(
        "Encrypted Password : "
        + encryptedPassword
);

// ================= SECURITY QUESTION =================

System.out.print(
        "Enter Security Answer (Favourite Color) : "
);

String securityAnswer =
        sc.nextLine()
        .toLowerCase();

// ================= CUSTOMER =================

if(choice == 1)
{
    String customerId =
            "CUS" +
            (int)(
                    Math.random()
                    * 10000
            );

    Customer customer =
            new Customer(
                    customerId,
                    fullName,
                    username,
                    encryptedPassword,
                    securityAnswer
            );

    userList.add(
            customer
    );

    System.out.println(
            "\nCreating Account..."
    );

    Thread.sleep(
            1500
    );

    System.out.println(
            "\nCustomer Registered Successfully"
    );

    System.out.println(
            "Customer ID : "
            + customerId
    );
}

// ================= ADMIN =================

else if(choice == 2)
{
    System.out.print(
            "Enter Admin Secret Key : "
    );

    String key =
            sc.nextLine();

    if(!key.equals(
            ADMIN_SECRET_KEY))
    {
        System.out.println(
                "Invalid Secret Key"
        );

        return;
    }

    String adminId =
            "ADM" +
            (int)(
                    Math.random()
                    * 10000
            );

    Admin admin =
            new Admin(
                    adminId,
                    fullName,
                    username,
                    encryptedPassword,
                    securityAnswer
            );

    userList.add(
            admin
    );

    System.out.println(
            "\nCreating Account..."
    );

    Thread.sleep(
            1500
    );

    System.out.println(
            "\nAdmin Registered Successfully"
    );

    System.out.println(
            "Admin ID : "
            + adminId
    );
}

else
{
    System.out.println(
            "Invalid Choice"
    );
}


}



    // ================= LOGIN =================
    public User login()
    {
        System.out.println(
                "\n========= LOGIN ========="
        );

        System.out.print(
                "Enter Username : "
        );

        String username =
                sc.nextLine()
                .toLowerCase();

        System.out.print(
                "Enter Password : "
        );

        String password =
                sc.nextLine();

        // Encrypt entered password
        String encryptedPassword =
        		PasswordUtil.encryptPassword(
                        password
                );

        // Check user
        for(User user : userList)
        {
            if(user.getUsername()
                    .equals(username)
                    &&
               user.getPassword()
                    .equals(encryptedPassword))
            {
                System.out.println(
                        "\nLogin Successful"
                );

                return user;
            }
        }

        System.out.println(
                "\nInvalid Credentials"
        );

        return null;
    }

    
public void forgotPassword()
{
System.out.println(
"\n========= FORGOT PASSWORD ========="
);

System.out.println(
        "Press 0 To Go Back"
);

System.out.print(
        "Enter Username : "
);

String username =
        sc.nextLine();

if(username.equals("0"))
{
    return;
}

User foundUser =
        null;

// Search User
for(User user : userList)
{
    if(user.getUsername()
            .equalsIgnoreCase(
                    username))
    {
        foundUser =
                user;

        break;
    }
}

if(foundUser == null)
{
    System.out.println(
            "Username Not Found"
    );

    return;
}

// ================= SECURITY VERIFICATION =================

System.out.print(
        "Enter Security Answer (Favourite Color) : "
);

String securityAnswer =
        sc.nextLine()
        .toLowerCase();

if(!foundUser
        .getSecurityAnswer()
        .equalsIgnoreCase(
                securityAnswer))
{
    System.out.println(
            "Security Answer Incorrect"
    );

    return;
}

// ================= NEW PASSWORD =================

String newPassword =
        "";

while(true)
{
    System.out.print(
            "Enter New Password : "
    );

    newPassword =
            sc.nextLine();

    if(!ValidationUtil
            .isValidPassword(
                    newPassword))
    {
        System.out.println(
                "\nInvalid Password!"
        );

        System.out.println(
                "Password must contain:"
        );

        System.out.println(
                "1 Uppercase Letter"
        );

        System.out.println(
                "1 Lowercase Letter"
        );

        System.out.println(
                "1 Number"
        );

        System.out.println(
                "1 Special Character"
        );

        System.out.println(
                "Minimum 8 Characters"
        );

        continue;
    }

    System.out.print(
            "Confirm New Password : "
    );

    String confirmPassword =
            sc.nextLine();

    if(!newPassword.equals(
            confirmPassword))
    {
        System.out.println(
                "Password Not Matched"
        );

        continue;
    }

    break;
}

// Encrypt Password
String encryptedPassword =
        PasswordUtil
        .encryptPassword(
                newPassword
        );

foundUser.setPassword(
        encryptedPassword
);

System.out.println(
        "\nPassword Reset Successful"
);

System.out.println(
        "Please Login Again"
);


}




    private String encryptPassword(String newPassword) {
		// TODO Auto-generated method stub
		return null;
	}


	// ================= VIEW USERS =================

    public void viewUsers()
    {
        if(userList.isEmpty())
        {
            System.out.println(
                    "No Users Found"
            );

            return;
        }

        System.out.println(
                "\n========= USERS ========="
        );

        for(User user : userList)
        {
            System.out.println(
                    user
            );
        }
    }
}