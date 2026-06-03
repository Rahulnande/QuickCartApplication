package main;

import java.util.Scanner;
import service.ProductService;
import model.User;
import service.AuthService;

public class QuickCartApp {

    static Scanner sc =new Scanner(System.in);

    //static AuthService authService =new AuthService();

    static AuthService authService =
            new AuthService(sc);
    
    static ProductService
    productService =
    new ProductService(sc);
    
    
    public static void main(String[] args) {

        while(true)
        {
            try {
            	
            	
            	

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
    	

    	boolean adminLoggedIn =
    	        true;

    	while(adminLoggedIn)
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
    	            "3. Update Product"
    	    );

    	    System.out.println(
    	            "4. Delete Product"
    	    );

    	    System.out.println(
    	            "5. Manage Orders"
    	    );

    	    System.out.println(
    	            "6. Search Invoice"
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
    	            productService.addProduct();
    	            break;

    	        case 2:
    	            productService.viewProducts();
    	            break;

    	        case 3:
    	            productService.updateProduct();
    	            break;

    	        case 4:
    	            productService.deleteProduct();
    	            break;

    	        case 5:
    	            productService.manageOrders();
    	            break;

    	        case 6:
    	            productService.searchInvoiceByOrderId();
    	            break;

    	        case 7:

    	            System.out.println(
    	                    "Admin Logout Successful"
    	            );

    	            adminLoggedIn =
    	                    false;

    	            break;

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
	 boolean customerLoggedIn =
		        true;

	while(customerLoggedIn)
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
                "3. View Cart"
        );

        System.out.println(
                "4. Buy Product"
        );

        System.out.println(
                "5. Order History"
        );

        System.out.println(
                "6. Cancel Order"
        );

        System.out.println(
                "7. Return Order"
        );

        System.out.println(
                "8. Track Order"
        );
        System.out.println(
                "9. Logout"
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

                productService
                        .viewProducts();

                break;

            case 2:

                productService
                        .addToCart();

                break;

            case 3:

                productService
                        .viewCart();

                break;

            case 4:
                productService.buyProduct(user);
                break;

            case 5:

                productService
                        .viewOrders();

                break;

            case 6:
                productService.cancelOrder(user);
                break;

            case 7:
                productService.returnOrder(user);
                break;

            case 8:

                productService
                        .trackOrder();

                break;

            case 9:

                System.out.println(
                        "Customer Logout Successful"
                );
                
                customerLoggedIn =
                        false;

                break;
            default:

                System.out.println(
                        "Invalid Choice"
                );
        }
    }
}
}