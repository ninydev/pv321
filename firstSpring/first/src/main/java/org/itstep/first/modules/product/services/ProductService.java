package org.itstep.first.modules.product.services;

import org.itstep.first.modules.product.entities.ProductModel;
import org.itstep.first.modules.product.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductModel> findAll() {
        return productRepository.findAll();
    }

    public ProductModel findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public ProductModel save(ProductModel product) {
        return productRepository.save(product);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public void delete(ProductModel product) {
        productRepository.delete(product);
    }

    public boolean existsById(Long id) {
        return productRepository.existsById(id);
    }

    public long count() {
        return productRepository.count();
    }

    public void deleteAll() {
        productRepository.deleteAll();
    }
}
