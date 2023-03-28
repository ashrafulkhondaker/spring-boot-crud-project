package com.example.cruddemo.service;

import com.example.cruddemo.model.Books;

import java.util.List;

public interface BookService {
    public List<Books> getAllBooks();
    public Books getById(Integer Id);
    public void save(Books books);
    public void update(Books books);
    public void delete(Integer Id);
}
