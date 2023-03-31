package com.example.cruddemo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CollectionId;

import static jakarta.persistence.GenerationType.TABLE;

@Entity
@Table
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Books {
    @Id
    @Column
    private int id;
    @Column
    private String name;
    @Column
    private String author;
    @Column
    private Double price;



}
