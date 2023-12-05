package com.example.wizer_code_challange.controller;

import com.example.wizer_code_challange.entity.Book;
import com.example.wizer_code_challange.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/book")
public class BookController {

    private final BookService bookService;



    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book addedBook = bookService.addBook(book);
        return new ResponseEntity<>(addedBook, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<Book> getBookById(@PathVariable Long bookId) {
        Book book = bookService.getBookById(bookId);
        return book != null ? new ResponseEntity<>(book, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{bookId}")
    public ResponseEntity<Book> editBook(@PathVariable Long bookId, @RequestBody Book updatedBook) {
        Book editedBook = bookService.editBook(bookId, updatedBook);
        return editedBook != null ? new ResponseEntity<>(editedBook, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long bookId) {
        boolean deleted = bookService.deleteBook(bookId);
        return deleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{bookId}/favorite")
    public ResponseEntity<Void> markBookAsFavorite(@PathVariable Long bookId) {
        bookService.markBookAsFavorite(bookId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{bookId}/favorite")
    public ResponseEntity<Void> removeBookFromFavorites(@PathVariable Long bookId) {
        bookService.removeBookFromFavorites(bookId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{bookId}/add-to-category/{categoryId}")
    public ResponseEntity<Void> addBookToCategory(@PathVariable Long bookId, @PathVariable Long categoryId) {
        bookService.addBookToCategory(bookId, categoryId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{bookId}/remove-from-category")
    public ResponseEntity<Void> removeBookFromCategory(@PathVariable Long bookId) {
        bookService.removeBookFromCategory(bookId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


