package com.omnirio.demo.controller;

import com.omnirio.demo.dto.CategoryAttributeDTO;
import com.omnirio.demo.dto.CategoryDTO;
import com.omnirio.demo.entity.Category;
import com.omnirio.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @PostMapping(value = "/create")
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO category){
        category= categoryService.createCategory(category);
        return ResponseEntity.created(URI.create(""+category.getCategoryId())).body(category);
    }
    @GetMapping(value = "getCategoryAttribute/{id}")
    public ResponseEntity<List<CategoryAttributeDTO>>getCategoryAttribute(@PathVariable("id") Long categoryId){
        List<CategoryAttributeDTO>categoryAttributeDTOS=categoryService.getCategoryAttributes(categoryId);
        return ResponseEntity.ok(categoryAttributeDTOS);
    }
    @PostMapping(value = "/addAttribute")
    public ResponseEntity<CategoryDTO> addAttribute(@RequestBody CategoryDTO category){
        category= categoryService.addCategoryAttributes(category);
        return ResponseEntity.created(URI.create(""+category.getCategoryId())).body(category);
    }
}
