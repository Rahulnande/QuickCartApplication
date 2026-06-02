package model;

public class Cart {

    private Product product;
    private int quantity;

    public Cart(
            Product product,
            int quantity)
    {
        this.product =
                product;

        this.quantity =
                quantity;
    }

    public Product getProduct()
    {
        return product;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public double getTotalPrice()
    {
        double total =
                product.getPrice()
                * quantity;

        double gst =
                total * 0.18;

        return total + gst;
    }

    @Override
    public String toString()
    {
        return "\nProduct ID : "
                + product.getProductId()
                +
                "\nProduct Name : "
                + product.getProductName()
                +
                "\nQuantity : "
                + quantity
                +
                "\nPrice : ₹"
                + product.getPrice()
                +
                "\nGST : 18%"
                +
                "\nTotal Amount : ₹"
                + getTotalPrice();
    }
}