package com.turkcell.kutuphane_hw_spring_starter.service;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

import com.turkcell.kutuphane_hw_spring_starter.Repository.GenreRepository;
import com.turkcell.kutuphane_hw_spring_starter.dto.CreateGenreRequest;
import com.turkcell.kutuphane_hw_spring_starter.dto.ListGenreResponse;
import com.turkcell.kutuphane_hw_spring_starter.entity.Genre;

@Service
public class GenreServiceImpl {
    private final GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public ListGenreResponse create(CreateGenreRequest request) {
        Genre genre = new Genre();
        genre.setName(request.getName());
        
        genre = this.genreRepository.save(genre);
        return mapToResponse(genre);
    }

    public List<ListGenreResponse> getAll() {
        return this.genreRepository.findAll().stream().map(this::mapToResponse).toList();
    }

    public ListGenreResponse getById(UUID id) {
        Genre genre = this.genreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tür bulunamadı"));
        return mapToResponse(genre);
    }

    public ListGenreResponse update(UUID id, CreateGenreRequest request) {
        Genre genre = this.genreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tür bulunamadı"));
        
        genre.setName(request.getName());
        genre = this.genreRepository.save(genre);
        return mapToResponse(genre);
    }

    public void delete(UUID id) {
        this.genreRepository.deleteById(id);
    }

    private ListGenreResponse mapToResponse(Genre genre) {
        ListGenreResponse response = new ListGenreResponse();
        response.setId(genre.getId());
        response.setName(genre.getName());
        return response;
    }
}