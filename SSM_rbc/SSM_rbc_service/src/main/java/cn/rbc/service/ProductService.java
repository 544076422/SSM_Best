package cn.rbc.service;

import cn.rbc.domain.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    void save(Product product);
}
