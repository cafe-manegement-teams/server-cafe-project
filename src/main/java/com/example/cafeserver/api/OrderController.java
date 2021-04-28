package com.example.cafeserver.api;



import com.example.cafeserver.model.Orders;
import com.example.cafeserver.model.Product;
import com.example.cafeserver.model.ProductOrder;
import com.example.cafeserver.service.OrderService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(path="create")
    @CrossOrigin(origins = "http://localhost:3000")
    public @ResponseBody
    Orders createOrder(@RequestBody Orders order){
        return orderService.createOrder(order);
    }


    @PostMapping(path="{order_id}/add/{quantity}")
    @CrossOrigin(origins = "http://localhost:3000")
    public @ResponseBody
    ProductOrder addProductToOrderById(@PathVariable(name="order_id") Integer order_id,
                              @RequestBody Product product,
                              @PathVariable(name="quantity") Integer quantity){
        return orderService.addProductToOrderByName(order_id,product,quantity);
    }


    @GetMapping(path="{order_id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public @ResponseBody
    Set<ProductOrder> getDetailInOrder(@PathVariable(name = "order_id") Integer order_id){
        return orderService.getDetailInOrder(order_id);
    }

    @PostMapping(path = "{id}/print")
    @CrossOrigin(origins = "http://localhost:3000")
    public @ResponseBody
    Orders order(@PathVariable(name = "id") Integer id_product) {
        return orderService.order(id_product);
    }

    @DeleteMapping(path = "{id}/delete")
    @CrossOrigin(origins = "http://localhost:3000")
    public String deleteOrder(@PathVariable(name = "id") Integer order_id){
        orderService.deleteOrder(order_id);
        return "Deleted Order !";
    }

    @GetMapping(path = "all")
    @CrossOrigin(origins = "http://localhost:3000")
    public @ResponseBody
    List<Orders> getAllOrders(){
        return orderService.getAllOrder();
    }


}
