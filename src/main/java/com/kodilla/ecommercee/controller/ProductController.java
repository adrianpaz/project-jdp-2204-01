package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.exception.ProductNotFoundException;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.dto.ProductDto;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.service.ProductDBService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductDBService productDBService;
    private final ProductMapper productMapper;

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<Product> products = productDBService.getAllProducts();
        return ResponseEntity.ok(productMapper.mapToProductDtoList(products));
    }

    @GetMapping(value = "{productId}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable Long productId) throws ProductNotFoundException {
        return ResponseEntity.ok(productMapper.mapToProductDto(productDBService.getProductById(productId)));
    }

    @DeleteMapping(value = "{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
        productDBService.deleteProduct(productId);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "{productId}")
    public ResponseEntity<Void> updateProduct(@RequestBody ProductDto productDto, @PathVariable Long productId) throws ProductNotFoundException {
        Product productToUpdate = productDBService.getProductById(productId);
        Product updatedProduct = productMapper.mapToUpdatedProduct(productDto, productToUpdate);
        productDBService.saveProduct(updatedProduct);
        return ResponseEntity.ok().build();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createProduct(@RequestBody ProductDto productDto) {
        Product product = productMapper.mapToProduct(productDto);
        productDBService.saveProduct(product);
        return ResponseEntity.ok().build();
    }
}
