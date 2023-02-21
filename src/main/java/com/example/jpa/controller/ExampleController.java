package com.example.jpa.controller;

import com.example.jpa.dto.ExampleDto;
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
        return exampleService.findAll();
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
        return exampleService.findById(id);
    }

    /**
     * 저장
     *
     * @param exampleDto
     */
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ExampleDto save(@RequestBody ExampleDto exampleDto) {
        return exampleService.save(exampleDto);
    }

    /**
     * 수정
     *
     * @param exampleDto
     */
    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ExampleDto put(@PathVariable("id") String id, @RequestBody ExampleDto exampleDto) {
        exampleDto.setId(id);
        return exampleService.put(exampleDto);
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
}
