package com.turkcell.kutuphane_hw_spring_starter.entity;

import java.util.UUID;
import org.hibernate.annotations.UuidGenerator;
import jakarta.persistence.*;

@Entity
@Table(name = "kitaplar")
public class Book {
    @Id
    @UuidGenerator
    @Column(name="kitap_id")
    private UUID id;

    @Column(name="isbn", unique = true)
    private String isbn;

    @Column(name="kitap_adi", nullable = false)
    private String name;

    @Column(name="yayin_yili")
    private Integer publicationYear;

    @ManyToOne
    @JoinColumn(name = "tur_id", nullable = false)
    private Genre genre;

    @ManyToOne
    @JoinColumn(name = "yazar_id", nullable = false)
    private Author author;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

}