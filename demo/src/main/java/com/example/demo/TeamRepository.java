package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Teams, Long> {
    Teams findByName(String name);
}
