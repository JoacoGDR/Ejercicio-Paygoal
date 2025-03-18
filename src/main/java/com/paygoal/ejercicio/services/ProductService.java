package com.paygoal.ejercicio.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

import com.paygoal.ejercicio.dtos.ProductRequest;
import com.paygoal.ejercicio.dtos.ProductResponse;
import com.paygoal.ejercicio.exceptions.ProductNotFoundException;
import com.paygoal.ejercicio.models.Product;
import com.paygoal.ejercicio.repositories.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional
    public ProductResponse createProduct(ProductRequest request) {
        Product product = Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .quantity(request.getQuantity())
                .build();
        productRepository.save(product);
        log.info("Product created: {}", product);
        return ProductResponse.fromProduct(product);
    }

    @Transactional
    public ProductResponse updateProduct(Long id, ProductRequest request) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setName(request.getName());
            product.setDescription(request.getDescription());
            product.setPrice(request.getPrice());
            product.setQuantity(request.getQuantity());
            productRepository.save(product);
            log.info("Product updated: {}", product);
            return ProductResponse.fromProduct(product);
        } else {
            throw new ProductNotFoundException("Product not found");
        }
    }

    public Optional<ProductResponse> getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.map(ProductResponse::fromProduct);
    }

    public Optional<ProductResponse> getProductByName(String name) {
        Optional<Product> product = productRepository.findByName(name);
        return product.map(ProductResponse::fromProduct);
    }

    @Transactional
    public void deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            log.info("Product with id {} deleted", id);
        } else {
            throw new ProductNotFoundException("Product not found");
        }
    }

    public List<ProductResponse> getAllProductsOrderedByPrice() {
        List<Product> products = productRepository.findAllByOrderByPriceAsc();
        return products.stream()
                .map(ProductResponse::fromProduct).collect(Collectors.toList());
    }


}
