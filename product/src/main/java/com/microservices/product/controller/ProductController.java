package com.microservices.product.controller;

import com.microservices.product.controller.request.ProductRequest;
import com.microservices.product.controller.response.ProductResponse;
import com.microservices.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public void createProduct(@RequestBody ProductRequest productRequest) {
        productService.createProduct(productRequest.toProduct());
    }

    @GetMapping(value = "/{id}")
    public ProductResponse getProduct(@PathVariable("id") Long id) {
        return ProductResponse.fromProduct(productService.getProduct(id));
    }
}
