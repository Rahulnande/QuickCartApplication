package com.project.quickcart.model;

public class Order {

    private String orderId;
    private Product product;
    private int quantity;
    private double totalAmount;
    private String orderStatus;
    private String trackingStatus;
    private int deliveryDays;

   public Order(
        String orderId,
        Product product,
        int quantity,
        double totalAmount,
        String orderStatus,
        String trackingStatus,
        int deliveryDays)
{
    this.orderId =
            orderId;

    this.product =
            product;

    this.quantity =
            quantity;

    this.totalAmount =
            totalAmount;

    this.orderStatus =
            orderStatus;

    this.trackingStatus =
            trackingStatus;

    this.deliveryDays =
            deliveryDays;
}
    public String getOrderId()
    {
        return orderId;
    }

    public Product getProduct()
    {
        return product;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public double getTotalAmount()
    {
        return totalAmount;
    }

    public String getOrderStatus()
    {
        return orderStatus;
    }

    public void setOrderStatus(
            String orderStatus)
    {
        this.orderStatus =
                orderStatus;
    }
    public String getTrackingStatus()
    {
        return trackingStatus;
    }

    public void setTrackingStatus(
            String trackingStatus)
    {
        this.trackingStatus =
                trackingStatus;
    }

    public int getDeliveryDays()
    {
        return deliveryDays;
    }
    
    

  @Override
public String toString()
{
    return "\nOrder ID : "
            + orderId
            +
            "\nProduct Name : "
            + product.getProductName()
            +
            "\nQuantity : "
            + quantity
            +
            "\nTotal Amount : ₹"
            + totalAmount
            +
            "\nOrder Status : "
            + orderStatus
            +
            "\nTracking Status : "
            + trackingStatus
            +
            "\nExpected Delivery : "
            + deliveryDays
            + " Days";
}
}