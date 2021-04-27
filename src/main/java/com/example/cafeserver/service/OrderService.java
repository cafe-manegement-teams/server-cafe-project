package com.example.cafeserver.service;

import com.example.cafeserver.model.Orders;
import com.example.cafeserver.model.Product;
import com.example.cafeserver.model.ProductOrder;
import com.example.cafeserver.repo.OrdersRepository;
import com.example.cafeserver.repo.ProductOrderRepository;
import com.example.cafeserver.repo.ProductRepository;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;
@Service
public class OrderService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private ProductOrderRepository productOrderRepository;

    @Autowired
    private ProductRepository productRepository;

    public Orders createOrder(Orders orders){
        Date date = new Date();
        Orders results = ordersRepository.save(
                new Orders(
                        LocalDate.now(),    
                        0.0,
                        "PENDING !"
                )
        );
        return results;
    }

    public ProductOrder addProductToOrder(Integer order_id ,Product product, Integer quantity) {
        Orders orders = ordersRepository.findOrdersById(order_id);
        if(orders == null) { return null; }
        Product products = productRepository.findProductById(product.getId());
        ProductOrder productOrder = new ProductOrder();
        productOrder.setProduct(products);
        productOrder.setQuantity(quantity);
        productOrder.setSubtotal(products.getPrice() * quantity);
        productOrder.setOrder(orders);
        productOrderRepository.save(productOrder);
        return productOrder;
    }

    public Orders order(Integer order_id){
        Orders orders = ordersRepository.findOrdersById(order_id);
        orders.setStatus("ORDERED !");
        double total = 0;
        Set<ProductOrder> productInOrder = getDetailInOrder(order_id);
        for (ProductOrder i : productInOrder){
            total = total + i.getSubtotal();
        }
        orders.setTotal(total);
        ordersRepository.save(orders);
        return orders;
    }

    public Set<ProductOrder> getDetailInOrder(Integer order_id){
        return productOrderRepository.findProductOrdersByOrders(ordersRepository.findOrdersById(order_id));
    }

    public void deleteOrder(Integer order_id) {
        Set<ProductOrder> products = getDetailInOrder(order_id);
        productOrderRepository.deleteAll(products);
        ordersRepository.deleteById(order_id);
    }

}
