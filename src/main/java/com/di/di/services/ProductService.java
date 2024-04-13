package com.di.di.services;

import com.di.di.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getData();

    Product getById(Long id);
}
