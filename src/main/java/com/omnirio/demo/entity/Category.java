package com.omnirio.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long categoryId;
    @Column
    private String categoryName;
    @OneToMany(mappedBy="category",fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    List<CategoryAttribute> categoryAttributeList;


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

    public List<CategoryAttribute> getCategoryAttributeList() {
        return categoryAttributeList;
    }

    public void setCategoryAttributeList(List<CategoryAttribute> categoryAttributeList) {
        this.categoryAttributeList = categoryAttributeList;
    }
}
