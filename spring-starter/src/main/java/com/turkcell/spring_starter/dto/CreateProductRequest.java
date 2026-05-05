package com.turkcell.spring_starter.dto;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class CreateProductRequest {
    
    @NotBlank
    @Length(min = 3, max = 100)
    private String name;

    private String description;

    @NotNull
    private UUID categoryId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UUID getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(UUID categoryId) {
        this.categoryId = categoryId;
    }
}