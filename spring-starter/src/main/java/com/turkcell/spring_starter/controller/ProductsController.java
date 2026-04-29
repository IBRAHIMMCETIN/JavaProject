package com.turkcell.spring_starter.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.turkcell.spring_starter.dto.CreateProductRequest;
import com.turkcell.spring_starter.dto.CreatedProductResponse;
import com.turkcell.spring_starter.dto.ListProductResponse;
import com.turkcell.spring_starter.service.ProductServiceImpl;

@RestController
@RequestMapping("api/products")
public class ProductsController {
    private final ProductServiceImpl productServiceImpl;

    public ProductsController(ProductServiceImpl productServiceImpl) {
        this.productServiceImpl = productServiceImpl;
    }

    @PostMapping
    public CreatedProductResponse create(@RequestBody CreateProductRequest createProductRequest) {
        return this.productServiceImpl.create(createProductRequest);
    }

    @GetMapping
    public List<ListProductResponse> getAll() {
        return this.productServiceImpl.getAll();
    }

    @GetMapping("/{id}")
    public ListProductResponse getById(@PathVariable UUID id) {
        return this.productServiceImpl.getById(id);
    }

    @PutMapping("/{id}")
    public ListProductResponse update(@PathVariable UUID id, @RequestBody CreateProductRequest updateProductRequest) {
        return this.productServiceImpl.update(id, updateProductRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        this.productServiceImpl.delete(id);
    }
}