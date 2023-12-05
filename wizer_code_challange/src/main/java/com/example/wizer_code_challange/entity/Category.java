package com.example.wizer_code_challange.entity;

import jakarta.persistence.*;
import com.example.wizer_code_challange.entity.Book;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long categoryId;
    private String categoryName;
    @ManyToOne
    @JoinColumn(name = "books_book_id")
    private Book books;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Book>book;
}
