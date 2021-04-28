package com.example.cafeserver.service;

import com.example.cafeserver.model.Orders;
import com.example.cafeserver.model.Product;
import com.example.cafeserver.model.ProductOrder;
import com.example.cafeserver.model.TakeOrder;
import com.example.cafeserver.repo.OrdersRepository;
import com.example.cafeserver.repo.ProductOrderRepository;
import com.example.cafeserver.repo.ProductRepository;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
@Service
public class OrderService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private ProductOrderRepository productOrderRepository;

    @Autowired
    private ProductRepository productRepository;

    public Integer createOrder(Orders orders){
        Date date = new Date();
        Orders results = ordersRepository.save(
                new Orders(
                        LocalDate.now(),
                        0.0,
                        "PENDING !"
                )
        );
        return results.getId();
    }

    public List<ProductOrder> addAllProductInOrder(Integer order_id,List<TakeOrder> takeOrderList) {
        Orders orders = ordersRepository.findOrdersById(order_id);
        List<ProductOrder> productOrderList = new ArrayList<ProductOrder>();
        for(TakeOrder i : takeOrderList){
            if(productRepository.findProductById(i.product_id) == null){
                return productOrderList;
            } else {
                if(i.quantity == 0) {
                    return new ArrayList<ProductOrder>();
                } else {
                    ProductOrder productOrder =new ProductOrder();
                    Product product = productRepository.findProductById(i.product_id);
                    productOrder.setOrder(orders);
                    productOrder.setProduct(product);
                    productOrder.setQuantity(i.quantity);
                    productOrder.setSubtotal(product.getPrice() * i.quantity);
                    productOrderList.add(productOrder);
                }
            }
        }
        productOrderRepository.saveAll(productOrderList);
        return productOrderList;
    }

    public void addSingleProduct(String productname,Orders orders, Integer quantity, List<ProductOrder> productOrderList){
        ProductOrder productOrder = new ProductOrder();
        Product product = productRepository.findProductByProductname(productname);
        productOrder.setOrder(orders);
        productOrder.setProduct(product);
        productOrder.setQuantity(quantity);
        productOrderList.add(productOrder);
    }

    public ProductOrder addProduct(Integer quantity, Orders orders, Product products) {
        ProductOrder productOrder = new ProductOrder();
        productOrder.setProduct(products);
        productOrder.setQuantity(quantity);
        productOrder.setSubtotal(products.getPrice() * quantity);
        productOrder.setOrder(orders);
        productOrderRepository.save(productOrder);
        return productOrder;
    }

    public ProductOrder addProductToOrderById(Integer order_id ,Product product, Integer quantity) {
        Orders orders = ordersRepository.findOrdersById(order_id);
        if(orders == null) { return null; }
        Product products = productRepository.findProductById(product.getId());
        return addProduct(quantity, orders, products);
    }

    public ProductOrder addProductToOrderByName(Integer order_id, Product product, Integer quantity) {
        Orders orders = ordersRepository.findOrdersById(order_id);
        if(orders == null) { return null; }
            Product products = productRepository.findProductByProductname(product.getProductname());
            return addProduct(quantity, orders, products);
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

    public List<Orders> getAllOrder(){
        return ordersRepository.findAll();
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
