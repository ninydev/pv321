package org.itstep.first.modules.product.controllers;

import org.itstep.first.modules.product.entities.ProductModel;
import org.itstep.first.modules.product.repositories.ProductRepository;
import org.itstep.first.modules.product.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ApiProductController {

    private final ProductService productService;

    public ApiProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductModel> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductModel> getProductById(@PathVariable Long id) {
        Optional<ProductModel> product = Optional.ofNullable(productService.findById(id));
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ProductModel createProduct(@RequestBody ProductModel product) {
        return productService.save(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductModel> updateProduct(@PathVariable Long id, @RequestBody ProductModel productDetails) {
        Optional<ProductModel> product = Optional.ofNullable(productService.findById(id));
        if (product.isPresent()) {
            ProductModel updatedProduct = product.get();
            updatedProduct.setName(productDetails.getName());
            updatedProduct.setPrice(productDetails.getPrice());
            return ResponseEntity.ok(productService.save(updatedProduct));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        Optional<ProductModel> product = Optional.ofNullable(productService.findById(id));
        if (product.isPresent()) {
            productService.delete(product.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}