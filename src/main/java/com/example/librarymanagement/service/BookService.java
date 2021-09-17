package com.example.librarymanagement.service;

import com.example.librarymanagement.model.Book;

import java.util.List;

public interface BookService {
    Book saveBook(Book book);
    List<Book> getAllBooks();
    Book getBookById(long id);
    Book updateBook(Book book, long id);
    void deleteBook(long id);
}
