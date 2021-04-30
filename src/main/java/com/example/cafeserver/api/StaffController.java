package com.example.cafeserver.api;


import com.example.cafeserver.model.Staff;
import com.example.cafeserver.repo.StaffRepository;
import com.example.cafeserver.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @Autowired
    private StaffRepository staffRepository;


    @GetMapping(path ="staff/all")
    @CrossOrigin(origins = "http://localhost:3000")
    public @ResponseBody
    List<Staff> getAllStaff(){
        return staffService.getAllStaffs();
    }

    @PostMapping(path = "shift/{id_shift}/position/{id_position}/staff/create")
    @CrossOrigin(origins = "http://localhost:3000")
    public @ResponseBody
    String createStaff (@RequestBody Staff staff,
                       @PathVariable(name="id_shift") Integer id_shift,
                       @PathVariable(name="id_position") Integer id_position) {
        return staffService.addStaff(staff,id_shift,id_position);
    }

    @PutMapping(path = "staff/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public @ResponseBody String updateStaff(@PathVariable(name = "id") Integer staff_id,
                                            @RequestBody Staff staff){
        return staffService.editStaff(staff_id,staff);
    }

    @DeleteMapping(path = "staff/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public @ResponseBody String deleteStaff(@PathVariable(name = "id") Integer id){
        staffRepository.deleteById(id);
        return "Deleted";
    }


    @GetMapping(path = "staff/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public @ResponseBody Staff getInforStaff(@PathVariable(name = "id") Integer staff_id){
        return staffService.getInformationStaff(staff_id);
    }

    @GetMapping(path = "shift/{id}/all")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Staff> getAllStaffInShift(@PathVariable(name="id") Integer shift_id){
        return staffService.getAllStaffInShift(shift_id);
    }

    @GetMapping(path = "position/{id}/all")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Staff> getAllStaffInPosition(@PathVariable(name="id") Integer position_id){
        return staffService.getAllStaffInPosition(position_id);
    }

}
