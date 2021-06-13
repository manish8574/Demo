package com.omnirio.demo.controller;

import com.omnirio.demo.dto.CategoryAttributeDTO;
import com.omnirio.demo.dto.CategoryDTO;
import com.omnirio.demo.dto.ProductDTO;
import com.omnirio.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @PostMapping(value = "/create")
    public ResponseEntity<ProductDTO> createCategory(@RequestBody ProductDTO product){
        product= productService.createProduct(product);
        return ResponseEntity.created(URI.create(product.getProductId())).body(product);
    }
    @GetMapping(value = "getProduct/{id}")
    public ResponseEntity<ProductDTO>getCategoryAttribute(@PathVariable("id") String productId){
        ProductDTO productDTO=productService.getProductById(productId);
        return ResponseEntity.ok(productDTO);
    }
}
