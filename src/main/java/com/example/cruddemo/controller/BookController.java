package com.example.cruddemo.controller;

import com.example.cruddemo.model.Books;
import com.example.cruddemo.service.BookService;
import jdk.jfr.ContentType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@NoArgsConstructor
@AllArgsConstructor
public class BookController {

    private BookService bookService;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<Books> getAllBooks(){
        return bookService.getAllBooks();
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
    public Books getById(@PathVariable("id") Integer Id){
        return bookService.getById(Id);
    }

    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public void saveBook(@RequestBody Books books){
        bookService.save(books);
    }

    @RequestMapping(value = "/books", method = RequestMethod.PUT)
    public void updateBook(@RequestBody Books books){
        bookService.update(books);
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable("id") Integer Id){
        bookService.delete(Id);
    }
}
