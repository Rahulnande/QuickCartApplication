
package service;

import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;


import model.Admin;
import model.Customer;
import model.User;
import util.PasswordUtil;
import util.ValidationUtil;

public class AuthService {

    Scanner sc = new Scanner(System.in);

    ArrayList<User> userList =
            new ArrayList<User>();

    private final String ADMIN_SECRET_KEY =
            "ADMIN@123";


    // ================= PASSWORD MASK =================

    public String readPassword()
    {
        JFrame frame =
                new JFrame();

        frame.setAlwaysOnTop(true);

        JPasswordField passwordField =
                new JPasswordField();

        int option =
                JOptionPane.showConfirmDialog(
                        frame,
                        passwordField,
                        "Enter Password",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE
                );

        frame.dispose();

        if(option ==
                JOptionPane.OK_OPTION)
        {
            return new String(
                    passwordField.getPassword()
            );
        }

        return "";
    }
    // ================= REGISTER =================

    public void register()
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

            boolean exists = false;

            for(User user : userList)
            {
                if(user.getUsername()
                        .equalsIgnoreCase(
                                username))
                {
                    exists = true;
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
                readPassword();

        String encryptedPassword =
                PasswordUtil.encryptPassword(
                        password
                );


        // ================= CUSTOMER REGISTER =================

        if(choice == 1)
        {
            String customerId =
                    "CUS" +
                    (int)(
                            Math.random() * 10000
                    );

            Customer customer =
                    new Customer(
                            customerId,
                            fullName,
                            username,
                            encryptedPassword
                    );

            userList.add(customer);

            System.out.println(
                    "\nCustomer Registered Successfully"
            );

            System.out.println(
                    "Customer ID : "
                    + customerId
            );
        }


        // ================= ADMIN REGISTER =================

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
                            Math.random() * 10000
                    );

            Admin admin =
                    new Admin(
                            adminId,
                            fullName,
                            username,
                            encryptedPassword
                    );

            userList.add(admin);

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
                sc.nextLine();

        String password =
                readPassword();

        // Encrypt entered password
        String encryptedPassword =
                PasswordUtil.encryptPassword(
                        password
                );

        for(User user : userList)
        {
            if(user.getUsername()
                    .equalsIgnoreCase(
                            username)
                    &&
               user.getPassword()
                    .equals(
                            encryptedPassword))
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

