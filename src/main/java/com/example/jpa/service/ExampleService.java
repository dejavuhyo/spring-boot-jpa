package com.example.jpa.service;

import com.example.jpa.model.Example;

import java.util.List;
import java.util.Optional;

public interface ExampleService {
    List<Example> findAll();

    Optional<Example> findById(String id);

    void save(Example demo);

    void put(Example demo);

    void deleteById(String id);
}
