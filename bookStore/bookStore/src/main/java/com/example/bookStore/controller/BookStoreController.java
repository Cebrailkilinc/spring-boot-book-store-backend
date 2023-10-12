package com.example.bookStore.controller;

import com.example.bookStore.dto.request.CreateBookRequest;
import com.example.bookStore.dto.request.UpdateBookRequest;
import com.example.bookStore.dto.response.GetAllBookResponse;
import com.example.bookStore.model.Book;
import com.example.bookStore.service.BookService;
import com.example.bookStore.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/book")
public class BookStoreController {
    @Autowired
    private IBookService bookService;

    @GetMapping("/all")
    public List<GetAllBookResponse> hello(){
        return bookService.getAll();
    }
    @GetMapping("/allTest")
    public List<Book> getAllTest(){
        return bookService.getAllTest();
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody CreateBookRequest request){
        this.bookService.add(request);
    }

    @GetMapping("/{id}")
    public GetAllBookResponse getById(@PathVariable UUID id){
        return bookService.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable UUID id){
        this.bookService.delete(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody UpdateBookRequest updateBookRequest){
        this.bookService.update(updateBookRequest);
    }
}
