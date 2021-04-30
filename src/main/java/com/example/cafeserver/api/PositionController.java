package com.example.cafeserver.api;


import com.example.cafeserver.model.Position;
import com.example.cafeserver.repo.PositionRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/position")
public class PositionController {

    @Autowired
    private PositionRepository positionRepository;

    @PostMapping(path = "/create")
    @CrossOrigin(origins = "http://localhost:3000")
    public @ResponseBody Position createPosition (@RequestBody Position position) {
        return positionRepository.save(position);
    }

    @GetMapping(path="all")
    @CrossOrigin(origins = "http://localhost:3000")
    public @ResponseBody
    List<Position> getAllPosition(){
        return positionRepository.findAll();
    }

    @DeleteMapping(path = "{id}/delete")
    @CrossOrigin(origins = "http://localhost:3000")
    public @ResponseBody String deletePosition(@PathVariable(name = "id") Integer id){
         positionRepository.deleteById(id);
         return "Deleted";
    }

    @GetMapping(path = "{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public @ResponseBody Position getPosition(@PathVariable(name = "id") Integer id){
        return positionRepository.findPositionById(id);
    }


}
