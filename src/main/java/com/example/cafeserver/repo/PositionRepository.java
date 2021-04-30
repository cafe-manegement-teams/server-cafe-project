package com.example.cafeserver.repo;

import com.example.cafeserver.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Integer> {
    Position findPositionById(Integer id);
    Position findPositionByPoname(String poname);
}
