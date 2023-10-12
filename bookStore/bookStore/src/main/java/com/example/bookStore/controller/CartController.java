package com.example.bookStore.controller;

import com.example.bookStore.dto.request.CreateBookRequest;
import com.example.bookStore.model.Book;
import com.example.bookStore.model.Cart;
import com.example.bookStore.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    private ICartService cartService;

    @GetMapping("/all")
    public List<Cart> getAll(){
      return cartService.getAllTest();
    };

    @PostMapping("/addBook")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody Book book){
        this.cartService.addBookToCart(book);
    }
    @PostMapping("/removeBook")
    @ResponseStatus(code = HttpStatus.OK)
    public void removeFromCart(Book book){
        this.cartService.removeBookFromCart(book);
    }
}
