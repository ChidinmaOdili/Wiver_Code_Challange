package com.example.wizer_code_challange.service;

import com.example.wizer_code_challange.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    Book getBookById(Long bookId);

    Book addBook(Book book);

    Book editBook(Long bookId, Book updatedBook);

    boolean deleteBook(Long bookId);

    void markBookAsFavorite(Long bookId);

    void removeBookFromFavorites(Long bookId);

    void addBookToCategory(Long bookId, Long categoryId);

    void removeBookFromCategory(Long bookId);

    List<Book> getBooksInCategory(Long categoryId);
}
