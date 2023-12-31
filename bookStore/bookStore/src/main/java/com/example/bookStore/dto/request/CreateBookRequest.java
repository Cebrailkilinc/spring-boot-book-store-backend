package com.example.bookStore.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookRequest {
    private  String name;
    private String author;
    private Double price;
    private int quantity = 0;
    private boolean isInStock;
}
