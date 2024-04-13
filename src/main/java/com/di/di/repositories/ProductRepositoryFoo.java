package com.di.di.repositories;

import com.di.di.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

//@Primary
@Repository("productFoo")
public class ProductRepositoryFoo implements ProductRepository {
    @Override
    public List<Product> getData() {
        return Collections.singletonList(new Product(1L, "Monitor Asus 27", 600L));
    }

    @Override
    public Product getById(Long id) {
        return new Product(id, "Monitor Asus 27", 600L);
    }
}
