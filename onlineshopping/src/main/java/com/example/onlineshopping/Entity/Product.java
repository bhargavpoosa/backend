package com.example.onlineshopping.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="product")
public class Product {
    @Id
    @Column(name = "prod_id")
    private String productId;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    @Column(name = "image_url")
    private String imageUrl;


    @Column(name = "prod_name")
    private String productName;


    @Column(name = "price")
    private double price;


    @Column(name = "item_count")
    private int itemCount;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name="description")
    private String description;

    public Product(){}

    public Product(String productId, String productName, double price, int itemCount, String imageUrl, String description) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.itemCount = itemCount;
        this.imageUrl = imageUrl;
        this.description = description;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }
}
