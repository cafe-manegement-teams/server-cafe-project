package com.example.cafeserver.staff.service;


import com.example.cafeserver.staff.model.Staff;
import com.example.cafeserver.staff.repo.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;

    public Boolean isStaffExist(String fullname) {
        Boolean result = true ;
        try {
            Staff staff = staffRepository.findStaffByFullname(fullname);
//            System.out.println(staff.getFullname());
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



    public String addStaff(Staff staff) {
        Boolean checkStaff = isStaffExist(staff.getFullname());
        if(checkStaff == true) {
            return "Staff is already added";
        } else {
            staffRepository.save(staff);
        }
        return "Create Staff Successfully";
    }

    public void editStaff(Staff staff) {
         Staff updateStaff = staffRepository.getOne(staff.getId());
         updateStaff = staff;
         staffRepository.save(updateStaff);
    }

}
