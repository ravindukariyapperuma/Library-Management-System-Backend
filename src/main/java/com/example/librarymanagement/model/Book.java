package com.example.librarymanagement.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "book_name", nullable = false)
    private String bookName;

    @Column(name = "author")
    private String author;
}
