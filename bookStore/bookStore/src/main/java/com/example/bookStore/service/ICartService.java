package com.example.bookStore.service;

import com.example.bookStore.dto.request.AddToCartRequest;
import com.example.bookStore.dto.response.GetAllBookResponse;
import com.example.bookStore.model.Book;
import com.example.bookStore.model.Cart;

import java.util.List;
import java.util.UUID;

public interface ICartService {
    List<Cart> getAllTest();
    void addBookToCart(Book book);

    void removeBookFromCart(Book book);
}
