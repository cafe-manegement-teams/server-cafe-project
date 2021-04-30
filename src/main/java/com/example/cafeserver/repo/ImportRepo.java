package com.example.cafeserver.repo;

import org.springframework.data.jpa.repository.*;
import com.example.cafeserver.model.Import;


public interface ImportRepo extends JpaRepository<Import, Integer> {
}
