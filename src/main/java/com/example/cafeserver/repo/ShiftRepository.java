package com.example.cafeserver.repo;

import com.example.cafeserver.model.Shift;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShiftRepository extends JpaRepository<Shift, Integer> {
    Shift findShiftById(Integer id);
    Shift findShiftByShiftname(String shiftname);
}
