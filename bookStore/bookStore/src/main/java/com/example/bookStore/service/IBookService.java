package com.example.bookStore.service;

import com.example.bookStore.dto.request.CreateBookRequest;
import com.example.bookStore.dto.request.UpdateBookRequest;
import com.example.bookStore.dto.response.GetAllBookResponse;
import com.example.bookStore.model.Book;
import com.example.bookStore.model.Cart;

import java.util.List;
import java.util.UUID;

public interface IBookService {
    List<GetAllBookResponse> getAll();
    List<Book> getAllTest();
    GetAllBookResponse getById(UUID id);
    void add(CreateBookRequest createBookRequest);
    void delete(UUID id);
    void update(UpdateBookRequest updateBookRequest);
}
