package com.di.di.repositories;

import com.di.di.models.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> getData();

    Product getById(Long id);
}
