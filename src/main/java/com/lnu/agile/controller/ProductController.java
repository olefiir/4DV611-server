package com.lnu.agile.controller;

import com.lnu.agile.model.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by olefir on 11/23/2015.
 */

@RestController
@RequestMapping("/products")
public class ProductController {


    @RequestMapping("/{productId}")
    public Product getProductById(@RequestParam(value="id", required = true) String productId) {
        long id = Long.parseLong(productId);
        return new Product(id);
    }

    @RequestMapping("/")
    public List<Product> getAllProducts() {
        return new ArrayList<Product>();
    }

}
