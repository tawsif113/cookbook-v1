package com.example.demo;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PlayerRequestBody {

    @NotNull
    private String name;

    @NotNull
    private Long teamId;
}
