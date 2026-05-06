package com.turkcell.kutuphane_hw_spring_starter.controller;
import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.*;
import com.turkcell.kutuphane_hw_spring_starter.dto.*;
import com.turkcell.kutuphane_hw_spring_starter.service.AuthorServiceImpl;

@RestController
@RequestMapping("api/authors")
public class AuthorsController {
    private final AuthorServiceImpl authorServiceImpl;

    public AuthorsController(AuthorServiceImpl authorServiceImpl) {
        this.authorServiceImpl = authorServiceImpl;
    }

    @PostMapping
    public ListAuthorResponse create(@RequestBody CreateAuthorRequest request) {
        return this.authorServiceImpl.create(request);
    }

    @GetMapping
    public List<ListAuthorResponse> getAll() {
        return this.authorServiceImpl.getAll();
    }

    @GetMapping("/{id}")
    public ListAuthorResponse getById(@PathVariable UUID id) {
        return this.authorServiceImpl.getById(id);
    }

    @PutMapping("/{id}")
    public ListAuthorResponse update(@PathVariable UUID id, @RequestBody CreateAuthorRequest request) {
        return this.authorServiceImpl.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        this.authorServiceImpl.delete(id);
    }
}