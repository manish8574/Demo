package com.omnirio.demo.service;

import com.omnirio.demo.dto.CategoryDTO;
import com.omnirio.demo.dto.CategoryAttributeDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    public CategoryDTO createCategory(CategoryDTO category);
    public List<CategoryAttributeDTO> getCategoryAttributes(Long id);
    public CategoryDTO addCategoryAttributes(CategoryDTO categoryDTO);
}
