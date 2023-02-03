package com.example.jpa.service.impl;

import com.example.jpa.entity.Example;
import com.example.jpa.repository.ExampleRepository;
import com.example.jpa.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExampleServiceImpl implements ExampleService {
    @Autowired
    private ExampleRepository exampleRepository;

    @Override
    public List<Example> findAll() {
        return exampleRepository.findAll();
    }

    @Override
    public Optional<Example> findById(String id) {
        return exampleRepository.findById(id);
    }

    @Override
    public void save(Example example) {
        exampleRepository.save(example);
    }

    @Override
    public void put(Example example) {
        exampleRepository.save(example);
    }

    @Override
    public void deleteById(String id) {
        exampleRepository.deleteById(id);
    }
}
