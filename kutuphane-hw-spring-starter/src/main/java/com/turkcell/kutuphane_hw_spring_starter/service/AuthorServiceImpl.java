package com.turkcell.kutuphane_hw_spring_starter.service;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

import com.turkcell.kutuphane_hw_spring_starter.Repository.AuthorRepository;
import com.turkcell.kutuphane_hw_spring_starter.dto.CreateAuthorRequest;
import com.turkcell.kutuphane_hw_spring_starter.dto.ListAuthorResponse;
import com.turkcell.kutuphane_hw_spring_starter.entity.Author;

@Service
public class AuthorServiceImpl {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public ListAuthorResponse create(CreateAuthorRequest request) {
        Author author = new Author();
        author.setFirstName(request.getFirstName());
        author.setLastName(request.getLastName());
        
        author = this.authorRepository.save(author);
        return mapToResponse(author);
    }

    public List<ListAuthorResponse> getAll() {
        return this.authorRepository.findAll().stream().map(this::mapToResponse).toList();
    }

    public ListAuthorResponse getById(UUID id) {
        Author author = this.authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Yazar bulunamadı"));
        return mapToResponse(author);
    }

    public ListAuthorResponse update(UUID id, CreateAuthorRequest request) {
        Author author = this.authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Yazar bulunamadı"));
        
        author.setFirstName(request.getFirstName());
        author.setLastName(request.getLastName());
        
        author = this.authorRepository.save(author);
        return mapToResponse(author);
    }

    public void delete(UUID id) {
        this.authorRepository.deleteById(id);
    }

    private ListAuthorResponse mapToResponse(Author author) {
        ListAuthorResponse response = new ListAuthorResponse();
        response.setId(author.getId());
        response.setFirstName(author.getFirstName());
        response.setLastName(author.getLastName());
        return response;
    }
}