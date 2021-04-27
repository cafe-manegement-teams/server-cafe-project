package com.example.cafeserver.api;



import com.example.cafeserver.model.Orders;
import com.example.cafeserver.model.Product;
import com.example.cafeserver.model.ProductOrder;
import com.example.cafeserver.service.OrderService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

@RestController
@RequestMapping("api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(path="create")
    public @ResponseBody
    Orders createOrder(@RequestBody Orders order){
        return orderService.createOrder(order);
    }


    @PostMapping(path="{order_id}/add/{quantity}")
    public @ResponseBody
    ProductOrder addProductToOrder(@PathVariable(name="order_id") Integer order_id,
                              @RequestBody Product product,
                              @PathVariable(name="quantity") Integer quantity){
        return orderService.addProductToOrder(order_id,product,quantity);
    }

    @GetMapping(path="{order_id}")
    public @ResponseBody
    Set<ProductOrder> getDetailInOrder(@PathVariable(name = "order_id") Integer order_id){
        return orderService.getDetailInOrder(order_id);
    }

    @PostMapping(path = "{id}/print")
    public @ResponseBody
    Orders order(@PathVariable(name = "id") Integer id_product) {
        return orderService.order(id_product);
    }

    @DeleteMapping(path = "{id}/delete")
    public String deleteOrder(@PathVariable(name = "id") Integer order_id){
        orderService.deleteOrder(order_id);
        return "Deleted Order !";
    }

}
