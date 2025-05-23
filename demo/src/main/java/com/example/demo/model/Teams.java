package com.example.demo.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "teams")
@Data
public class Teams {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

}
