package com.omnirio.demo.service;

import com.omnirio.demo.dto.ProductDTO;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    public ProductDTO createProduct(ProductDTO productDTO);
    public ProductDTO getProductById(String id);

}
