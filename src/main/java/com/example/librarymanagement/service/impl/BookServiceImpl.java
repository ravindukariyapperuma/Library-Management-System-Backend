package com.example.librarymanagement.service.impl;

import com.example.librarymanagement.model.Book;
import com.example.librarymanagement.repository.BookRepository;
import com.example.librarymanagement.service.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        super();
        this.bookRepository = bookRepository;
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }
}
