package com.example.bookStore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Table(name = "Books")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true)
    private UUID id;
    @Column(name = "name")
    private  String name;
    @Column(name = "author")
    private String author;
    @Column(name = "price")
    private Double price;

    @ManyToOne
    @JoinColumn(name="cart_id", nullable=false)
    private Cart cart;
}
