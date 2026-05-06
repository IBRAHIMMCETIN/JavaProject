package com.turkcell.kutuphane_hw_spring_starter.dto;
import java.util.UUID;
public class CreateBookRequest {
    private String isbn;
    private String name;
    private Integer publicationYear;
    private UUID genreId;
    private UUID authorId;
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getPublicationYear() {
        return publicationYear;
    }
    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }
    public UUID getGenreId() {
        return genreId;
    }
    public void setGenreId(UUID genreId) {
        this.genreId = genreId;
    }
    public UUID getAuthorId() {
        return authorId;
    }
    public void setAuthorId(UUID authorId) {
        this.authorId = authorId;
    }
}