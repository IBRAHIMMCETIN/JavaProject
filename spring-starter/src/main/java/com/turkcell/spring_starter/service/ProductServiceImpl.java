package com.turkcell.spring_starter.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.turkcell.spring_starter.Repository.CategoryRepository;
import com.turkcell.spring_starter.Repository.ProductRepository;
import com.turkcell.spring_starter.dto.CreateProductRequest;
import com.turkcell.spring_starter.dto.CreatedProductResponse;
import com.turkcell.spring_starter.dto.ListProductResponse;
import com.turkcell.spring_starter.entity.Category;
import com.turkcell.spring_starter.entity.Product;

@Service
public class ProductServiceImpl {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public CreatedProductResponse create(CreateProductRequest createProductRequest) {
        Category category = this.categoryRepository.findById(createProductRequest.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Kategori bulunamadı"));

        Product product = new Product();
        product.setName(createProductRequest.getName());
        product.setDescription(createProductRequest.getDescription());
        product.setCategory(category);

        product = this.productRepository.save(product);

        CreatedProductResponse response = new CreatedProductResponse();
        response.setId(product.getId());
        response.setName(product.getName());
        return response;
    }

    public List<ListProductResponse> getAll() {
        List<Product> products = this.productRepository.findAll();

        List<ListProductResponse> responses = products.stream().map(product -> {
            ListProductResponse response = new ListProductResponse();
            response.setId(product.getId());
            response.setName(product.getName());
            return response;
        }).toList();

        return responses;
    }

    public ListProductResponse getById(UUID id) {
        Product product = this.productRepository.findById(id).orElseThrow(() -> new RuntimeException("Ürün bulunamadı"));
        
        ListProductResponse response = new ListProductResponse();
        response.setId(product.getId());
        response.setName(product.getName());
        return response;
    }

    public ListProductResponse update(UUID id, CreateProductRequest updateProductRequest) {
        Product product = this.productRepository.findById(id).orElseThrow(() -> new RuntimeException("Ürün bulunamadı"));
        Category category = this.categoryRepository.findById(updateProductRequest.getCategoryId()).orElseThrow(() -> new RuntimeException("Kategori bulunamadı"));

        product.setName(updateProductRequest.getName());
        product.setDescription(updateProductRequest.getDescription());
        product.setCategory(category);
        
        product = this.productRepository.save(product);

        ListProductResponse response = new ListProductResponse();
        response.setId(product.getId());
        response.setName(product.getName());
        return response;
    }

    public void delete(UUID id) {
        this.productRepository.deleteById(id);
    }
}