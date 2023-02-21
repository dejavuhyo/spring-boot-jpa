package com.example.jpa.service.impl;

import com.example.jpa.dto.ExampleDto;
import com.example.jpa.entity.Example;
import com.example.jpa.repository.ExampleRepository;
import com.example.jpa.service.ExampleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExampleServiceImpl implements ExampleService {
    @Autowired
    private ExampleRepository exampleRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ExampleDto> findAll() {
        List<Example> findAll = exampleRepository.findAll();
        return findAll.stream()
                .map(this::convertListToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ExampleDto findById(String id) {
        Optional<Example> findById = exampleRepository.findById(id);
        if (findById.isPresent()) {
            return convertToDto(findById);
        } else {
            return null;
        }
    }

    @Override
    public ExampleDto save(ExampleDto exampleDto) {
        Example example = exampleRepository.save(convertToEntity(exampleDto));
        return convertToDto(example);
    }

    @Override
    public ExampleDto put(ExampleDto exampleDto) {
        Example example = exampleRepository.save(convertToEntity(exampleDto));
        return convertToDto(example);
    }

    @Override
    public void deleteById(String id) {
        exampleRepository.deleteById(id);
    }

    /**
     * optional entity to dto
     *
     * @param example
     * @return
     */
    private ExampleDto convertToDto(Optional<Example> example) {
        return modelMapper.map(example, ExampleDto.class);
    }

    /**
     * entity to dto
     *
     * @param example
     * @return
     */
    private ExampleDto convertToDto(Example example) {
        return modelMapper.map(example, ExampleDto.class);
    }

    /**
     * entity list to dto
     *
     * @param example
     * @return
     */
    private ExampleDto convertListToDto(Example example) {
        return modelMapper.map(example, ExampleDto.class);
    }

    /**
     * dto to entity
     *
     * @param exampleDto
     * @return
     */
    private Example convertToEntity(ExampleDto exampleDto) {
        return modelMapper.map(exampleDto, Example.class);
    }
}
