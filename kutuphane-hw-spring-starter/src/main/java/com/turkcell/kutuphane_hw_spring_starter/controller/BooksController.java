package com.turkcell.kutuphane_hw_spring_starter.controller;

import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.*;

import com.turkcell.kutuphane_hw_spring_starter.dto.*;
import com.turkcell.kutuphane_hw_spring_starter.service.BookServiceImpl;

@RestController
@RequestMapping("api/books")
public class BooksController {
    private final BookServiceImpl bookServiceImpl;

    public BooksController(BookServiceImpl bookServiceImpl) {
        this.bookServiceImpl = bookServiceImpl;
    }

    @PostMapping
    public ListBookResponse create(@RequestBody CreateBookRequest request) {
        return this.bookServiceImpl.create(request);
    }

    @GetMapping
    public List<ListBookResponse> getAll() {
        return this.bookServiceImpl.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        this.bookServiceImpl.delete(id);
    }
}