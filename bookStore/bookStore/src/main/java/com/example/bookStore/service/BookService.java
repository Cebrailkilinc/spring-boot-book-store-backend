package com.example.bookStore.service;

import com.example.bookStore.dto.request.CreateBookRequest;
import com.example.bookStore.dto.request.UpdateBookRequest;
import com.example.bookStore.dto.response.GetAllBookResponse;
import com.example.bookStore.model.Book;
import com.example.bookStore.model.Stock;
import com.example.bookStore.repository.BookRepository;
import com.example.bookStore.utilities.exception.BusinessException;
import com.example.bookStore.utilities.mapper.ModelMapperInterface;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookService implements IBookService {
    private final BookRepository bookRepository;
    private final ModelMapperInterface modelMapper;

    public BookService(BookRepository bookRepository, ModelMapperInterface modelMapper) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }

    public List<GetAllBookResponse> getAll() {
        List<Book> books = bookRepository.findAll();
        List<GetAllBookResponse> getAllBookResponses = books.stream()
                .map(book -> this.modelMapper.forResponse().map(book, GetAllBookResponse.class)).toList();
        return getAllBookResponses;
    }

    @Override
    public List<Book> getAllTest() {
        return bookRepository.findAll();
    }

    @Override
    public GetAllBookResponse getById(UUID id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BusinessException("Kitap bulunamadı1..."));
        bookRepository.save(book);
        GetAllBookResponse bookResponse = modelMapper.forResponse().map(book, GetAllBookResponse.class);
        return bookResponse;
    }
    @Override
    public void add(CreateBookRequest request) {
        Book book = this.modelMapper.forRequest().map(request, Book.class);
        this.bookRepository.save(book);
    }
    @Override
    public void delete(UUID id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public void update(UpdateBookRequest request) {
        bookRepository.findById(request.getId())
                .orElseThrow(() -> new BusinessException("Kitap bulunamadı ve güncelleme yapılamadı."));
        Book book = modelMapper.forRequest().map(request, Book.class);
        this.bookRepository.save(book);
    }

    ;
}
