package com.omnirio.demo.entity;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    private String productId;
    @Column
    private String productName;
    @OneToOne
    @JoinColumn(name = "categoryId",referencedColumnName = "categoryId")
    private Category category;

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
