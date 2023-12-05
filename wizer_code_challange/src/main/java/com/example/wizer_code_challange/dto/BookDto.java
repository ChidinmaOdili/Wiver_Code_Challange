package com.example.wizer_code_challange.dto;

import lombok.Data;

@Data
public class BookDto {
    private Long bookId;
    private String title;
    private String author;
    private boolean favorite;
    private Long categoryId;
    private CategoryDto category;
}
