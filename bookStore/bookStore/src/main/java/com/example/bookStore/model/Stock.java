package com.example.bookStore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class Stock {
    @Id
    private UUID id;
    @Column
    private int productId;
    @Column
    private int quantity = 0;
    @Column
    private boolean inStock;
}
