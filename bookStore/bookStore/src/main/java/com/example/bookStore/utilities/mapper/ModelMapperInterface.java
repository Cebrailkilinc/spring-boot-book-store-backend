package com.example.bookStore.utilities.mapper;

import com.example.bookStore.dto.response.GetAllBookResponse;
import com.example.bookStore.model.Book;
import org.modelmapper.ModelMapper;

public interface ModelMapperInterface {
    ModelMapper forResponse();
    ModelMapper forRequest();
}
