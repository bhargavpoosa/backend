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

    private double price;

    public Cart(String prod_id, int quantity, double price) {
        this.productId = prod_id;
        this.quantity = quantity;
        this.price = price;
    }

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
