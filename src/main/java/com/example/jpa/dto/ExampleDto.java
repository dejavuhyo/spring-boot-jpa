package com.example.jpa.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class ExampleDto {
    private String id;
    private String name;
    private String email;
}
