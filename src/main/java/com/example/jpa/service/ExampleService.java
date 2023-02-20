package com.example.jpa.service;

import com.example.jpa.entity.Example;

import java.util.List;
import java.util.Optional;

public interface ExampleService {
    List<Example> findAll();

    Optional<Example> findById(String id);

    void save(Example example);

    void put(Example example);

    void deleteById(String id);
}
