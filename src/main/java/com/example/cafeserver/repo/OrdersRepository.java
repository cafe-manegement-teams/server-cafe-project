package com.example.cafeserver.repo;

import java.util.Set;

import com.example.cafeserver.model.Orders;
import com.example.cafeserver.model.ProductOrder;
import org.springframework.data.jpa.repository.*;
public interface OrdersRepository extends JpaRepository<Orders, Integer> {
    Orders findOrdersById(Integer id);
    Set<ProductOrder> findAllProductById(Integer id);

}
