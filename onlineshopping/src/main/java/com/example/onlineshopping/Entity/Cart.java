package com.example.onlineshopping.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="cart")
public class Cart {
    @Id
    private String productId;

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


    public Cart(String prod_id, int quantity, double price, String productName, String imageUrl) {
        this.productId = prod_id;
        this.quantity = quantity;
        this.price = price;
        this.productName = productName;
        this.imageUrl = imageUrl;
    }

    public Cart(){}

    public String getProd_id() {
        return productId;
    }

    public void setProd_id(String prod_id) {
        this.productId = prod_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
