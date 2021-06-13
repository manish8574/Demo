package com.omnirio.demo.dto;


import java.util.List;

public class ProductDTO {
    private String productId;

    private String productName;

    private Long categoryId;
    private String categoryName;
    private List<CategoryAttributeDTO> categoryAttributeDTOS;

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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<CategoryAttributeDTO> getCategoryAttributes() {
        return categoryAttributeDTOS;
    }

    public void setCategoryAttributes(List<CategoryAttributeDTO> categoryAttributeDTOS) {
        this.categoryAttributeDTOS = categoryAttributeDTOS;
    }
}
