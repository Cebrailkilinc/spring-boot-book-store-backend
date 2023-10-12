package com.example.bookStore.repository;

import com.example.bookStore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {

}
