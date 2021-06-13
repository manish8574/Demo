package com.omnirio.demo.service.impl;

import com.omnirio.demo.dto.CategoryAttributeDTO;
import com.omnirio.demo.dto.ProductDTO;
import com.omnirio.demo.entity.Category;
import com.omnirio.demo.entity.CategoryAttribute;
import com.omnirio.demo.entity.Product;
import com.omnirio.demo.repo.ProductRepo;
import com.omnirio.demo.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepo productRepo;

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product=new Product();
        BeanUtils.copyProperties(productDTO,product);
        product.setProductId(UUID.randomUUID().toString());
        Category category= new Category();
        category.setCategoryId(productDTO.getCategoryId());
         product.setCategory(category);
        product=productRepo.save(product);
        BeanUtils.copyProperties(product,productDTO);
        return productDTO;
    }

    @Override
    public ProductDTO getProductById(String id) {
        Product product= productRepo.findById(id).get();

        ProductDTO productDTO= new ProductDTO();
        BeanUtils.copyProperties(product,productDTO);
        productDTO.setCategoryId(product.getCategory().getCategoryId());
        productDTO.setCategoryName(product.getCategory().getCategoryName());
        List<CategoryAttributeDTO> categoryAttributeDTOS= new ArrayList<>();
        for(CategoryAttribute attribute:product.getCategory().getCategoryAttributeList()){
            CategoryAttributeDTO categoryAttributeDTO=new CategoryAttributeDTO();
            BeanUtils.copyProperties(attribute,categoryAttributeDTO);
            categoryAttributeDTOS.add(categoryAttributeDTO);
        }
        productDTO.setCategoryAttributes(categoryAttributeDTOS);
        return productDTO;
    }
}
