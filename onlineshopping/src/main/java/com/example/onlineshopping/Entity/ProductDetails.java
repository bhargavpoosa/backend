package com.example.onlineshopping.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "productDetails")
public class ProductDetails {

    @Id
    private String id;
    @Field("productId")
    private Integer productId;

    private String productReviews;

    private String productRatings;

    public ProductDetails(){}

    public ProductDetails(int productId, String productReviews, String productRatings) {
        this.productId = productId;
        this.productReviews = productReviews;
        this.productRatings = productRatings;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductReviews() {
        return productReviews;
    }

    public void setProductReviews(String productReviews) {
        this.productReviews = productReviews;
    }

    public String getProductRatings() {
        return productRatings;
    }

    public void setProductRatings(String productRatings) {
        this.productRatings = productRatings;
    }
}
