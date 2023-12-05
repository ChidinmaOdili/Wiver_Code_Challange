package com.example.wizer_code_challange.serviveImpl;

import com.example.wizer_code_challange.entity.Book;
import com.example.wizer_code_challange.entity.Category;
import com.example.wizer_code_challange.repository.BookRepository;
import com.example.wizer_code_challange.repository.CategoryRepository;
import com.example.wizer_code_challange.service.BookService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long bookId) {
        return bookRepository.findById(bookId).orElse(null);
    }

    @Override
    @Transactional
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    @Transactional
    public Book editBook(Long bookId, Book updatedBook) {
        Book existingBook = bookRepository.findById(bookId).orElse(null);

        if (existingBook != null) {
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setFavorite(updatedBook.isFavorite());

            return bookRepository.save(existingBook);
        }

        return null;
    }

    @Override
    @Transactional
    public boolean deleteBook(Long bookId) {
        Book bookToDelete = bookRepository.findById(bookId).orElse(null);

        if (bookToDelete != null) {
            bookRepository.delete(bookToDelete);
            return true;
        }

        return false;
    }

    @Override
    @Transactional
    public void markBookAsFavorite(Long bookId) {
        Book book = bookRepository.findById(bookId).orElse(null);

        if (book != null) {
            book.setFavorite(true);
            bookRepository.save(book);
        }
    }

    @Override
    @Transactional
    public void removeBookFromFavorites(Long bookId) {
        Book book = bookRepository.findById(bookId).orElse(null);

        if (book != null) {
            book.setFavorite(false);
            bookRepository.save(book);
        }
    }

    @Override
    @Transactional
    public void addBookToCategory(Long bookId, Long categoryId) {
        Book book = bookRepository.findById(bookId).orElse(null);
        Category category = categoryRepository.findById(categoryId).orElse(null);

        if (book != null && category != null) {
            book.setCategory(category);
            bookRepository.save(book);
        }
    }

    @Override
    @Transactional
    public void removeBookFromCategory(Long bookId) {
        Book book = bookRepository.findById(bookId).orElse(null);

        if (book != null) {
            book.setCategory(null);
            bookRepository.save(book);
        }
    }

    @Override
    public List<Book> getBooksInCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElse(null);

        if (category != null) {
            return (List<Book>) category.getBooks();
        }

        return List.of();
    }
}

