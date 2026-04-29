package com.turkcell.spring_starter.service;


import com.turkcell.spring_starter.entity.Category;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.turkcell.spring_starter.Repository.CategoryRepository;
import com.turkcell.spring_starter.dto.CreateCategoryRequest;
import com.turkcell.spring_starter.dto.CreatedCategoryResponse;
import com.turkcell.spring_starter.dto.ListCategoryResponse;

@Service
public class CategoryServiceImpl {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CreatedCategoryResponse create(CreateCategoryRequest createCategoryRequest){
        Category category = new Category();
        category.setName(createCategoryRequest.getName());

        category = this.categoryRepository.save(category);

        CreatedCategoryResponse response = new CreatedCategoryResponse();
        response.setId(category.getId());
        response.setName(category.getName());

        return response;
    }

    public List<ListCategoryResponse> getAll(){
        List<Category> categories = this.categoryRepository.findAll();

        List<ListCategoryResponse> responses = categories.stream().map(category -> {
            ListCategoryResponse response = new ListCategoryResponse();
            response.setId(category.getId());
            response.setName(category.getName());
            return response;
        }).toList();

        return responses;
    }

    public ListCategoryResponse getById(UUID id) {
        Category category = this.categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Kategori bulunamadı"));
        
        ListCategoryResponse response = new ListCategoryResponse();
        response.setId(category.getId());
        response.setName(category.getName());
        return response;
    }

    public ListCategoryResponse update(UUID id, CreateCategoryRequest updateCategoryRequest) {
        Category category = this.categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Kategori bulunamadı"));
        category.setName(updateCategoryRequest.getName());
        
        category = this.categoryRepository.save(category);

        ListCategoryResponse response = new ListCategoryResponse();
        response.setId(category.getId());
        response.setName(category.getName());
        return response;
    }

    public void delete(UUID id) {
        this.categoryRepository.deleteById(id);
    }
}
