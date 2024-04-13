package com.di.di.repositories;

import com.di.di.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

//@Primary
@Repository("productList")
public class ProductRepositoryImpl implements ProductRepository {

    private List<Product> data;

    public ProductRepositoryImpl() {
        this.data = Arrays.asList(
                new Product(1l, "Memory Corsair 32", 300L),
                new Product(2l, "Cpu Intel Core I9", 850L),
                new Product(3l, "Keyboard Genius mini 60%", 180L),
                new Product(4l, "Motherboard Gigabyte", 490L)
        );
    }

    @Override
    public List<Product> getData() {
        return data;
    }

    @Override
    public Product getById(Long id) {
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }
}
