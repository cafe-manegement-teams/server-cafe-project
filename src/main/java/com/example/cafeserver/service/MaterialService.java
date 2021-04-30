package com.example.cafeserver.service;
import com.example.cafeserver.model.*;
import com.example.cafeserver.repo.MaterialRepository;
import com.example.cafeserver.repo.ReceiptRepo;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import java.util.*;
import java.time.LocalDate;

@Service
public class MaterialService {

    @Autowired
    private MaterialRepository materialRepository;


    public List<Material> getAllMaterials() {
        return materialRepository.findAll();
    }

    public Boolean isExistMaterial(String materialname){
        Boolean check = false;
        if (materialRepository.findMaterialByMaterialname(materialname) != null){
            check = true;
        } else {
            check = false;
        }
        return check;
    }



    public String createMaterial(Material material){
        String message = "";
        if(material.getMaterialname() == "" || material.getUnitprice() == 0 || material.getUnit() == ""){
            message = "Input not valid";
            return message;
        }
        if (isExistMaterial(material.getMaterialname()) == true){
            message = "Material is existed !";
            return message;
        } else {
            Material result = materialRepository.save(
                    new Material(
                            material.getMaterialname(),
                            material.getUnit(),
                            0,
                            material.getUnitprice()
                    )
            );
            message = "Create Successfully";
            return message;
        }
    }

    public Material updateMaterial(Integer id_material, Material material){
        if(materialRepository.findMaterialById(id_material) == null){
            return null;
        } else {
            if(isExistMaterial(material.getMaterialname()) == false){
                Material fromDB = materialRepository.findMaterialById(id_material);
                fromDB.setQuantity(material.getQuantity());
                fromDB.setMaterialname(material.getMaterialname());
                fromDB.setUnit(material.getUnit());
                fromDB.setUnitprice(material.getUnitprice());
                materialRepository.save(fromDB);
                return fromDB;
            } else {
             return null;
            }
        }
    }

    public void deleteMaterial(Integer id_material){
        materialRepository.deleteById(id_material);
    }

    public Material getMaterial(Integer id_material) {
        return materialRepository.findMaterialById(id_material);
    }


}
