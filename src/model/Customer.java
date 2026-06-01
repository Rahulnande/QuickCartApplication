package model;

public class Customer extends User {

    // Constructor
    public Customer(String userId,
                    String fullName,
                    String username,
                    String password)
    {
        super(
                userId,
                fullName,
                username,
                password,
                "CUSTOMER"
        );
    }
}