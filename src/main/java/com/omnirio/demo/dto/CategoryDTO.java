package com.omnirio.demo.dto;

import java.util.List;

public class CategoryDTO {
    private Long categoryId;
    private String categoryName;
    private List<CategoryAttributeDTO> categoryAttributeDTOS;

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
