package com.omnirio.demo.repo;

import com.omnirio.demo.entity.CategoryAttribute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryAttributeRepo extends JpaRepository<CategoryAttribute,Integer> {
}
