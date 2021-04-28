package com.example.cafeserver.api;


import com.example.cafeserver.model.Product;
import com.example.cafeserver.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping(path = "all")
    @CrossOrigin(origins = "http://localhost:3000")
    public @ResponseBody
    List<Product> getAllProduct() {
        return productService.getAllProduct();
    }

    @PostMapping(path = "create")
    @CrossOrigin(origins = "http://localhost:3000")
    public @ResponseBody
    Product addProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @PutMapping(path = "{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public @ResponseBody
    Product updateProduct(@PathVariable(name = "id") Integer id_product,
                               @RequestBody Product product) {
        return productService.updateProduct(id_product,product);
    }

    @DeleteMapping(path = "/delete/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public void deleteProduct(@PathVariable(name = "id") Integer id_product) {
        productService.deleteProduct(id_product);
    }

    @GetMapping(path = "{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public @ResponseBody
    Product getProductInformation(@PathVariable(name = "id") Integer id_product) {
        return productService.getProduct(id_product);
    }

}
