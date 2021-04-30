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
    public @ResponseBody Shift createShift (@RequestBody Shift shift) {
        return shiftRepository.save(shift);
    }

    @GetMapping(path="all")
    public @ResponseBody List<Shift> getAllShift(){
        return shiftRepository.findAll();
    }

    @GetMapping(path = "{id}")
    public @ResponseBody Shift getShift(@PathVariable(name = "id") Integer id){
        return shiftRepository.findShiftById(id);
    }

}
