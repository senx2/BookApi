package com.song.app.rest.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long isbn;
    private String title;
    private int year;
    private double price;
    private String genre;

    //@OneToMany(targetEntity = Author.class, cascade = CascadeType.ALL)
    //@JoinColumn(name = "ba_fk", referencedColumnName = "isbn")
    @ElementCollection
    @CollectionTable(name="book_authors", joinColumns = @JoinColumn(name = "isbn"))
    private List<Author> authors;

}

