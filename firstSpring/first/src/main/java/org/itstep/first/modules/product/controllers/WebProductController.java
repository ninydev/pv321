package org.itstep.first.modules.product.controllers;


import jakarta.validation.Valid;
import org.itstep.first.modules.product.dto.CreateProductDto;
import org.itstep.first.modules.product.entities.ProductModel;
import org.itstep.first.modules.product.services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/products")
public class WebProductController {

    private final ProductService productService;

    public WebProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String index(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            org.springframework.ui.Model model
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ProductModel> productPage = productService.findAll(pageable);

        model.addAttribute("productPage", productPage);
        return "products/index";
    }

    @GetMapping("/create")
    public String create(org.springframework.ui.Model model) {
        model.addAttribute("product", new CreateProductDto());
        return "products/create";
    }

    @PostMapping
    public String create(@Valid CreateProductDto productDto,
                         BindingResult bindingResult,
                         @RequestParam("file") MultipartFile file,
                         org.springframework.ui.Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("product", productDto);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "products/create";
        }
        if (!file.isEmpty()) {
            // Process the file (e.g., save it to the server)
            // You can add your file processing logic here
        }
        productService.create(productDto);
        return "redirect:/products";
    }




}
