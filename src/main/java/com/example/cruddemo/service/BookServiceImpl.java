package com.example.cruddemo.service;

import com.example.cruddemo.model.Books;
import com.example.cruddemo.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;
    @Override
    public List<Books> getAllBooks(){
        List <Books> allBooks = new ArrayList<Books>();
        bookRepository.findAll().forEach(b -> allBooks.add(b));
        return allBooks;
    }
    @Override
    public Books getById(Integer Id){
        return bookRepository.findById(Id).get();
    }
    @Override
    public void save(Books books){
        bookRepository.save(books);
    }
    @Override
    public void update(Books books){
        bookRepository.save(books);
    }

    @Override
    public void delete(Integer Id){
        bookRepository.deleteById(Id);
    }

}
