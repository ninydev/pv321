package org.itstep.first.modules.product.mappers;

import org.itstep.first.modules.product.dto.CreateProductDto;
import org.itstep.first.modules.product.entities.ProductModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductModel toModel(CreateProductDto dto);
    CreateProductDto toDto(ProductModel model);
}