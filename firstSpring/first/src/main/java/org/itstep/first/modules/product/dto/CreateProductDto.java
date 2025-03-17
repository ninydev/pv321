package org.itstep.first.modules.product.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.itstep.first.modules.product.entities.ProductModel;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductDto {

    @Schema(description = "Name must have from 8 to 32 chars")
    @Size(min = 8, max = 32)
    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotNull(message = "Price is mandatory")
    @Positive(message = "Price must be positive")
    @Schema(description = "Price must be a positive value")
    private Double price;


//    public ProductModel create() {
//        return new ProductModel(null, name, price);
//    }
}