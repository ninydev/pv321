package org.itstep.first.modules.product.services;

import org.itstep.first.modules.product.dto.CreateProductDto;
import org.itstep.first.modules.product.entities.ProductModel;
import org.itstep.first.modules.product.mappers.ProductMapper;
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

    public ProductModel create(CreateProductDto productDto) {
        ProductModel product = new ProductModel(null, productDto.getName(), productDto.getPrice()); // = ProductMapper.INSTANCE.toModel(productDto);
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
