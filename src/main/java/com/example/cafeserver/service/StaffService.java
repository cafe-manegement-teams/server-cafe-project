package com.example.cafeserver.service;


import com.example.cafeserver.model.Staff;
import com.example.cafeserver.repo.PositionRepository;
import com.example.cafeserver.repo.ShiftRepository;
import com.example.cafeserver.repo.StaffRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import java.util.List;
import java.util.ArrayList;

@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private ShiftRepository shiftRepository;

    @Autowired
    private PositionRepository positionRepository;

    public Boolean isStaffExist(String fullname) {
        Boolean result = true ;
        try {
            Staff staff = staffRepository.findStaffByFullname(fullname);
            if(staff !=  null) {
                result = true;
            } else {
                result = false;
            }
        }  catch (Exception exception) {
            exception.printStackTrace();
        }
        return result;
    }


    public String addStaff(Staff staff, Integer id_shift, Integer id_position) {
        String message = "Create Successfully !";
        if (staff.getFullname() == "" || staff.getAddress() == "" || staff.getDatebirth() == "" || staff.getPhone() == ""){
            if (staff.getFullname() == ""){
                return "Fill Full Name field !";
            }
            if (staff.getAddress() == ""){
                return "Fill Address field !";
            }
            if (staff.getPhone() == ""){
                return "Fill Phone field !";
            }
            if (staff.getDatebirth() == ""){
                return "Fill Date Of Birth field !";
            }
        }
        Boolean checkStaff = isStaffExist(staff.getFullname());
        if(checkStaff == true){
            return "Staff is already added !";
        }
        staff.setShift(shiftRepository.findShiftById(id_shift));
        staff.setPosition(positionRepository.findPositionById(id_position));
        staffRepository.save(staff);
        return message;
    }

    public String editStaff(Integer staff_id, Staff staff) {
        String message = "Update Successfully !";
        Boolean staffExist = isStaffExist(staff.getFullname());
        if(staffExist == true) {
            return "Staff is already added !";
        }
        if (staff.getFullname() == "" || staff.getAddress() == "" || staff.getDatebirth() == "" || staff.getPhone() == ""){
            if (staff.getFullname() == ""){
                return "Fill Full Name field !";
            }
            if (staff.getAddress() == ""){
                return "Fill Address field !";
            }
            if (staff.getPhone() == ""){
                return "Fill Phone field !";
            }
            if (staff.getDatebirth() == ""){
                return "Fill Date Of Birth field !";
            }
        }
        Staff fromDB = staffRepository.findStaffById(staff_id);
        fromDB.setFullname(staff.getFullname());
        fromDB.setDatebirth(staff.getDatebirth());
        fromDB.setAddress(staff.getAddress());
        fromDB.setPhone(staff.getPhone());
        staffRepository.save(fromDB);
        return message;
    }

    public Staff getInformationStaff(Integer staff_id){
        return staffRepository.findStaffById(staff_id);
    }

    public List<Staff> getAllStaffs(){
        return staffRepository.findAll();
    }

    public List<Staff> getAllStaffInPosition(Integer position_id){
        List<Staff> staffList = new ArrayList<Staff>();
        for (Staff i : staffRepository.findAll()){
            if(i.getPosition().getId() == position_id){
                staffList.add(i);
            }
        }
        return staffList;
    }

    public List<Staff> getAllStaffInShift(Integer shift_id){
        List<Staff> staffList = new ArrayList<Staff>();
        for (Staff i : staffRepository.findAll()){
            if(i.getShift().getId() == shift_id){
                staffList.add(i);
            }
        }
        return staffList;
    }
}
