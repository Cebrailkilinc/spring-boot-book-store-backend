package com.example.bookStore.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddToCartRequest {
    private UUID id;
    private UUID cartId;
    private  String name;
    private String author;
    private Double price;
}
