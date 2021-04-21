package com.example.cafeserver.staff.api;


import com.example.cafeserver.staff.model.Staff;
import com.example.cafeserver.staff.repo.StaffRepository;
import com.example.cafeserver.staff.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @Autowired
    private StaffRepository staffRepository;



    @PostMapping(path = "/create")
    @CrossOrigin(origins = "http://localhost:3000")
    public @ResponseBody String createStaff (@RequestBody Staff staff) {
        return staffService.addStaff(staff);
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public @ResponseBody Iterable<Staff>    getAllStaff(){
        return staffRepository.findAll();
    }

    @DeleteMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public @ResponseBody String deleteStaff(@RequestParam(name = "id") Integer id){
         staffRepository.deleteById(id);
         return "Deleted Successfully";
    }

    @PutMapping(path = "/update")
    @CrossOrigin(origins = "http://localhost:3000")
    public @ResponseBody String updateStaff(@RequestBody Staff staff){
        staffService.editStaff(staff);
        return "Update Successfully";
    }

    @GetMapping(path = "/infor/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public @ResponseBody Staff getInforStaff(@PathVariable(name = "id") Integer id){
        return staffRepository.findStaffById(id);
       // return staff.getFullname() + staff.getDatebirth() + staff.getPhone() + staff.getAddress() + staff.getPosition();
    }


}
