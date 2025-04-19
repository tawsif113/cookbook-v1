package com.example.demo.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TeamRequestBody {

    @NotBlank
    private String name;

}
