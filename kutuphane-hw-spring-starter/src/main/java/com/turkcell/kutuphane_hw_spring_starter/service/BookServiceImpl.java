package com.turkcell.kutuphane_hw_spring_starter.service;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

import com.turkcell.kutuphane_hw_spring_starter.Repository.BookRepository;
import com.turkcell.kutuphane_hw_spring_starter.Repository.GenreRepository;
import com.turkcell.kutuphane_hw_spring_starter.Repository.AuthorRepository;
import com.turkcell.kutuphane_hw_spring_starter.dto.*;
import com.turkcell.kutuphane_hw_spring_starter.entity.*;

@Service
public class BookServiceImpl {
    private final BookRepository bookRepository;
    private final GenreRepository genreRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, GenreRepository genreRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.genreRepository = genreRepository;
        this.authorRepository = authorRepository;
    }

    public ListBookResponse create(CreateBookRequest request) {
        Genre genre = this.genreRepository.findById(request.getGenreId())
                .orElseThrow(() -> new RuntimeException("Tür bulunamadı"));
        Author author = this.authorRepository.findById(request.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Yazar bulunamadı"));

        Book book = new Book();
        book.setIsbn(request.getIsbn());
        book.setName(request.getName());
        book.setPublicationYear(request.getPublicationYear());
        book.setGenre(genre);
        book.setAuthor(author);

        book = this.bookRepository.save(book);
        return mapToResponse(book);
    }

    public List<ListBookResponse> getAll() {
        return this.bookRepository.findAll().stream().map(this::mapToResponse).toList();
    }

    public void delete(UUID id) {
        this.bookRepository.deleteById(id);
    }

    private ListBookResponse mapToResponse(Book book) {
        ListBookResponse response = new ListBookResponse();
        response.setId(book.getId());
        response.setIsbn(book.getIsbn());
        response.setName(book.getName());
        response.setPublicationYear(book.getPublicationYear());
        response.setGenreName(book.getGenre().getName());
        response.setAuthorName(book.getAuthor().getFirstName() + " " + book.getAuthor().getLastName());
        return response;
    }
}