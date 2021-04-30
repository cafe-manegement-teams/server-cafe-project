package com.example.cafeserver.repo;

import com.example.cafeserver.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StaffRepository extends JpaRepository<Staff, Integer> {
    Staff findStaffByFullname(String fullname);
    Staff findStaffByAddress(String address);
    Staff findStaffByPhone(String phone);
    Staff findStaffById(Integer id);
}
