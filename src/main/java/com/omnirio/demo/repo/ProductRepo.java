package com.omnirio.demo.repo;

import com.omnirio.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepo extends JpaRepository<Product,String> {
}
