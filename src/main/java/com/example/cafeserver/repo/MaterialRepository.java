package com.example.cafeserver.repo;

import com.example.cafeserver.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MaterialRepository extends JpaRepository<Material, Integer> {
    Material findMaterialByMaterialname(String materialname);
    Material findMaterialById(Integer id_material);
}
