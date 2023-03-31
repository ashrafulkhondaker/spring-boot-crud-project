package com.example.cruddemo.service;

import com.example.cruddemo.model.Books;
import org.springframework.context.annotation.Bean;

import java.util.List;


public interface BookService {
    List<Books> getAllBooks();
    Books getById(Integer Id);
    void save(Books books);
    void update(Books books);
    void delete(Integer Id);
}
