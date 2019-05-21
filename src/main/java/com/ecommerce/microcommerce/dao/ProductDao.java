package com.ecommerce.microcommerce.dao;

import com.ecommerce.microcommerce.model.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {
        List<Product> findAll();
        Product findById(int id);
        Product save(Product product);
        Product deleteById(int id);
        List<Product> findByStockGreaterThan(int stock);

    }


