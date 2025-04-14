package com.example.demo;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "players")
@Data
public class Players {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "team_id", nullable = false,referencedColumnName = "id")
    private Teams team;

}
