package com.ecommerce.microcommerce.web.controller;

import com.ecommerce.microcommerce.dao.ProductDao;

import com.ecommerce.microcommerce.model.Product;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;



import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductDao productDao;


    @GetMapping(value = "/Produits")
    public List<Product> listeProduits() {
        return productDao.findAll();
    }

    @GetMapping(value = "/Produits/{id}")
    public Product afficherUnProduit(@PathVariable int id) {
        return productDao.findById( id);

    }

    @GetMapping(value = "/Produits/Stock")
    public List<Product> afficherLeStock() {
        return productDao.findByStockGreaterThan(0);
    }

    //ajouter un produit
    @PostMapping(value = "/Produits")
    public void ajouterProduit(@RequestBody Product product) {
        productDao.save(product);
    }

    @DeleteMapping (value = "/Produits/{id}")
    public void supprimerProduit(@PathVariable int id) {

        productDao.deleteById(id);
    }

    @PutMapping (value = "/Produits")
    public void updateProduit(@RequestBody Product product) {

        productDao.save(product);
    }




}
