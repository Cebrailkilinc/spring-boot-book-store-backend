package com.example.bookStore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Table(name = "Carts")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @OneToMany(mappedBy="cart")
    private List<Book> books;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private  Customer customer;

}
