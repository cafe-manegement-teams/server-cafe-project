package com.example.cafeserver.repo;

import com.example.cafeserver.model.Export;
import org.springframework.data.jpa.repository.*;

public interface ExportRepo extends JpaRepository<Export,Integer> {
}
