package com.example.cafeserver.service;

import com.example.cafeserver.model.Product;
import com.example.cafeserver.repo.ProductRepository;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Boolean isProductExist(String productname) {
        Boolean result = false;
        Product product = productRepository.findProductByProductname(productname);
        if(product != null) {
            result = true;
        }
        return result;
    }

    public Product createProduct(Product product){
        if(product.getProductname() == null || product.getPrice() == null) {
            return new Product();
        }
        Boolean check = isProductExist(product.getProductname());
        if (check == false) {
            productRepository.save(product);
        }
        return product;
    }

    public Product updateProduct(Integer id_product, Product product) {
        Product fromDB = productRepository.findProductById(id_product);
        if(product.getProductname() == "" || product.getProductname() == null
                || product.getPrice() == null || product.getPrice() == 0 ) {
            return new Product();
        }
        if (fromDB != null) {
            fromDB.setProductname(product.getProductname());
            fromDB.setPrice(product.getPrice());
            productRepository.save(fromDB);
            return fromDB;
        } else {
            return new Product();
        }
    }

    public void deleteProduct(Integer id_product) {
        productRepository.deleteById(id_product);
    }

    public Product getProduct(Integer id_product) {
        return productRepository.findProductById(id_product);
    }

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }
}
