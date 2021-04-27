package com.example.cafeserver.repo;

import com.example.cafeserver.model.Product;
import com.example.cafeserver.model.ProductOrder;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{
    Product findProductById(Integer id);
    Product findProductByProductname(String productname);
}