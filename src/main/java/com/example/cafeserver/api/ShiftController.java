package com.example.cafeserver.api;


import com.example.cafeserver.model.Shift;
import com.example.cafeserver.repo.ShiftRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("api/shift")
public class ShiftController {
    @Autowired
    private ShiftRepository shiftRepository;

    @PostMapping(path = "/create")
    @CrossOrigin(origins = "http://localhost:3000")
    public @ResponseBody Shift createShift (@RequestBody Shift shift) {
        return shiftRepository.save(shift);
    }

    @GetMapping(path="all")
    @CrossOrigin(origins = "http://localhost:3000")
    public @ResponseBody List<Shift> getAllShift(){
        return shiftRepository.findAll();
    }

    @GetMapping(path = "{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public @ResponseBody Shift getShift(@PathVariable(name = "id") Integer id){
        return shiftRepository.findShiftById(id);
    }

}
