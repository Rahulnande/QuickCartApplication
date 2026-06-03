package service;

import java.io.FileWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;

import model.Product;
import model.User;
import model.Cart;
import model.Order;
public class ProductService {

    private Scanner sc;

    public ProductService(
            Scanner sc)
    {
        this.sc = sc;
    }

    public static ArrayList<Product>
    productList =
    new ArrayList<Product>();
    
    ArrayList<Cart> cartList =
            new ArrayList<Cart>();
    
    ArrayList<Order> orderList =
            new ArrayList<Order>();


    // ================= ADD PRODUCT =================

    public void addProduct()
    {
        System.out.println(
                "\n========= ADD PRODUCT ========="
        );

        // Random Product ID
        String productId =
                "PRO" +
                (int)(
                        Math.random() * 10000
                );

        System.out.print(
                "Enter Product Name : "
        );

        String productName =
                sc.nextLine();

        // ================= CATEGORY =================

        System.out.println(
                "\nSelect Category"
        );

        System.out.println(
                "1. Mobile"
        );

        System.out.println(
                "2. Laptop"
        );

        System.out.println(
                "3. Fashion"
        );

        System.out.println(
                "4. Grocery"
        );

        System.out.println(
                "5. Electronics"
        );

        System.out.print(
                "Enter Choice : "
        );

        int categoryChoice =
                Integer.parseInt(
                        sc.nextLine()
                );

        String category =
                "";

        switch(categoryChoice)
        {
            case 1:
                category =
                        "Mobile";
                break;

            case 2:
                category =
                        "Laptop";
                break;

            case 3:
                category =
                        "Fashion";
                break;

            case 4:
                category =
                        "Grocery";
                break;

            case 5:
                category =
                        "Electronics";
                break;

            default:
                System.out.println(
                        "Invalid Category"
                );

                return;
        }

        System.out.print(
                "Enter Brand Name : "
        );

        String brand =
                sc.nextLine();

        System.out.print(
                "Enter Product Price : "
        );

        double price =
                Double.parseDouble(
                        sc.nextLine()
                );

        System.out.print(
                "Enter Stock Quantity : "
        );

        int stock =
                Integer.parseInt(
                        sc.nextLine()
                );

        System.out.print(
                "Enter Description : "
        );

        String description =
                sc.nextLine();

        // Create Product Object
        Product product =
                new Product(
                        productId,
                        productName,
                        category,
                        brand,
                        price,
                        stock,
                        description
                );

        // Add in list
        productList.add(
                product
        );

        System.out.println(
                "\nProduct Added Successfully"
        );

        System.out.println(
                "Generated Product ID : "
                + productId
        );
    }


    // ================= VIEW PRODUCT =================

    public void viewProducts()
    {
        if(productList
                .isEmpty())
        {
            System.out.println(
                    "\nNo Products Available"
            );

            return;
        }

        System.out.println(
                "\n========= PRODUCT LIST ========="
        );

        for(Product product
                : productList)
        {
            System.out.println(
                    product
            );

            System.out.println(
                    "----------------------"
            );
        }
    }
    
  //Update product
    public void updateProduct()
    {
        if(productList.isEmpty())
        {
            System.out.println(
                    "\nNo Products Available"
            );

            return;
        }

        System.out.println(
                "\n========= UPDATE PRODUCT ========="
        );

        System.out.print(
                "Enter Product ID : "
        );

        String productId =
                sc.nextLine();

        Product foundProduct =
                null;

        // Search Product
        for(Product product
                : productList)
        {
            if(product.getProductId()
                    .equalsIgnoreCase(
                            productId))
            {
                foundProduct =
                        product;

                break;
            }
        }

        // Product not found
        if(foundProduct == null)
        {
            System.out.println(
                    "Product Not Found"
            );

            return;
        }

        System.out.println(
                "\n1. Update Price"
        );

        System.out.println(
                "2. Update Stock"
        );

        System.out.println(
                "3. Update Both"
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

                System.out.print(
                        "Enter New Price : "
                );

                double newPrice =
                        Double.parseDouble(
                                sc.nextLine()
                        );

                foundProduct
                        .setPrice(
                                newPrice
                        );

                break;

            case 2:

                System.out.print(
                        "Enter New Stock : "
                );

                int newStock =
                        Integer.parseInt(
                                sc.nextLine()
                        );

                foundProduct
                        .setStock(
                                newStock
                        );

                break;

            case 3:

                System.out.print(
                        "Enter New Price : "
                );

                newPrice =
                        Double.parseDouble(
                                sc.nextLine()
                        );

                System.out.print(
                        "Enter New Stock : "
                );

                newStock =
                        Integer.parseInt(
                                sc.nextLine()
                        );

                foundProduct
                        .setPrice(
                                newPrice
                        );

                foundProduct
                        .setStock(
                                newStock
                        );

                break;

            default:

                System.out.println(
                        "Invalid Choice"
                );

                return;
        }

        System.out.println(
                "\nProduct Updated Successfully"
        );
    }
   
   //Delete product
    
    public void deleteProduct()
    {
        if(productList.isEmpty())
        {
            System.out.println(
                    "\nNo Products Available"
            );

            return;
        }

        System.out.println(
                "\n========= DELETE PRODUCT ========="
        );

        System.out.print(
                "Enter Product ID : "
        );

        String productId =
                sc.nextLine();

        Product foundProduct =
                null;

        // Search Product
        for(Product product
                : productList)
        {
            if(product.getProductId()
                    .equalsIgnoreCase(
                            productId))
            {
                foundProduct =
                        product;

                break;
            }
        }

        // Product not found
        if(foundProduct == null)
        {
            System.out.println(
                    "Product Not Found"
            );

            return;
        }

        productList.remove(
                foundProduct
        );

        System.out.println(
                "\nProduct Deleted Successfully"
        );
    }
    
  // Add cart
    
    public void addToCart()
    {
        if(productList.isEmpty())
        {
            System.out.println(
                    "\nNo Products Available"
            );

            return;
        }

        viewProducts();

        System.out.print(
                "\nEnter Product ID : "
        );

        String productId =
                sc.nextLine();

        Product foundProduct =
                null;

        // Search Product
        for(Product product
                : productList)
        {
            if(product.getProductId()
                    .equalsIgnoreCase(
                            productId))
            {
                foundProduct =
                        product;

                break;
            }
        }

        if(foundProduct == null)
        {
            System.out.println(
                    "Product Not Found"
            );

            return;
        }

        System.out.print(
                "Enter Quantity : "
        );

        int quantity =
                Integer.parseInt(
                        sc.nextLine()
                );

        // Stock Check
        if(quantity >
                foundProduct.getStock())
        {
            System.out.println(
                    "Out Of Stock"
            );

            return;
        }

        // Reduce Stock
        foundProduct.setStock(
                foundProduct.getStock()
                - quantity
        );

        Cart cart =
                new Cart(
                        foundProduct,
                        quantity
                );

        cartList.add(
                cart
        );

        System.out.println(
                "\nProduct Added To Cart Successfully"
        );
    }
   //View Cart
    
    public void viewCart()
    {
        if(cartList.isEmpty())
        {
            System.out.println(
                    "\nCart Is Empty"
            );

            return;
        }

        System.out.println(
                "\n========= CART ========="
        );

        double grandTotal =
                0;

        for(Cart cart
                : cartList)
        {
            System.out.println(
                    cart
            );

            System.out.println(
                    "----------------------"
            );

            grandTotal +=
                    cart.getTotalPrice();
        }

        System.out.println(
                "Grand Total : ₹"
                + grandTotal
        );
    }
    
   //Buy Product
    
    public void buyProduct(
            User currentUser)
{
    if(cartList.isEmpty())
    {
        System.out.println(
                "\nCart Is Empty"
        );

        return;
    }

    System.out.print(
            "\nEnter Product ID To Buy : "
    );

    String productId =
            sc.nextLine();

    Cart selectedCart =
            null;

    // Search product in cart
    for(Cart cart : cartList)
    {
        if(cart.getProduct()
                .getProductId()
                .equalsIgnoreCase(
                        productId))
        {
            selectedCart =
                    cart;

            break;
        }
    }

    if(selectedCart == null)
    {
        System.out.println(
                "Product Not Found In Cart"
        );

        return;
    }

    // Payment Method
    System.out.println(
            "\nChoose Payment Method"
    );

    System.out.println(
            "1. GPay"
    );

    System.out.println(
            "2. Credit Card"
    );

    System.out.println(
            "3. Cash"
    );

    System.out.print(
            "Enter Choice : "
    );

    int paymentChoice =
            Integer.parseInt(
                    sc.nextLine()
            );

    String paymentMethod =
            "";

    switch(paymentChoice)
    {
        case 1:

            paymentMethod =
                    "GPAY";

            break;

        case 2:

            paymentMethod =
                    "CREDIT CARD";

            break;

        case 3:

            System.out.println(
                    "\nCash On Delivery Not Allowed"
            );

            return;

        default:

            System.out.println(
                    "Invalid Payment Method"
            );

            return;
    }

    String orderId =
            "ORD" +
            (int)(
                    Math.random()
                    * 10000
            );

    Order order =
            new Order(
                    orderId,
                    selectedCart.getProduct(),
                    selectedCart.getQuantity(),
                    selectedCart.getTotalPrice(),
                    "PLACED",
                    "ORDER PLACED",
                    3
            );

    orderList.add(
            order
    );
    
    generateCustomerInvoice(
            order,
            paymentMethod,
            currentUser.getFullName(),
            currentUser.getUsername()
    );

    generateShopkeeperInvoice(
            order,
            paymentMethod,
            currentUser.getFullName(),
            currentUser.getUsername()
    );

    // Remove only purchased product from cart
    cartList.remove(
            selectedCart
    );

    System.out.println(
            "\nOrder Placed Successfully"
    );

    System.out.println(
            "Order ID : "
            + orderId
    );

    System.out.println(
            "Payment Method : "
            + paymentMethod
    );

    System.out.println(
            "Expected Delivery : 3 Days"
    );
}
    
    //View Order
    
    public void viewOrders()
    {
        if(orderList.isEmpty())
        {
            System.out.println(
                    "\nNo Orders Found"
            );

            return;
        }

        System.out.println(
                "\n========= ORDER HISTORY ========="
        );

        for(Order order
                : orderList)
        {
            System.out.println(
                    order
            );

            System.out.println(
                    "---------------------"
            );
        }
    }
    
   //cancel order
    
    double quickCartWallet =0;
            
    public void cancelOrder(User currentUser)
    {
        if(orderList.isEmpty())
        {
            System.out.println(
                    "\nNo Orders Found"
            );

            return;
        }

        viewOrders();

        System.out.print(
                "\nEnter Order ID : "
        );

        String orderId =
                sc.nextLine();

        for(Order order
                : orderList)
        {
            if(order.getOrderId()
                    .equalsIgnoreCase(
                            orderId))
            {
                // Already cancelled
                if(order.getOrderStatus()
                        .equalsIgnoreCase(
                                "CANCELLED"))
                {
                    System.out.println(
                            "Order Already Cancelled"
                    );

                    return;
                }

                // Update Status
                order.setOrderStatus(
                        "CANCELLED"
                );
                
                updateInvoiceStatus(
                        order,
                        currentUser.getUsername()
                );

                // Restore stock
                Product product =
                        order.getProduct();

                product.setStock(
                        product.getStock()
                        +
                        order.getQuantity()
                );
              
                quickCartWallet +=
                        order.getTotalAmount();
                System.out.println(
                		
                		"\nOrder Cancelled Successfully"
                				+
                				"\nRefund Credited To QuickCart Wallet : ₹"
                				+ order.getTotalAmount()
                				+
                				"\nWallet Balance : ₹"
                				+ quickCartWallet
                				+
                				"\nNote : Wallet Amount Cannot Be Withdrawn"
                				+
                				"\nYou Can Use It For Future Purchases"
                );

                return;
            }
        }

        System.out.println(
                "Invalid Order ID"
        );
    }
    
    //Return Order
    
    public void returnOrder(User currentUser)
    {
        if(orderList.isEmpty())
        {
            System.out.println(
                    "\nNo Orders Found"
            );

            return;
        }

        viewOrders();

        System.out.print(
                "\nEnter Order ID : "
        );

        String orderId =
                sc.nextLine();

        for(Order order
                : orderList)
        {
            if(order.getOrderId()
                    .equalsIgnoreCase(
                            orderId))
            {
                // Already Returned
                if(order.getOrderStatus()
                        .equalsIgnoreCase(
                                "RETURNED"))
                {
                    System.out.println(
                            "Order Already Returned"
                    );

                    return;
                }

                // Cancelled order not returnable
                if(order.getOrderStatus()
                        .equalsIgnoreCase(
                                "CANCELLED"))
                {
                    System.out.println(
                            "Cancelled Order Cannot Be Returned"
                    );

                    return;
                }

                // Update status
                order.setOrderStatus(
                        "RETURNED"
                );
                
                updateInvoiceStatus(
                        order,
                        currentUser.getUsername()
                );

                // Restore stock
                Product product =
                        order.getProduct();

                product.setStock(
                        product.getStock()
                        +
                        order.getQuantity()
                );

                System.out.println(
                		"\nOrder Returned Successfully"

                		+ "\n\nTRACKER HISTORY"

                		+ "\nOrder Placed ✓"

                		+ "\nPacked ✓"

                		+ "\nShipped ✓"

                		+ "\nDelivered ✓"

                		+ "\nReturn Requested ✓"

                		+ "\nRefund Processing ✓"

                		+ "\nRefund Completed ✓"
                );

                return;
            }
        }

        System.out.println(
                "Invalid Order ID"
        );
    }
    
   //Tracker Method
    
    public void trackOrder()
    {
        if(orderList.isEmpty())
        {
            System.out.println(
                    "\nNo Orders Found"
            );

            return;
        }

        viewOrders();

        System.out.print(
                "\nEnter Order ID : "
        );

        String orderId =
                sc.nextLine();

        for(Order order
                : orderList)
        {
            if(order.getOrderId()
                    .equalsIgnoreCase(
                            orderId))
            {
                System.out.println(
                        "\n========= TRACK ORDER ========="
                );

                System.out.println(
                        "Order Placed ✓"
                );

                if(order.getOrderStatus()
                        .equalsIgnoreCase(
                                "PLACED"))
                {
                    System.out.println(
                            "Packed (Waiting)"
                    );

                    System.out.println(
                            "Shipped (Waiting)"
                    );

                    System.out.println(
                            "Out For Delivery (Waiting)"
                    );

                    System.out.println(
                            "Delivered In "
                            + order.getDeliveryDays()
                            + " Days"
                    );
                }

                else if(order.getOrderStatus()
                        .equalsIgnoreCase(
                                "RETURNED"))
                {
                    System.out.println(
                            "Packed ✓"
                    );

                    System.out.println(
                            "Shipped ✓"
                    );

                    System.out.println(
                            "Delivered ✓"
                    );

                    System.out.println(
                            "Returned ✓"
                    );
                }

                else if(order.getOrderStatus()
                        .equalsIgnoreCase(
                                "CANCELLED"))
                {
                    System.out.println(
                            "Order Cancelled ❌"
                    );
                }

                return;
            }
        }

        System.out.println(
                "Invalid Order ID"
        );
    }
    
    //manage order
    
    public void manageOrders()
    {
        if(orderList.isEmpty())
        {
            System.out.println(
                    "\nNo Orders Available"
            );

            return;
        }

        System.out.println(
                "\n========= MANAGE ORDERS ========="
        );

        // Show all orders
        for(Order order : orderList)
        {
            System.out.println(
                    order
            );

            System.out.println(
                    "---------------------"
            );
        }

        System.out.print(
                "\nEnter Order ID : "
        );

        String orderId =
                sc.nextLine();

        Order foundOrder =
                null;
        
        

        // Find Order
        for(Order order : orderList)
        {
            if(order.getOrderId()
                    .equalsIgnoreCase(
                            orderId))
            {
                foundOrder =
                        order;

                break;
            }
        }

        if(foundOrder == null)
        {
            System.out.println(
                    "Invalid Order ID"
            );

            return;
        }
        if(foundOrder.getOrderStatus()
                .equalsIgnoreCase(
                        "CANCELLED"))
        {
            System.out.println(
                    "Cancelled Order Cannot Be Updated"
            );

            return;
        }

        if(foundOrder.getOrderStatus()
                .equalsIgnoreCase(
                        "RETURNED"))
        {
            System.out.println(
                    "Returned Order Cannot Be Updated"
            );

            return;
        }
        

        // Status Update Menu
        System.out.println(
                "\n1. Packed"
        );

        System.out.println(
                "2. Shipped"
        );

        System.out.println(
                "3. Out For Delivery"
        );

        System.out.println(
                "4. Delivered"
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

                foundOrder
                        .setTrackingStatus(
                                "PACKED"
                        );

                break;

            case 2:

                foundOrder
                        .setTrackingStatus(
                                "SHIPPED"
                        );

                break;

            case 3:

                foundOrder
                        .setTrackingStatus(
                                "OUT FOR DELIVERY"
                        );

                break;

            case 4:

                foundOrder.setTrackingStatus(
                        "DELIVERED"
                );

                foundOrder.setOrderStatus(
                        "DELIVERED"
                );

                // ================= GENERATE INVOICE =================

                try
                {
                    FileWriter writer =
                            new FileWriter(
                                    "Invoice_"
                                    + foundOrder.getOrderId()
                                    + ".txt"
                            );

                    writer.write(
                            "========= QUICKCART INVOICE =========\n"
                    );

                    writer.write(
                            "Order ID : "
                            + foundOrder.getOrderId()
                            + "\n"
                    );

                    writer.write(
                            "Product Name : "
                            + foundOrder
                            .getProduct()
                            .getProductName()
                            + "\n"
                    );

                    writer.write(
                            "Category : "
                            + foundOrder
                            .getProduct()
                            .getCategory()
                            + "\n"
                    );

                    writer.write(
                            "Brand : "
                            + foundOrder
                            .getProduct()
                            .getBrand()
                            + "\n"
                    );

                    writer.write(
                            "Quantity : "
                            + foundOrder.getQuantity()
                            + "\n"
                    );

                    writer.write(
                            "Total Amount : ₹"
                            + foundOrder.getTotalAmount()
                            + "\n"
                    );

                    writer.write(
                            "Order Status : "
                            + foundOrder.getOrderStatus()
                            + "\n"
                    );

                    writer.write(
                            "Tracking Status : "
                            + foundOrder.getTrackingStatus()
                            + "\n"
                    );

                    writer.write(
                            "Expected Delivery : "
                            + foundOrder.getDeliveryDays()
                            + " Days\n"
                    );

                    writer.write(
                            "\nThank You For Shopping With QuickCart"
                    );

                    writer.close();

                    System.out.println(
                            "\nInvoice Generated Successfully"
                    );

                    System.out.println(
                            "File Name : Invoice_"
                            + foundOrder.getOrderId()
                            + ".txt"
                    );
                }
                catch(Exception e)
                {
                    System.out.println(
                            "Invoice Generation Failed"
                    );
                }

                break;

            default:

                System.out.println(
                        "Invalid Choice"
                );

                return;
        }

        System.out.println(
                "\nOrder Updated Successfully"
        );

        System.out.println(
                "Current Status : "
                + foundOrder
                        .getTrackingStatus()
        );
        
   
        
    }
    public void generateCustomerInvoice(
            Order order,
            String paymentMethod,
            String customerName,
            String username)
    {
        try
        {
            File folder =
                    new File(
                            "customer_invoices"
                    );

            if(!folder.exists())
            {
                folder.mkdir();
            }

            String fileName =
                    "customer_invoices/"
                    + username
                    + "_invoice.txt";

            FileWriter writer =
                    new FileWriter(
                            fileName,
                            true
                    );

            writer.write(
                    "=====================================\n"
            );

            writer.write(
                    "       QUICKCART CUSTOMER INVOICE\n"
            );

            writer.write(
                    "=====================================\n"
            );

            writer.write(
                    "Customer Name : "
                    + customerName
                    + "\n"
            );

            writer.write(
                    "Username : "
                    + username
                    + "\n"
            );

            writer.write(
                    "Order ID : "
                    + order.getOrderId()
                    + "\n"
            );

            writer.write(
                    "Product Name : "
                    + order.getProduct()
                    .getProductName()
                    + "\n"
            );

            writer.write(
                    "Product ID : "
                    + order.getProduct()
                    .getProductId()
                    + "\n"
            );

            writer.write(
                    "Category : "
                    + order.getProduct()
                    .getCategory()
                    + "\n"
            );

            writer.write(
                    "Brand : "
                    + order.getProduct()
                    .getBrand()
                    + "\n"
            );

            writer.write(
                    "Quantity : "
                    + order.getQuantity()
                    + "\n"
            );

            writer.write(
                    "Total Amount : ₹"
                    + order.getTotalAmount()
                    + "\n"
            );

            writer.write(
                    "Payment Method : "
                    + paymentMethod
                    + "\n"
            );

            writer.write(
                    "Order Status : "
                    + order.getOrderStatus()
                    + "\n"
            );

            writer.write(
                    "Tracking Status : "
                    + order.getTrackingStatus()
                    + "\n"
            );

            writer.write(
                    "Expected Delivery : "
                    + order.getDeliveryDays()
                    + " Days\n"
            );

            writer.write(
                    "\nThank You For Shopping With QuickCart"
            );

            writer.close();

            System.out.println(
                    "\nCustomer Invoice Generated"
            );
        }
        catch(Exception e)
        {
            System.out.println(
                    "Customer Invoice Failed"
            );
        }
    }
    
    public void generateShopkeeperInvoice(
            Order order,
            String paymentMethod,
            String customerName,
            String username)
    {
        try
        {
            File folder =
                    new File(
                            "shopkeeper_invoices"
                    );

            if(!folder.exists())
            {
                folder.mkdir();
            }

            String fileName =
                    "shopkeeper_invoices/"
                    + "shopkeeper_invoice_"
                    + order.getOrderId()
                    + ".txt";

            FileWriter writer =
                    new FileWriter(
                            fileName,
                            true
                    );

            writer.write(
                    "=====================================\n"
            );

            writer.write(
                    "      QUICKCART SHOPKEEPER RECORD\n"
            );

            writer.write(
                    "=====================================\n"
            );

            writer.write(
                    "Customer Name : "
                    + customerName
                    + "\n"
            );

            writer.write(
                    "Username : "
                    + username
                    + "\n"
            );

            writer.write(
                    "Order ID : "
                    + order.getOrderId()
                    + "\n"
            );

            writer.write(
                    "Product Name : "
                    + order.getProduct()
                    .getProductName()
                    + "\n"
            );

            writer.write(
                    "Quantity : "
                    + order.getQuantity()
                    + "\n"
            );

            writer.write(
                    "Total Sale : ₹"
                    + order.getTotalAmount()
                    + "\n"
            );

            writer.write(
                    "Payment Method : "
                    + paymentMethod
                    + "\n"
            );

            writer.write(
                    "Order Status : "
                    + order.getOrderStatus()
                    + "\n"
            );

            writer.close();

            System.out.println(
                    "Shopkeeper Invoice Generated"
            );
        }
        catch(Exception e)
        {
            System.out.println(
                    "Shopkeeper Invoice Failed"
            );
        }
    }
    
    public void updateInvoiceStatus(
            Order order,
            String username)
    {
        try
        {
        	String fileName =
        	        "customer_invoices/"
        	        + username
        	        + "_invoice.txt";

        	FileWriter writer =
        	        new FileWriter(
        	                fileName,
        	                true
        	        );

            writer.write(
                    "=====================================\n"
            );

            writer.write(
                    "       QUICKCART CUSTOMER INVOICE\n"
            );

            writer.write(
                    "=====================================\n"
            );

            writer.write(
                    "Order ID : "
                    + order.getOrderId()
                    + "\n"
            );

            writer.write(
                    "Product Name : "
                    + order.getProduct()
                    .getProductName()
                    + "\n"
            );

            writer.write(
                    "Quantity : "
                    + order.getQuantity()
                    + "\n"
            );

            writer.write(
                    "Total Amount : ₹"
                    + order.getTotalAmount()
                    + "\n"
            );

            writer.write(
                    "Order Status : "
                    + order.getOrderStatus()
                    + "\n"
            );

            writer.write(
                    "Tracking Status : "
                    + order.getTrackingStatus()
                    + "\n"
            );

            writer.write(
                    "Expected Delivery : "
                    + order.getDeliveryDays()
                    + " Days\n"
            );

            // extra messages
            if(order.getOrderStatus()
                    .equalsIgnoreCase(
                            "CANCELLED"))
            {
                writer.write(
                        "\nRefund Status : SUCCESS"
                );

                writer.write(
                        "\nRefund Added To QuickCart Wallet"
                );
            }

            if(order.getOrderStatus()
                    .equalsIgnoreCase(
                            "RETURNED"))
            {
                writer.write(
                        "\nReturn Status : COMPLETED"
                );

                writer.write(
                        "\nRefund Processing : SUCCESS"
                );
            }

            writer.close();

            System.out.println(
                    "Invoice Updated Successfully"
            );
        }

        catch(Exception e)
        {
            System.out.println(
                    "Invoice Update Failed"
            );
        }
    }
    public void searchInvoiceByOrderId()
    {
        System.out.println(
                "\n========= SEARCH INVOICE ========="
        );

        System.out.print(
                "Enter Order ID : "
        );

        String orderId =
                sc.nextLine();

        String fileName =
                "shopkeeper_invoices/"
                + "shopkeeper_invoice_"
                + orderId
                + ".txt";

        File file =
                new File(
                        fileName
                );

        if(!file.exists())
        {
            System.out.println(
                    "Invoice Not Found"
            );

            return;
        }

        try
        {
            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(
                                    fileName
                            )
                    );

            String line;

            System.out.println(
                    "\n========= INVOICE DETAILS ========="
            );

            while(
                    (line =
                            reader.readLine())
                            != null
            )
            {
                System.out.println(
                        line
                );
            }

            reader.close();
        }

        catch(Exception e)
        {
            System.out.println(
                    "Error Reading Invoice"
            );
        }
    }
}