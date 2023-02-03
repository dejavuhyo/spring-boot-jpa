package com.example.jpa.controller;

import com.example.jpa.dto.ExampleDto;
import com.example.jpa.entity.Example;
import com.example.jpa.service.ExampleService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping(path = "/jpa")
public class ExampleController {
    @Autowired
    ExampleService exampleService;
    @Autowired
    ModelMapper modelMapper;

    /**
     * 전체 조회
     *
     * @return
     */
    @GetMapping("/")
    @ResponseBody
    public List<ExampleDto> findAll() {
        List<Example> result = exampleService.findAll();
        return result.stream()
                .map(this::convertListToDto)
                .collect(Collectors.toList());
    }

    /**
     * id 조회
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ResponseBody
    public ExampleDto findById(@PathVariable("id") String id) {
        return convertToDto(exampleService.findById(id));
    }

    /**
     * 저장
     *
     * @param exampleDto
     */
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public void save(@RequestBody ExampleDto exampleDto) {
        exampleService.save(convertToEntity(exampleDto));
    }

    /**
     * 수정
     *
     * @param exampleDto
     */
    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void put(@PathVariable("id") String id, @RequestBody ExampleDto exampleDto) {
        exampleDto.setId(id);
        exampleService.put(convertToEntity(exampleDto));
    }

    /**
     * 삭제
     *
     * @param id
     */
    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable("id") String id) {
        exampleService.deleteById(id);
    }

    /**
     * entity to dto
     *
     * @param example
     * @return
     */
    private ExampleDto convertToDto(Optional<Example> example) {
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
     * @param demoDto
     * @return
     */
    private Example convertToEntity(ExampleDto demoDto) {
        return modelMapper.map(demoDto, Example.class);
    }
}
