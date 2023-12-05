package com.example.wizer_code_challange.repository;

import com.example.wizer_code_challange.entity.Book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
