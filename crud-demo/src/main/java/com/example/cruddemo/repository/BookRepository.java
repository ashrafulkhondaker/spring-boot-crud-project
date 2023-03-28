package com.example.cruddemo.repository;

import com.example.cruddemo.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends JpaRepository<Books, Integer> {

}
