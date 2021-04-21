package com.example.cafeserver.staff.repo;

import com.example.cafeserver.staff.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StaffRepository extends JpaRepository<Staff, Integer> {
    Staff findStaffByFullname(String fullname);
    Staff findStaffByAddress(String address);
    Staff findStaffByPhone(String phone);
    Staff findStaffByPosition(String position);
    Staff findStaffById(Integer id);

}
