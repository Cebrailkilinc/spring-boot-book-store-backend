package com.example.bookStore.repository;

import com.example.bookStore.model.TransactionHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransactionHistoryRepository extends JpaRepository<TransactionHistory, UUID> {
}
