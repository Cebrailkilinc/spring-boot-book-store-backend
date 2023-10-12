package com.example.bookStore.repository;

import com.example.bookStore.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StockRepository extends JpaRepository<Stock, UUID> {

}
