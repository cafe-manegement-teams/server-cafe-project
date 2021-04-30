package com.example.cafeserver.repo;
import com.example.cafeserver.model.DeliveryBill;
import org.springframework.data.jpa.repository.*;
public interface DeliveryBillRepo extends JpaRepository<DeliveryBill, Integer> {
    DeliveryBill findDeliveryBillById(Integer id);
}
