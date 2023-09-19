package com.example.onlineshopping.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
    @Id
    private String orderId;

    private double totalAmount;

    private String orderTime;

    public String getProductList() {
        return productList;
    }

    public void setProductList(String productList) {
        this.productList = productList;
    }

    private String productList;

    public Order(String orderId, double totalAmount, String orderTime, String productList) {
        this.orderId = orderId;
        this.totalAmount = totalAmount;
        this.orderTime = orderTime;
        this.productList = productList;
    }

    public Order(){}

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
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
