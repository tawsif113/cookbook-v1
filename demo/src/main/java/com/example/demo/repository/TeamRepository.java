package com.example.demo.repository;

import com.example.demo.model.Teams;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Teams, Long> {
    Teams findByName(String name);
}
