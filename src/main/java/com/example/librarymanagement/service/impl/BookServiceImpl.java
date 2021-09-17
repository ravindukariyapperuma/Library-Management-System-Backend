package com.example.librarymanagement.service.impl;

import com.example.librarymanagement.exception.ResourceNotFoundException;
import com.example.librarymanagement.model.Book;
import com.example.librarymanagement.repository.BookRepository;
import com.example.librarymanagement.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(long id) {
        return bookRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Book", "Id", id));
    }

    @Override
    public Book updateBook(Book book, long id) {
        Book existingBook = bookRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Book", "Id", id)
        );
        existingBook.setBookName(book.getBookName());
        existingBook.setAuthor(book.getAuthor());

        bookRepository.save(existingBook);
        return existingBook;
    }

    @Override
    public void deleteBook(long id) {
        bookRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Book", "Id", id));
        bookRepository.deleteById(id);
    }
}
