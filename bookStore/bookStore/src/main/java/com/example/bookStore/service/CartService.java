package com.example.bookStore.service;

import com.example.bookStore.model.Book;
import com.example.bookStore.model.Cart;
import com.example.bookStore.model.Customer;
import com.example.bookStore.repository.*;
import com.example.bookStore.utilities.exception.BusinessException;
import com.example.bookStore.utilities.mapper.ModelMapperInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService implements ICartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private ModelMapperInterface modelMapper;
    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private TransactionHistoryRepository transactionHistoryRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Cart> getAllTest() {
        return cartRepository.findAll();
    }

    @Override
    public void addBookToCart(Book book) {
        Customer customer = this.customerRepository.findById(1).orElse(null);
        if (customer == null) {
            throw new BusinessException("Customer is not found!");
        }
        Cart cart = this.cartRepository.findByCustomerId(customer.getId());
        if (cart == null) {
            throw new BusinessException("cart not found");
        }
        if (cart.getBooks() == null) {
            List<Book> books = new ArrayList<>();
            cart.setBooks(books);
        }
        List<Book> cartBooks = cart.getBooks();
        cartBooks.add(book);
        cart.setBooks(cartBooks);
        cartRepository.save(cart);
    }

    @Override
    public void removeBookFromCart(Book book) {
        Customer customer = this.customerRepository.findById(1).orElse(null);
        if (customer == null) {
            throw new BusinessException("Customer is not found!");
        }

        Cart cart = this.cartRepository.findByCustomerId(customer.getId());
        if (cart == null) {
            throw new BusinessException("cart not found");
        }
        if (cart.getBooks() == null || cart.getBooks().get(0) == null) {
            throw new BusinessException("There is not a book for removing from list");
        }
        List<Book> cartBooks = cart.getBooks();
        cartBooks.stream().map(item -> {
            if(item.getId() == book.getId()){
                cartBooks.remove(item);
            }
            return cartBooks;
        });
        cart.setBooks(cartBooks);
        this.cartRepository.save(cart);
    }


}
