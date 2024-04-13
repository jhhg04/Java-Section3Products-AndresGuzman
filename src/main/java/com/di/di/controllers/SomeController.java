package com.di.di.controllers;

import com.di.di.models.Product;
import com.di.di.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SomeController {

    @Autowired
    private ProductService service;

    @GetMapping
    public List<Product> list() {
        return service.getData();
    }

    @GetMapping("/{id}")
    public Product show(@PathVariable Long id) {
        return service.getById(id);
    }
}
