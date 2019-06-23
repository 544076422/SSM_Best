package cn.rbc.service.impl;

import cn.rbc.dao.ProductDao;
import cn.rbc.domain.Product;
import cn.rbc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Override
    public List<Product> findAll() {
        List<Product> products = productDao.findAll();
        return products;
    }

    @Override
    public void save(Product product) {
        productDao.save(product);
    }
}
