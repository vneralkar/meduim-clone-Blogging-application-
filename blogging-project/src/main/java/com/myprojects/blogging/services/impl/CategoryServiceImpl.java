package com.myprojects.blogging.services.impl;

import com.myprojects.blogging.entities.Category;
import com.myprojects.blogging.exceptions.ResourceNotFoundException;
import com.myprojects.blogging.payloads.CategoryDto;
import com.myprojects.blogging.repositories.CategoryRepo;
import com.myprojects.blogging.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryrepo;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {

        Category cat = this.dtoToCategory(categoryDto);
        Category createdcat = this.categoryrepo.save(cat);
        return this.categoryToDto(createdcat);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
        Category cat = this.categoryrepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category" ,"CategoryId",categoryId));

        cat.setCategoryId(categoryDto.getCategoryId());
        cat.setCategoryTitle(categoryDto.getCategoryTitle());
        cat.setCategoryDescription(categoryDto.getCategoryDescription());

        return this.categoryToDto(cat);
    }


    @Override
    public void deleteCategory(Integer categoryId) {
        Category cat = this.categoryrepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category" ,"CategoryId",categoryId));
        this.categoryrepo.delete(cat);

    }

    @Override
    public CategoryDto getCategoryById(Integer categoryId) {
        Category cat = this.categoryrepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category" ,"CategoryId",categoryId));
        return this.categoryToDto(cat);
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        List<Category> listcat = this.categoryrepo.findAll();
        List<CategoryDto> catdto = listcat.stream().map(cat->this.categoryToDto(cat)).collect(Collectors.toList());

        return catdto;
    }


    private CategoryDto categoryToDto(Category createdcat) {
        CategoryDto dto = new CategoryDto();
        dto.setCategoryId(createdcat.getCategoryId());
        dto.setCategoryTitle(createdcat.getCategoryTitle());
        dto.setCategoryDescription(createdcat.getCategoryDescription());

        return dto;
    }

    private Category dtoToCategory(CategoryDto categoryDto) {
        Category cat = new Category();
        cat.setCategoryId(categoryDto.getCategoryId());
        cat.setCategoryTitle(categoryDto.getCategoryTitle());
        cat.setCategoryDescription(categoryDto.getCategoryDescription());

        return cat;
    }
}
