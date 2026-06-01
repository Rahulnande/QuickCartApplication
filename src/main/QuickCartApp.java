package main;

import java.util.Scanner;

import model.User;
import service.AuthService;

public class QuickCartApp {

    static Scanner sc =new Scanner(System.in);

    static AuthService authService =new AuthService();

    public static void main(String[] args) {

        while(true)
        {
            try {
            	System.out.println("hiii");

                System.out.println(
                        "\n********* WELCOME TO QUICKCART *********"
                );

                System.out.println(
                        "\n========= MAIN MENU ========="
                );

                System.out.println(
                        "1. Register"
                );

                System.out.println(
                        "2. Login"
                );

                System.out.println(
                        "3. Exit"
                );

                System.out.println(
                        "*******************************"
                );

                System.out.print(
                        "Enter Choice : "
                );

                int choice =Integer.parseInt(sc.nextLine());

                switch(choice)
                {
                    case 1:

                        authService.register();
                        break;

                    case 2:

                        User loggedInUser = authService.login();

                        if(loggedInUser != null)
                        {
                            // Role Based Login
                            if(loggedInUser
                                    .getRole()
                                    .equalsIgnoreCase(
                                            "ADMIN"))
                            {
                                adminMenu();
                            }

                            else if(loggedInUser
                                    .getRole()
                                    .equalsIgnoreCase(
                                            "CUSTOMER"))
                            {
                                customerMenu(
                                        loggedInUser
                                );
                            }
                        }

                        break;

                    case 3:

                        System.out.println(
                                "\nThank You For Using QuickCart"
                        );

                        System.exit(0);
                        break;

                    default:

                        System.out.println(
                                "Invalid Choice"
                        );
                }
            }

            catch(Exception e)
            {
                System.out.println(
                        "Enter Valid Number"
                );
            }
        }
    }

    // ================= ADMIN MENU =================

    public static void adminMenu()
    {
        while(true)
        {
            System.out.println(
                    "\n========= ADMIN PANEL ========="
            );

            System.out.println(
                    "1. Add Product"
            );

            System.out.println(
                    "2. View Products"
            );

            System.out.println(
                    "3. Manage Orders"
            );

            System.out.println(
                    "4. Logout"
            );

            System.out.print(
                    "Enter Choice : "
            );

            int choice =
                    Integer.parseInt(
                            sc.nextLine()
                    );

            switch(choice)
            {
                case 1:
                    System.out.println(
                            "Add Product Logic"
                    );
                    break;

                case 2:
                    System.out.println(
                            "View Product Logic"
                    );
                    break;

                case 3:
                    System.out.println(
                            "Manage Orders Logic"
                    );
                    break;

                case 4:
                    System.out.println(
                            "Admin Logout Successful"
                    );
                    return;

                default:
                    System.out.println(
                            "Invalid Choice"
                    );
            }
        }
    }

    // ================= CUSTOMER MENU =================

    public static void customerMenu(
            User user)
    {
        while(true)
        {
            System.out.println(
                    "\n========= CUSTOMER PANEL ========="
            );

            System.out.println(
                    "Welcome : "
                    + user.getFullName()
            );

            System.out.println(
                    "1. View Products"
            );

            System.out.println(
                    "2. Add To Cart"
            );

            System.out.println(
                    "3. Buy Product"
            );

            System.out.println(
                    "4. Order History"
            );

            System.out.println(
                    "5. Cancel Order"
            );

            System.out.println(
                    "6. Return Order"
            );

            System.out.println(
                    "7. Logout"
            );

            System.out.print(
                    "Enter Choice : "
            );

            int choice =
                    Integer.parseInt(
                            sc.nextLine()
                    );

            switch(choice)
            {
                case 1:
                    System.out.println(
                            "View Product Logic"
                    );
                    break;

                case 2:
                    System.out.println(
                            "Add To Cart Logic"
                    );
                    break;

                case 3:
                    System.out.println(
                            "Buy Product Logic"
                    );
                    break;

                case 4:
                    System.out.println(
                            "Order History Logic"
                    );
                    break;

                case 5:
                    System.out.println(
                            "Cancel Order Logic"
                    );
                    break;

                case 6:
                    System.out.println(
                            "Return Order Logic"
                    );
                    break;

                case 7:
                    System.out.println(
                            "Customer Logout Successful"
                    );
                    return;

                default:
                    System.out.println(
                            "Invalid Choice"
                    );
            }
        }
    }
}