package org.itstep.first.modules.product.repositories;

import org.itstep.first.modules.product.entities.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductModel, Long> {
}
