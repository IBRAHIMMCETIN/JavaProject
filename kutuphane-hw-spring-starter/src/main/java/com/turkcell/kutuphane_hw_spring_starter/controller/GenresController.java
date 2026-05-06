package com.turkcell.kutuphane_hw_spring_starter.controller;
import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.*;
import com.turkcell.kutuphane_hw_spring_starter.dto.*;
import com.turkcell.kutuphane_hw_spring_starter.service.GenreServiceImpl;

@RestController
@RequestMapping("api/genres")
public class GenresController {
    private final GenreServiceImpl genreServiceImpl;

    public GenresController(GenreServiceImpl genreServiceImpl) {
        this.genreServiceImpl = genreServiceImpl;
    }

    @PostMapping
    public ListGenreResponse create(@RequestBody CreateGenreRequest request) {
        return this.genreServiceImpl.create(request);
    }

    @GetMapping
    public List<ListGenreResponse> getAll() {
        return this.genreServiceImpl.getAll();
    }

    @GetMapping("/{id}")
    public ListGenreResponse getById(@PathVariable UUID id) {
        return this.genreServiceImpl.getById(id);
    }

    @PutMapping("/{id}")
    public ListGenreResponse update(@PathVariable UUID id, @RequestBody CreateGenreRequest request) {
        return this.genreServiceImpl.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        this.genreServiceImpl.delete(id);
    }
}