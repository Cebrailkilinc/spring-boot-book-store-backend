package com.example.bookStore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class TransactionHistory {
    @Id
    private UUID id;
    @Column
    private int productId;
    @Column
    private String productName;
    @Column
    private String authorName;
    @Column
    private Double productPrice = 0.0;
    @Column
    private int quantity;
    @Column
    private final Double totalPrice = quantity*productPrice;
}