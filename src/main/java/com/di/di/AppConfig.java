package com.di.di;

import com.di.di.repositories.ProductRepository;
import com.di.di.repositories.ProductRepositoryJson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {

    @Bean("productJson")
    @Primary
    public ProductRepository productRepositoryJson(){
        return new ProductRepositoryJson();
    }
}
