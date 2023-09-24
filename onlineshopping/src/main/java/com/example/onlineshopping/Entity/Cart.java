package com.example.onlineshopping.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cart", indexes = {
        @Index(name = "idx_user_name", columnList = "user_name")
})
public class Cart {
    public int getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(int cartItemId) {
        this.cartItemId = cartItemId;
    }

    @Id
    @Column(name="cart_item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartItemId;

    @Column(name="user_name")
    private String username;

    private int productId;

    private int quantity;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    private double price;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    private String productName;

    private String imageUrl;


    public Cart(String username, int prod_id, int quantity, double price, String productName, String imageUrl) {
        this.username = username;
        this.productId = prod_id;
        this.quantity = quantity;
        this.price = price;
        this.productName = productName;
        this.imageUrl = imageUrl;
    }

    public Cart(){}

    public int getProd_id() {
        return productId;
    }

    public void setProd_id(int prod_id) {
        this.productId = prod_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
