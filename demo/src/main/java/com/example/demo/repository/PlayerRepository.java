package com.example.demo.repository;

import com.example.demo.model.Players;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository  extends JpaRepository<Players, Long>{

}
