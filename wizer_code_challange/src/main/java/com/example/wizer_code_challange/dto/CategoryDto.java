package com.example.wizer_code_challange.dto;

import lombok.Data;

import java.util.List;

@Data
public class CategoryDto {
    private Long categoryId;
    private String categoryName;
    private BookDto books;
    private List<BookDto> book;

}
