package com.example.cafeserver.api;
import com.example.cafeserver.model.Material;
import com.example.cafeserver.service.MaterialService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/material")
public class MaterialController {

    @Autowired
    private MaterialService materialService;


    @GetMapping(path="all")
    public @ResponseBody
    List<Material> getAllMaterials(){
        return materialService.getAllMaterials();
    }

    @PostMapping(path="create")
    public @ResponseBody
    String addMaterial(@RequestBody Material material){
            return materialService.createMaterial(material);
    }

    @PutMapping(path = "{id}")
    public @ResponseBody
    Material updateProduct(@PathVariable(name = "id") Integer id_material,
                          @RequestBody Material material) {
        return materialService.updateMaterial(id_material,material);
    }

    @DeleteMapping(path="{id}/delete")
    public void deleteMaterial(@PathVariable(name="id") Integer id_material){
        materialService.deleteMaterial(id_material);
    }

    @GetMapping(path="{id}")
    public @ResponseBody
    Material getMaterial(@PathVariable(name="id") Integer id_material){
        return materialService.getMaterial(id_material);
    }


}
