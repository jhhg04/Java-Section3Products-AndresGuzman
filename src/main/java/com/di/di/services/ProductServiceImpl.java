package com.di.di.services;

import com.di.di.models.Product;
import com.di.di.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    //@Qualifier("productList")
    private Environment environment;
    private ProductRepository repository;

    //public ProductServiceImpl(@Qualifier("productList") ProductRepository repository)
    public ProductServiceImpl(ProductRepository repository){
        this.repository = repository;
    }

    @Override
    public List<Product> getData() {
        return repository.getData().stream().map(
                p -> {
//                    Double priceTax = p.getPrice() * 1.25d;
                    Double priceTax = p.getPrice() * environment.getProperty("config.price.tax", Double.class);
                    // p.setPrice(priceImp.longValue());
                    // Product newProd = new Product(p.getId(), p.getName(), priceImp.longValue());
                    // return p;
                    // return newProd;
                    Product newProduct = (Product) p.clone();
                    newProduct.setPrice(priceTax.longValue());
                    return newProduct;
                }
        ).collect(Collectors.toList());
    }

    @Override
    public Product getById(Long id) {
        return repository.getById(id);
    }
}
