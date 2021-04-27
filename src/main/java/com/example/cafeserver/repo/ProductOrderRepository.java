package com.example.cafeserver.repo;

import com.example.cafeserver.model.Orders;
import com.example.cafeserver.model.ProductOrder;
import org.springframework.data.jpa.repository.*;

import java.util.Set;


public interface ProductOrderRepository extends  JpaRepository<ProductOrder, Integer> {
    ProductOrder findProductOrderById(Integer id);
    Set<ProductOrder> findProductOrdersByOrders(Orders orders);
}
