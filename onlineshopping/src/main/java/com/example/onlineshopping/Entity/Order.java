package com.example.onlineshopping.Entity;


import jakarta.persistence.*;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @Column(name="order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    @Column(name = "user_name")
    private String username;

    private double totalAmount;

    private String orderTime;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public String getProductList() {
        return productList;
    }

    public void setProductList(String productList) {
        this.productList = productList;
    }

    private String productList;

    public Order(double totalAmount, String orderTime, String productList, String username) {
        this.totalAmount = totalAmount;
        this.orderTime = orderTime;
        this.productList = productList;
        this.username = username;
    }

    public Order(){}

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }
}
