package com.example.jpa.service;

import com.example.jpa.dto.ExampleDto;

import java.util.List;

public interface ExampleService {
    List<ExampleDto> findAll();

    ExampleDto findById(String id);

    ExampleDto save(ExampleDto exampleDto);

    ExampleDto put(ExampleDto exampleDto);

    void deleteById(String id);
}
