package com.example.demo;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PlayerResponseBody {

    private Long id;
    private String name;
    private String teamName;
}
