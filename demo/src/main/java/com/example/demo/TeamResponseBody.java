package com.example.demo;


import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TeamResponseBody {


    private Long id;

    @NotNull
    private String name;

}
