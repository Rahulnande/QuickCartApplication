package com.project.quickcart.model;

public class Product {

    private String productId;
    private String productName;
    private String category;
    private String brand;
    private double price;
    private int stock;
    private String description;

    // Constructor
    public Product(
            String productId,
            String productName,
            String category,
            String brand,
            double price,
            int stock,
            String description)
    {
        this.productId =
                productId;

        this.productName =
                productName;

        this.category =
                category;

        this.brand =
                brand;

        this.price =
                price;

        this.stock =
                stock;

        this.description =
                description;
    }

    // Getters

    public String getProductId()
    {
        return productId;
    }

    public String getProductName()
    {
        return productName;
    }

    public String getCategory()
    {
        return category;
    }

    public String getBrand()
    {
        return brand;
    }

    public double getPrice()
    {
        return price;
    }

    public int getStock()
    {
        return stock;
    }

    public String getDescription()
    {
        return description;
    }

    // Setters

    public void setPrice(
            double price)
    {
        this.price =
                price;
    }

    public void setStock(
            int stock)
    {
        this.stock =
                stock;
    }
    public void setDescription(
            String description)
    {
        this.description =
                description;
    }

    @Override
    public String toString()
    {
        return "\nProduct ID : "
                + productId
                +
                "\nProduct Name : "
                + productName
                +
                "\nCategory : "
                + category
                +
                "\nBrand : "
                + brand
                +
                "\nPrice : ₹"
                + price
                +
                "\nStock : "
                + stock
                +
                "\nDescription : "
                + description;
    }
}