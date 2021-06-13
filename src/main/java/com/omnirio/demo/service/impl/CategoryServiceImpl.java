package com.omnirio.demo.service.impl;

import com.omnirio.demo.dto.CategoryDTO;
import com.omnirio.demo.dto.CategoryAttributeDTO;
import com.omnirio.demo.entity.Category;
import com.omnirio.demo.entity.CategoryAttribute;
import com.omnirio.demo.repo.CategoryAttributeRepo;
import com.omnirio.demo.repo.CategoryRepo;
import com.omnirio.demo.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepo categoryRepo;
    @Autowired
    CategoryAttributeRepo categoryAttributeRepo;

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category=new Category();
        BeanUtils.copyProperties(categoryDTO,category);


        //categoryRepo.save(category);
       Category category1= categoryRepo.saveAndFlush(category);
        if(categoryDTO.getCategoryAttributes().size()>0) {
            List<CategoryAttribute>categoryAttributes= new ArrayList<>();
            categoryDTO.getCategoryAttributes().forEach((attr) -> {

                CategoryAttribute categoryAttribute = new CategoryAttribute();
                BeanUtils.copyProperties(attr, categoryAttribute);
                categoryAttribute.setCategory(category1);
                categoryAttributes.add(categoryAttribute);
            });
            categoryAttributeRepo.saveAll(categoryAttributes);
        }
        BeanUtils.copyProperties(category1,categoryDTO);
        return categoryDTO;
    }

    @Override
    public List<CategoryAttributeDTO> getCategoryAttributes(Long id) {
        Category category= categoryRepo.findById(id).get();
        List<CategoryAttributeDTO>categoryAttributeDTOS=new ArrayList<>();
        category.getCategoryAttributeList().forEach(
                (atribute)->{
                    CategoryAttributeDTO attributeDTO=new CategoryAttributeDTO();
                    BeanUtils.copyProperties(atribute,attributeDTO);
                    categoryAttributeDTOS.add(attributeDTO);
                }
        );
        return categoryAttributeDTOS;
    }

    public CategoryDTO addCategoryAttributes(CategoryDTO categoryDTO) {
        Category category=new Category();
        List<CategoryAttribute>categoryAttributes= new ArrayList<>();
        category.setCategoryId(categoryDTO.getCategoryId());
        categoryDTO.getCategoryAttributes().forEach((attribute)->{
            CategoryAttribute categoryAttribute= new CategoryAttribute();
            BeanUtils.copyProperties(attribute,categoryAttribute);
            categoryAttribute.setCategory(category);
            categoryAttributes.add(categoryAttribute);
        });
        categoryAttributeRepo.saveAll(categoryAttributes);
        return categoryDTO;
    }


}
